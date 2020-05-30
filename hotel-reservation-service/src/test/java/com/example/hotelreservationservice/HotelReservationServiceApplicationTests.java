package com.example.hotelreservationservice;

import com.example.hotelreservationservice.constants.State;
import com.example.hotelreservationservice.dao.HotelReservationDAO;
import com.example.hotelreservationservice.entity.HotelReservation;
import com.example.hotelreservationservice.repository.HotelReservationRepository;
import com.example.hotelreservationservice.service.HotelReservationService;
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
class HotelReservationServiceApplicationTests {

    @Autowired
    private HotelReservationService hotelReservationService;

    @Autowired
    private HotelReservationRepository hotelReservationRepository;

    @BeforeAll
    void beforeAll() {
        hotelReservationRepository.deleteAll();
    }

    @AfterAll
    void afterAll() {
        hotelReservationRepository.deleteAll();
    }

    @Test
    void contextLoads() {
        String requestId = UUID.randomUUID().toString();

        HotelReservation hotelReservation = new HotelReservation();
        hotelReservation.setId(UUID.randomUUID().toString());
        hotelReservation.setRequestId(requestId);
        hotelReservation.setState(State.PENDING);

        hotelReservationService.save(hotelReservation);

        hotelReservationService.deleteByRequestId(requestId);

        assertTrue(hotelReservationRepository.findAll().isEmpty());
    }

}
