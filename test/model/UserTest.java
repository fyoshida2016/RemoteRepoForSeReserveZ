package model;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.Test;

public class UserTest {

	@Test
	public void test() {
		User user=TestDataFactory.getTestUser();

		assertThat(user.getRid(),is(1));
		assertThat(user.getLoginName(),is("test"));
		assertThat(user.getPassWord(),is("xyz"));
		assertThat(user.getName(),is("Mr.x"));
		assertThat(user.getEmail(),is("mrx@gmail.com"));
		assertThat(user.getUserType(),is(1));

	}

}
