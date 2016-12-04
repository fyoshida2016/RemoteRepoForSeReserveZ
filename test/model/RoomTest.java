package model;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.Test;

public class RoomTest {


	@Test
	public void test() {
		Room room=TestDataFactory.getTestRoom();

		assertThat(room.getRid(),is(1));
		assertThat(room.getBuildingName(),is("test"));
		assertThat(room.getFloor(),is("1"));
		assertThat(room.getRoomNumber(),is("101"));
		assertThat(room.getArea(),is(50));
		assertThat(room.getCapacity(),is(20));
		assertThat(room.getTel(),is("9999"));
		assertThat(room.getWhiteboard(),is(3));
		assertThat(room.getProjecter(),is(1));
		assertThat(room.getScreen(),is(1));
		assertThat(room.getHdmi(),is(0));
		assertThat(room.getDsub(),is(1));
		assertThat(room.getComposite(),is(1));
		assertThat(room.getStereomini(),is(1));

	}

}
