package com.example.airplanereservationservice.dao.impl;

import com.example.airplanereservationservice.dao.AirplaneReservationDAO;
import com.example.airplanereservationservice.entity.AirplaneReservation;
import com.example.airplanereservationservice.repository.AirplaneReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Repository
public class AirplaneReservationMysqlDAO implements AirplaneReservationDAO {

    @Autowired
    private AirplaneReservationRepository airplaneReservationRepository;

    @Autowired
    private EntityManager entityManager;

    @Override
    public void save(AirplaneReservation airplaneReservation) {
        airplaneReservationRepository.save(airplaneReservation);
    }

    @Override
    @Transactional
    public int deleteByRequestId(String requestId) {
        return entityManager.createQuery("DELETE FROM AirplaneReservation h WHERE h.requestId = :requestId")
                .setParameter("requestId", requestId)
                .executeUpdate();
    }

}
