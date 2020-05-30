package com.example.airplanereservationservice.controller;

import com.example.airplanereservationservice.constants.UrlMapping;
import com.example.airplanereservationservice.service.AirplaneReservationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AirplaneReservationRestController {

    private Logger logger = LoggerFactory.getLogger(AirplaneReservationRestController.class);

    @Autowired
    private AirplaneReservationService airplaneReservationService;

    @PostMapping(UrlMapping.AIRPLANE_RESERVATION)
    public ResponseEntity<?> reserve(@RequestBody String requestId) {
        logger.info("reserve airplane with requestId: " + requestId);
        airplaneReservationService.save(requestId);
        return ResponseEntity.ok("ok");
    }

    @DeleteMapping(UrlMapping.AIRPLANE_RESERVATION)
    public ResponseEntity<?> deleteByRequestId(@RequestParam String requestId) {
        logger.info("reserve airplane delete by requestId: " + requestId);
        airplaneReservationService.deleteByRequestId(requestId);
        return ResponseEntity.ok("ok");
    }

}
