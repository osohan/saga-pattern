package com.example.rentalcarreservationservice.service.impl;

import com.example.rentalcarreservationservice.constants.State;
import com.example.rentalcarreservationservice.dao.CarRentalDAO;
import com.example.rentalcarreservationservice.entity.CarRental;
import com.example.rentalcarreservationservice.service.CarRentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarRentalServiceImpl implements CarRentalService {

    @Autowired
    private CarRentalDAO carRentalDAO;

    @Override
    public void deleteByRequestId(String requestId) {
        carRentalDAO.deleteByRequestId(requestId);
    }

    @Override
    public void save(CarRental carRental) {
        carRentalDAO.save(carRental);
    }

    @Override
    public void save(String requestId) {
        CarRental carRental = new CarRental();
        carRental.setRequestId(requestId);
        carRental.setState(State.PENDING);

        carRentalDAO.save(carRental);
    }
}
