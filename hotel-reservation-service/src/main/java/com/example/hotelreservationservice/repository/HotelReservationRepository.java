package com.example.hotelreservationservice.repository;

import com.example.hotelreservationservice.entity.HotelReservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelReservationRepository extends JpaRepository<HotelReservation, String> {
}
