package com.example.rentalcarreservationservice.repository;

import com.example.rentalcarreservationservice.entity.CarRental;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRentalRepository extends JpaRepository<CarRental, String> {
}
