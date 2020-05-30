package com.example.rentalcarreservationservice.controller;

import com.example.rentalcarreservationservice.constants.UrlMapping;
import com.example.rentalcarreservationservice.service.CarRentalService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CarRentalRestController {

    private Logger logger = LoggerFactory.getLogger(CarRentalRestController.class);

    @Autowired
    private CarRentalService carRentalService;

    @PostMapping(UrlMapping.CAR_RENTAL)
    public ResponseEntity<?> rentCar(@RequestBody String requestId) {
        logger.info("rent car with requestId: " + requestId);
        carRentalService.save(requestId);
        return ResponseEntity.ok("ok");
    }

    @DeleteMapping(UrlMapping.CAR_RENTAL)
    public ResponseEntity<?> deleteRentCar(@RequestParam String requestId) {
        logger.info("rent car delete by requestId: " + requestId);
        carRentalService.deleteByRequestId(requestId);
        return ResponseEntity.ok("ok");
    }

}
