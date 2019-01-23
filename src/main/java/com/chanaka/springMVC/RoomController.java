package com.chanaka.springMVC;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.chanaka.springMVC.model.Room;
import com.chanaka.springMVC.service.RoomService;

import java.util.List;

@RestController
public class RoomController {

    private RoomService roomService;

    @Autowired(required=true)
    @Qualifier(value="roomService")
    public void setroomService(RoomService hs){
        this.roomService = hs;
    }

    @RequestMapping(value = "/rooms", method = RequestMethod.GET, produces="application/json")
    @ResponseBody
    public List<Room> listRooms(Model model) {
        return this.roomService.listRooms();
    }

    //For add and update room both
    @RequestMapping(value= "/room/add", method = RequestMethod.POST)
    public List<Room> addRoom(@ModelAttribute("room") Room h, @RequestParam(value = "id", required = false) String id, @RequestParam("name") String name,
                                @RequestParam("address") String address, @RequestParam("city") String City,@RequestParam("country") String Country){
        if (id != null){
            this.roomService.updateRoom(h);
        }else {
            this.roomService.addRoom(h);
        }
        return this.roomService.listRooms();
    }

    @RequestMapping("room/remove/{id}")
    public List<Room> removeRoom(@PathVariable("id") int id){

        this.roomService.removeRoom(id);
        return this.roomService.listRooms();
    }

//    @RequestMapping("/edit/{id}")
//    public String editRoom(@PathVariable("id") int id, Model model){
//        model.addAttribute("room", this.roomService.getRoomById(id));
//        model.addAttribute("listrooms", this.roomService.listRooms());
//        return "room";
//    }

}