package com.example.rentalcarreservationservice.service;

import com.example.rentalcarreservationservice.entity.CarRental;

public interface CarRentalService {

    void deleteByRequestId(String requestId);

    void save(CarRental carRental);

    void save(String requestId);

}
