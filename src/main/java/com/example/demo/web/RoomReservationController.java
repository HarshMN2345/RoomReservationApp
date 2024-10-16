package com.example.demo.web;

import com.example.demo.business.ReservationService;
import com.example.demo.business.RoomReservation;
import com.example.demo.util.DateUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/reservations")
public class RoomReservationController {
    private final DateUtils dateUtils;
    private final ReservationService reservationService;

    public RoomReservationController(DateUtils dateUtils, ReservationService reservationService) {
        this.dateUtils = dateUtils;
        this.reservationService = reservationService;
    }

    @GetMapping
    public String getReservations(
            @RequestParam(value = "date", required = false, defaultValue = "") String dateString,
            Model model) {

        Date date = dateUtils.createDateFromDateString(dateString);
        if (date == null) {
            // Handle invalid date format
            model.addAttribute("error", "Invalid date format. Please use 'YYYY-MM-DD'.");
            return "roomres"; // or redirect to an error page
        }

        List<RoomReservation> roomReservations = reservationService.getRoomReservationsForDate(date);
        model.addAttribute("date", dateString);
        model.addAttribute("roomReservations", roomReservations);

        // Optional: Add a message if no reservations found
        if (roomReservations.isEmpty()) {
            model.addAttribute("message", "No reservations found for this date.");
        }

        return "roomres";
    }


}
