package com.journaldev.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.journaldev.spring.model.Hotel;
import com.journaldev.spring.service.HotelService;

@Controller
public class HotelController {

    private HotelService hotelService;

    @Autowired(required=true)
    @Qualifier(value="hotelService")
    public void sethotelService(HotelService hs){
        this.hotelService = hs;
    }

    @RequestMapping(value = "/hotels", method = RequestMethod.GET)
    public String listHotels(Model model) {
        model.addAttribute("hotel", new Hotel());
        model.addAttribute("listHotels", this.hotelService.listHotels());
        return "hotel";
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
