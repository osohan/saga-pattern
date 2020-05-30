package com.example.sagaexecutioncontroller.service;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

public class ReserveTripHelperService {

    public static HttpHeaders getHeaders() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        return httpHeaders;
    }

    public static boolean isResultOk(ResponseEntity<String> result) {
        return isResultOk(result.getBody());
    }

    public static boolean isResultOk(String result) {
        return result != null && result.equalsIgnoreCase("ok");
    }

}
