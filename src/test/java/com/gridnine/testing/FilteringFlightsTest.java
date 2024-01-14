package com.gridnine.testing;

import org.junit.jupiter.api.Test;

import java.util.List;
import static com.gridnine.testing.FlightsForTest.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class FilteringFlightsTest {
    Filter departureBeforeCurrentTime = new DepartureBeforeCurrentTime();
    Filter arrivalDateEarlierDepartureDate = new ArrivalDateEarlierDepartureDate();
    Filter groundTimeMoreThanTwoHours = new GroundTimeMoreThanTwoHours();

    @Test
    void firstRuleTest() {
        List<Flight> expected = departureBeforeCurrentTime.filter(allFlights);
        assertEquals(expected, FlightsForTest.departureBeforeCurrentTime);
    }
    @Test
    void secondRuleTest() {
        List<Flight> expected = arrivalDateEarlierDepartureDate.filter(allFlights);
        assertEquals(expected, FlightsForTest.arrivalDateEarlierDepartureDate);
    }
    @Test
    void thirdRuleTest() {
        List<Flight> expected = groundTimeMoreThanTwoHours.filter(allFlights);
        assertEquals(expected, FlightsForTest.groundTimeMoreThanTwoHours);
    }
}
