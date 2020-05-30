package com.example.hotelreservationservice.controller;

import com.example.hotelreservationservice.constants.UrlMapping;
import com.example.hotelreservationservice.service.HotelReservationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class HotelReservationRestController {

    private Logger logger = LoggerFactory.getLogger(HotelReservationRestController.class);

    @Autowired
    private HotelReservationService hotelReservationService;

    @PostMapping(UrlMapping.HOTEL_RESERVATION)
    public ResponseEntity<?> reserve(@RequestBody String requestId) {
        logger.info("reserve hotel with requestId: " + requestId);
        hotelReservationService.save(requestId);
        return ResponseEntity.ok("ok");
    }

    @DeleteMapping(UrlMapping.HOTEL_RESERVATION)
    public ResponseEntity<?> deleteByRequestId(@RequestParam String requestId) {
        logger.info("reserve hotel delete by requestId: " + requestId);
        hotelReservationService.deleteByRequestId(requestId);
        return ResponseEntity.ok("ok");
    }

}
