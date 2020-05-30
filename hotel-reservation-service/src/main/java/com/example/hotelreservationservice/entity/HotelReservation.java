package com.example.hotelreservationservice.entity;

import com.example.hotelreservationservice.constants.State;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@Entity
@Table(name = "hotel_reservation")
public class HotelReservation {

    @Id
    private String id;

    @Column(name = "request_id")
    private String requestId;

    @Column(name = "state")
    private State state;

}
