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
//        model.addAttribute("hotel", new Hotel());
//        model.addAttribute("listHotels", this.hotelService.listHotels());
        return this.hotelService.listHotels();
    }

    //For add and update hotel both
    @RequestMapping(value= "/hotel/add", method = RequestMethod.POST)
    public String addHotel(@ModelAttribute("hotel") Hotel h){

        if(h.getId() == 0){
            //new hotel, add it
            this.hotelService.addHotel(h);
        }else{
            //existing hotel, call update
            this.hotelService.updateHotel(h);
        }

        return "redirect:/hotels";

    }

    @RequestMapping("/remove/{id}")
    public String removeHotel(@PathVariable("id") int id){

        this.hotelService.removeHotel(id);
        return "redirect:/hotels";
    }

    @RequestMapping("/edit/{id}")
    public String editHotel(@PathVariable("id") int id, Model model){
        model.addAttribute("hotel", this.hotelService.getHotelById(id));
        model.addAttribute("listhotels", this.hotelService.listHotels());
        return "hotel";
    }

}
