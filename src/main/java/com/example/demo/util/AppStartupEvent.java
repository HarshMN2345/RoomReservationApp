package com.example.demo.util;

import com.example.demo.data.GuestRepository;
import com.example.demo.data.ReservationRepository;
import com.example.demo.data.Room;
import com.example.demo.data.RoomRepository;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class AppStartupEvent implements ApplicationListener<ApplicationReadyEvent> {
    private final RoomRepository roomRepository;
    private final GuestRepository guestRepository;
    private final ReservationRepository reservationRepository;
    private final DateUtils dateUtils ;

    public AppStartupEvent(RoomRepository roomRepository, GuestRepository guestRepository, ReservationRepository reservationRepository, DateUtils dateUtils) {
        this.roomRepository = roomRepository;
        this.guestRepository = guestRepository;
        this.reservationRepository = reservationRepository;
        this.dateUtils = dateUtils;

    }
    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        Date date = this.dateUtils.createDateFromDateString("2022-01-01");
        Iterable<Room> rooms = roomRepository.findAll();
        rooms.forEach(System.out::println);

    }
}
