package com.gridnine.testing;

import org.junit.jupiter.api.Test;

import java.util.List;
import static com.gridnine.testing.FlightsForTest.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class FilteringFlightsTest {
    Filter departureBeforeCurrentTime = new DepartureBeforeCurrentTime();
    Filter arrivalDateEarlierDepartureDate = new ArrivalDateEarlierDepartureDate();
    Filter groundTimeMoreThanTwoHours = new GroundTimeMoreThanTwoHours();

    /**
     * Тестируем фильтр на исключение перелётов до текущего момента времени
     */
    @Test
    void firstRuleTest() {
        List<Flight> expected = departureBeforeCurrentTime.filter(allFlights);
        assertEquals(expected, FlightsForTest.departureBeforeCurrentTime);
    }

    /**
     * Тестируем фильтр на исключение перелётов с датой прилёта раньше даты вылета
     */
    @Test
    void secondRuleTest() {
        List<Flight> expected = arrivalDateEarlierDepartureDate.filter(allFlights);
        assertEquals(expected, FlightsForTest.arrivalDateEarlierDepartureDate);
    }

    /**
     * Тестируем фильтр на исключение перелётов, где общее время, проведённое на земле, превышает два часа
     */
    @Test
    void thirdRuleTest() {
        List<Flight> expected = groundTimeMoreThanTwoHours.filter(allFlights);
        assertEquals(expected, FlightsForTest.groundTimeMoreThanTwoHours);
    }
}
