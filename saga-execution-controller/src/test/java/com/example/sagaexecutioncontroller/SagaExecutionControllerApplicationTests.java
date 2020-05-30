package com.example.sagaexecutioncontroller;

import com.example.sagaexecutioncontroller.service.ReserveTripService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SagaExecutionControllerApplicationTests {

    @Autowired
    private ReserveTripService reserveTripService;

    @Test
    void contextLoads() {
        reserveTripService.rentCar("some reuesd");
        reserveTripService.reserveHotel("some reuesd");
        reserveTripService.reserveAirplane("some reuesd");

        reserveTripService.rentCarDelete("some reuesd");
        reserveTripService.reserveHotelDelete("some reuesd");
        reserveTripService.reserveAirplaneDelete("some reuesd");
    }

}
