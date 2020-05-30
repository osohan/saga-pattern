package com.example.airplanereservationservice.dao;

import com.example.airplanereservationservice.entity.AirplaneReservation;

public interface AirplaneReservationDAO {

    int deleteByRequestId(String requestId);

    void save(AirplaneReservation airplaneReservation);

}
