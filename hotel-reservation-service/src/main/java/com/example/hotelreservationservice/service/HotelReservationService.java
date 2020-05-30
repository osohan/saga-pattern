package com.example.hotelreservationservice.service;

import com.example.hotelreservationservice.entity.HotelReservation;

public interface HotelReservationService {

    void deleteByRequestId(String requestId);

    void save(HotelReservation hotelReservation);

    void save(String requestId);

}
