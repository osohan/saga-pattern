package com.example.airplanereservationservice.repository;

import com.example.airplanereservationservice.entity.AirplaneReservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirplaneReservationRepository extends JpaRepository<AirplaneReservation, String> {
}
