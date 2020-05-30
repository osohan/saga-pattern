package com.example.rentalcarreservationservice.dao.impl;

import com.example.rentalcarreservationservice.dao.CarRentalDAO;
import com.example.rentalcarreservationservice.entity.CarRental;
import com.example.rentalcarreservationservice.repository.CarRentalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Repository
public class CarRentalMysqlDAO implements CarRentalDAO {

    @Autowired
    private CarRentalRepository carRentalRepository;

    @Autowired
    private EntityManager entityManager;

    @Override
    public void save(CarRental carRental) {
        carRentalRepository.save(carRental);
    }

    @Override
    @Transactional
    public int deleteByRequestId(String requestId) {
        return entityManager.createQuery("DELETE FROM CarRental c WHERE c.requestId = :requestId")
                .setParameter("requestId", requestId)
                .executeUpdate();
    }

}
