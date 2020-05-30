package com.example.sagaexecutioncontroller.service;

import com.example.sagaexecutioncontroller.response.ReserveTripRestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ReserveTripServiceImpl implements ReserveTripService {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public void reserveTrip(String requestId) throws Exception {
        ReserveTripRestResponse reserveTripRestResponse = new ReserveTripRestResponse();

        Thread rentCarThread = new Thread(() -> reserveTripRestResponse.setRentCar(rentCar(requestId)));
        Thread reserveHotelThread = new Thread(() -> reserveTripRestResponse.setReserveHotel(reserveHotel(requestId)));

        while (rentCarThread.isAlive() && reserveHotelThread.isAlive()) {
            try { Thread.sleep(10); } catch (Exception ex) {}
        }

        if (reserveTripRestResponse.getRentCar() && reserveTripRestResponse.getReserveHotel()) {
            if (reserveAirplane(requestId)) {
//                todo: set all states to done
                return;
            }
        }
        deleteAllReservations(requestId);
    }

    @Override
    public void deleteAllReservations(String requestId) throws Exception {
        boolean result = rentCarDelete(requestId) && reserveHotelDelete(requestId) && reserveAirplaneDelete(requestId);
        if (!result) {
            throw new Exception("unable to delete");
        }
    }

    @Override
    public boolean rentCar(String requestId) {
        return ReserveTripHelperService.isResultOk(
                restTemplate.postForObject("http://localhost:8081/api/carRental",
                        new HttpEntity<>("redasdas", ReserveTripHelperService.getHeaders()), String.class));
    }

    @Override
    public boolean rentCarDelete(String requestId) {
        return ReserveTripHelperService.isResultOk(
                restTemplate.exchange("http://localhost:8081/api/carRental?requestId=" + requestId,
                        HttpMethod.DELETE, new HttpEntity<>(ReserveTripHelperService.getHeaders()), String.class));
    }

    @Override
    public boolean reserveHotel(String requestId) {
        return ReserveTripHelperService.isResultOk(
                restTemplate.postForObject("http://localhost:8082/api/reservation/hotel",
                        new HttpEntity<>("redasdas", ReserveTripHelperService.getHeaders()), String.class));
    }

    @Override
    public boolean reserveHotelDelete(String requestId) {
        return ReserveTripHelperService.isResultOk(
                restTemplate.exchange("http://localhost:8082/api/reservation/hotel?requestId=" + requestId,
                        HttpMethod.DELETE, new HttpEntity<>(ReserveTripHelperService.getHeaders()), String.class));
    }

    @Override
    public boolean reserveAirplane(String requestId) {
        return ReserveTripHelperService.isResultOk(
                restTemplate.postForObject("http://localhost:8083/api/reservation/airplane",
                        new HttpEntity<>("redasdas", ReserveTripHelperService.getHeaders()), String.class));
    }

    @Override
    public boolean reserveAirplaneDelete(String requestId) {
        return ReserveTripHelperService.isResultOk(
                restTemplate.exchange("http://localhost:8083/api/reservation/airplane?requestId=" + requestId,
                        HttpMethod.DELETE, new HttpEntity<>(ReserveTripHelperService.getHeaders()), String.class));
    }

}
