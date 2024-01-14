package com.gridnine.testing;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello passenger!");
        List<Flight> flights = FlightBuilder.createFlights();
        System.out.println("Все перелёты:\n " + flights);

        Filter beforeCurrentTime = new DepartureBeforeCurrentTime();
        System.out.println("Исключение перелётов до текущего момента времени:\n " + beforeCurrentTime.filter(flights));

        Filter earlierDepartureDate = new ArrivalDateEarlierDepartureDate();
        System.out.println("Исключение перелётов с датой прилёта раньше даты вылета:\n " + earlierDepartureDate.filter(flights));

        Filter tooBigGroundTime = new GroundTimeMoreThanTwoHours();
        System.out.println("Исключение перелётов, где общее время, проведённое на земле, превышает два часа:\n " + tooBigGroundTime.filter(flights));
    }
}