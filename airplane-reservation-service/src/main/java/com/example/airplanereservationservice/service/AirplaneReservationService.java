package com.example.airplanereservationservice.service;

import com.example.airplanereservationservice.entity.AirplaneReservation;

public interface AirplaneReservationService {

    void deleteByRequestId(String requestId);

    void save(AirplaneReservation airplaneReservation);

    void save(String requestId);

}
