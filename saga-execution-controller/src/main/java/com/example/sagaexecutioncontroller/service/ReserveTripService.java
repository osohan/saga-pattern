package com.example.sagaexecutioncontroller.service;

public interface ReserveTripService {

    void reserveTrip(String requestId) throws Exception;

    boolean rentCar(String requestId);

    boolean rentCarDelete(String requestId);

    boolean reserveHotel(String requestId);

    boolean reserveHotelDelete(String requestId);

    boolean reserveAirplane(String requestId);

    boolean reserveAirplaneDelete(String requestId);

    void deleteAllReservations(String requestId) throws Exception;

}
