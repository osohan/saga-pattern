package com.example.rentalcarreservationservice.dao;

import com.example.rentalcarreservationservice.entity.CarRental;

public interface CarRentalDAO {

    int deleteByRequestId(String requestId);

    void save(CarRental carRental);

}
