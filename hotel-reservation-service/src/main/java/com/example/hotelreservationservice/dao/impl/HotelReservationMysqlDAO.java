package com.example.hotelreservationservice.dao.impl;

import com.example.hotelreservationservice.dao.HotelReservationDAO;
import com.example.hotelreservationservice.entity.HotelReservation;
import com.example.hotelreservationservice.repository.HotelReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Repository
public class HotelReservationMysqlDAO implements HotelReservationDAO {

    @Autowired
    private HotelReservationRepository hotelReservationRepository;

    @Autowired
    private EntityManager entityManager;

    @Override
    public void save(HotelReservation hotelReservation) {
        hotelReservationRepository.save(hotelReservation);
    }

    @Override
    @Transactional
    public int deleteByRequestId(String requestId) {
        return entityManager.createQuery("DELETE FROM HotelReservation h WHERE h.requestId = :requestId")
                .setParameter("requestId", requestId)
                .executeUpdate();
    }

}
