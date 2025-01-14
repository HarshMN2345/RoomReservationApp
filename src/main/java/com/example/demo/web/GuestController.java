package com.example.demo.web;

import com.example.demo.business.ReservationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/guests")
public class GuestController {
    public final ReservationService reservationService;

    public GuestController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }
    @GetMapping
    public String getGuests(Model model) {
        model.addAttribute("guests", reservationService.getHotelGuests());
        return "guests";

    }
}
