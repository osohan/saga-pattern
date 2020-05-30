package com.example.rentalcarreservationservice;

import com.example.rentalcarreservationservice.constants.State;
import com.example.rentalcarreservationservice.entity.CarRental;
import com.example.rentalcarreservationservice.repository.CarRentalRepository;
import com.example.rentalcarreservationservice.service.CarRentalService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class RentalCarReservationServiceApplicationTests {

    @Autowired
    private CarRentalService carRentalService;

    @Autowired
    private CarRentalRepository carRentalRepository;

    @Test
    void contextLoads() {
        String requestId = UUID.randomUUID().toString();

        CarRental carRental = new CarRental();
        carRental.setRequestId(requestId);
        carRental.setState(State.PENDING);

        carRentalService.save(carRental);

        carRentalService.deleteByRequestId(requestId);

        assertTrue(carRentalRepository.findAll().isEmpty());
    }

}
