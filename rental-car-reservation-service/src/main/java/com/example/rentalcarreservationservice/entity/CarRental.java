package com.example.rentalcarreservationservice.entity;

import com.example.rentalcarreservationservice.constants.State;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@Entity
@Table(name = "car_rental")
public class CarRental {

    @Id
    private String id;

    @Column(name = "request_id")
    private String requestId;

    @Column(name = "state")
    private State state;

}
