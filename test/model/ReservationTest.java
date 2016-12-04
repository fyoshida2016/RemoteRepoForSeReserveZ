package model;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.Test;

public class ReservationTest {

	@Test
	public void test() {
		Reservation reservation=TestDataFactory.getTestReservation();

		assertThat(reservation.getRid(),is(1));
		assertThat(reservation.getUser().getRid(),is(1));
		assertThat(reservation.getRoom().getRid(),is(1));
		assertThat(reservation.getStartMonth(),is(12));
		assertThat(reservation.getStartDay(),is(6));
		assertThat(reservation.getStartHour(),is(14));
		assertThat(reservation.getStartMinute(),is(40));
		assertThat(reservation.getPeriodHour(),is(1));
		assertThat(reservation.getPeriodMinute(),is(30));

	}

}
