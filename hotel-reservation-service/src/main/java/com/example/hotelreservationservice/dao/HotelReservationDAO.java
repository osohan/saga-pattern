package com.example.hotelreservationservice.dao;

import com.example.hotelreservationservice.entity.HotelReservation;

public interface HotelReservationDAO {

    int deleteByRequestId(String requestId);

    void save(HotelReservation hotelReservation);

}
