package com.example.demo.webservice;


import com.example.demo.business.ReservationService;
import com.example.demo.business.RoomReservation;
import com.example.demo.data.Guest;
import com.example.demo.data.Room;
import com.example.demo.util.DateUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
public class WebserviceController {
    public final DateUtils dateUtils;
    public final ReservationService reservationService;

    public WebserviceController(DateUtils dateUtils, ReservationService reservationService) {
        this.dateUtils = dateUtils;
        this.reservationService = reservationService;
    }
    @GetMapping("/reservations")
    public List<RoomReservation> getRoomReservations(@RequestParam (value = "date", required = false, defaultValue = "") String dateString) {

        Date date = dateUtils.createDateFromDateString(dateString);

        return reservationService.getRoomReservationsForDate(date);
    }
    @GetMapping("/guests")
    public List<Guest> getGuests() {
        return reservationService.getHotelGuests();
    }
    @GetMapping("/rooms")
    public List<Room> getRooms() {
        return reservationService.getRooms();
    }
}