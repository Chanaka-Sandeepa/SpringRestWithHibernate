package com.chanaka.springMVC;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.chanaka.springMVC.model.Hotel;
import com.chanaka.springMVC.service.HotelService;

import java.util.List;

@RestController
public class HotelController {

    private HotelService hotelService;

    @Autowired(required=true)
    @Qualifier(value="hotelService")
    public void sethotelService(HotelService hs){
        this.hotelService = hs;
    }

    @RequestMapping(value = "/hotels", method = RequestMethod.GET, produces="application/json")
    @ResponseBody
    public List<Hotel> listHotels(Model model) {
        return this.hotelService.listHotels();
    }

    //For add and update hotel both
    @RequestMapping(value= "/hotel/add", method = RequestMethod.POST)
    public List<Hotel> addHotel(@ModelAttribute("hotel") Hotel h, @RequestParam(value = "id", required = false) String id, @RequestParam("name") String name,
                           @RequestParam("address") String address, @RequestParam("city") String City,@RequestParam("country") String Country){
        if (id != null){
            this.hotelService.updateHotel(h);
        }else {
            this.hotelService.addHotel(h);
        }
        return this.hotelService.listHotels();
    }

    @RequestMapping("/remove/{id}")
    public List<Hotel> removeHotel(@PathVariable("id") int id){

        this.hotelService.removeHotel(id);
        return this.hotelService.listHotels();
    }

//    @RequestMapping("/edit/{id}")
//    public String editHotel(@PathVariable("id") int id, Model model){
//        model.addAttribute("hotel", this.hotelService.getHotelById(id));
//        model.addAttribute("listhotels", this.hotelService.listHotels());
//        return "hotel";
//    }

}
