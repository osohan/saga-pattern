package com.example.rentalcarreservationservice.controller;

import com.example.rentalcarreservationservice.constants.UrlMapping;
import com.example.rentalcarreservationservice.service.CarRentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CarRentalRestController {

    @Autowired
    private CarRentalService carRentalService;

    @PostMapping(UrlMapping.CAR_RENTAL)
    public ResponseEntity<?> rentCar(@RequestParam String requestId) {
        carRentalService.save(requestId);
        return ResponseEntity.ok("ok");
    }

    @DeleteMapping(UrlMapping.CAR_RENTAL)
    public ResponseEntity<?> deleteRentCar(@RequestParam String requestId) {
        carRentalService.deleteByRequestId(requestId);
        return ResponseEntity.ok("ok");
    }

}
