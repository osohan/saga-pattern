package com.example.sagaexecutioncontroller.response;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ReserveTripRestResponse {

    private Boolean rentCar;

    private Boolean reserveHotel;

    private Boolean reserveAiplane;

}
