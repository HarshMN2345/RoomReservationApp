package com.example.demo.data;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "RESERVATION")
public class Reservation {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    @Column(name="RESERVATION_ID")
    private Long id;
    @Column(name="GUEST_ID")
    private Long guestId;
    @Column(name="ROOM_ID")
    private Long roomId;
    @Column(name="RES_DATE")
    private Date reservationDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getGuestId() {
        return guestId;
    }

    public void setGuestId(Long guestId) {
        this.guestId = guestId;
    }

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    public Date getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(Date reservationDate) {
        this.reservationDate = reservationDate;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", guestId=" + guestId +
                ", roomId=" + roomId +
                ", resDate='" + reservationDate + '\'' +
                '}';
    }
}
