package com.example.rentalcarreservationservice;

import com.example.rentalcarreservationservice.constants.State;
import com.example.rentalcarreservationservice.entity.CarRental;
import com.example.rentalcarreservationservice.repository.CarRentalRepository;
import com.example.rentalcarreservationservice.service.CarRentalService;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertTrue;

@ActiveProfiles("local")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class RentalCarReservationServiceApplicationTests {

    @Autowired
    private CarRentalService carRentalService;

    @Autowired
    private CarRentalRepository carRentalRepository;

    @BeforeAll
    void beforeAll() {
        carRentalRepository.deleteAll();
    }

    @AfterAll
    void afterAll() {
        carRentalRepository.deleteAll();
    }

    @Test
    void contextLoads() {
        String requestId = UUID.randomUUID().toString();

        CarRental carRental = new CarRental();
        carRental.setId(UUID.randomUUID().toString());
        carRental.setRequestId(requestId);
        carRental.setState(State.PENDING);

        carRentalService.save(carRental);

        carRentalService.deleteByRequestId(requestId);

        assertTrue(carRentalRepository.findAll().isEmpty());
    }

}
