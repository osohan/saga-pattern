package com.example.airplanereservationservice;

import com.example.airplanereservationservice.constants.State;
import com.example.airplanereservationservice.entity.AirplaneReservation;
import com.example.airplanereservationservice.repository.AirplaneReservationRepository;
import com.example.airplanereservationservice.service.AirplaneReservationService;
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
class AirplaneReservationServiceApplicationTests {

    @Autowired
    private AirplaneReservationService airplaneReservationService;

    @Autowired
    private AirplaneReservationRepository airplaneReservationRepository;


    @BeforeAll
    void beforeAll() {
        airplaneReservationRepository.deleteAll();
    }

    @AfterAll
    void afterAll() {
        airplaneReservationRepository.deleteAll();
    }

    @Test
    void contextLoads() {
        String requestId = UUID.randomUUID().toString();

        AirplaneReservation airplaneReservation = new AirplaneReservation();
        airplaneReservation.setId(UUID.randomUUID().toString());
        airplaneReservation.setRequestId(requestId);
        airplaneReservation.setState(State.PENDING);

        airplaneReservationService.save(airplaneReservation);

        airplaneReservationService.deleteByRequestId(requestId);

        assertTrue(airplaneReservationRepository.findAll().isEmpty());
    }

}
