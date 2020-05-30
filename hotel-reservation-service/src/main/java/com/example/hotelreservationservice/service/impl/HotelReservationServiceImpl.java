package com.example.hotelreservationservice.service.impl;

import com.example.hotelreservationservice.constants.State;
import com.example.hotelreservationservice.dao.HotelReservationDAO;
import com.example.hotelreservationservice.entity.HotelReservation;
import com.example.hotelreservationservice.service.HotelReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class HotelReservationServiceImpl implements HotelReservationService {

    @Autowired
    private HotelReservationDAO hotelReservationDAO;

    @Override
    public void deleteByRequestId(String requestId) {
        hotelReservationDAO.deleteByRequestId(requestId);
    }

    @Override
    public void save(HotelReservation hotelReservation) {
        hotelReservationDAO.save(hotelReservation);
    }

    @Override
    public void save(String requestId) {
        HotelReservation hotelReservation = new HotelReservation();
        hotelReservation.setId(UUID.randomUUID().toString());
        hotelReservation.setRequestId(requestId);
        hotelReservation.setState(State.PENDING);

        hotelReservationDAO.save(hotelReservation);
    }
}
