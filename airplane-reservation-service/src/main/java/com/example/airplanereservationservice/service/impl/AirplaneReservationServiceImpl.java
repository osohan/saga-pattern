package com.example.airplanereservationservice.service.impl;

import com.example.airplanereservationservice.constants.State;
import com.example.airplanereservationservice.dao.AirplaneReservationDAO;
import com.example.airplanereservationservice.entity.AirplaneReservation;
import com.example.airplanereservationservice.service.AirplaneReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AirplaneReservationServiceImpl implements AirplaneReservationService {

    @Autowired
    private AirplaneReservationDAO airplaneReservationDAO;

    @Override
    public void deleteByRequestId(String requestId) {
        airplaneReservationDAO.deleteByRequestId(requestId);
    }

    @Override
    public void save(AirplaneReservation airplaneReservation) {
        airplaneReservationDAO.save(airplaneReservation);
    }

    @Override
    public void save(String requestId) {
        AirplaneReservation airplaneReservation = new AirplaneReservation();
        airplaneReservation.setId(UUID.randomUUID().toString());
        airplaneReservation.setRequestId(requestId);
        airplaneReservation.setState(State.PENDING);

        airplaneReservationDAO.save(airplaneReservation);
    }
}
