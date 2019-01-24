package com.chanaka.springMVC;

import com.chanaka.springMVC.Util.CommonUtils;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.chanaka.springMVC.model.Room;
import com.chanaka.springMVC.service.RoomService;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
    public List<Room> addRoom(@ModelAttribute("room") Room h,
                              @RequestParam(value = "id", required = false) String id,
                              @RequestParam("name") String name,
                              @RequestParam("address") String address,
                              @RequestParam("city") String City,
                              @RequestParam("country") String Country)
    {
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

    //For search rooms
//    @RequestMapping(value= "/room/search", method = RequestMethod.POST)
//    public List<Room> searchRoom(@ModelAttribute("room") Room r, @RequestParam(value = "checkIn", required = false) String checkIn,
//                                  @RequestParam(value = "checkOut", required = false) String checkOut,
//                                  @RequestParam(value = "noOfNights", required = false) String noOfNights,
//                                  @RequestParam(value = "roomsReq", required = false) String roomsReq,
//                                  @RequestParam(value = "noOfAdults", required = false) String noOfAdults)
//    {
//
//        Date convertedStartDate = CommonUtils.convertStringToDate(checkIn);
//        Date convertedEndDate = CommonUtils.calculateCheckoutDate(convertedStartDate, noOfNights);
//        roomsReq = (roomsReq == null) ? "0" : roomsReq;
//        noOfAdults = (noOfAdults == null) ? "0" : noOfAdults;
//        return this.roomService.searchRoom(convertedStartDate, convertedEndDate, Integer.parseInt(roomsReq), Integer.parseInt(noOfAdults));
//
//    }

    @RequestMapping(value= "/room/search", method = RequestMethod.POST)
    public List<Room> searchRoom(@RequestBody ObjectNode request)
    {
        String checkIn = request.get("checkIn").asText();
        String noOfNights = request.get("noOfNights").asText();
        String roomsReq = (request.has("roomsReq")) ? request.get("roomsReq").asText() : "0";
        String noOfAdults = (request.has("noOfAdults")) ? request.get("noOfAdults").asText() : "0";

        Date convertedStartDate = CommonUtils.convertStringToDate(checkIn);
        Date convertedEndDate = CommonUtils.calculateCheckoutDate(convertedStartDate, noOfNights);
        return this.roomService.searchRoom(convertedStartDate, convertedEndDate, Integer.parseInt(roomsReq), Integer.parseInt(noOfAdults));

    }

}
