package db;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Test;

import common.TestDataBase;
import model.Reservation;
import model.Room;
import model.TestDataFactory;
import model.User;

public class ReservationManagerTest {

	@Test
	public void 予約を読み込む() {
		// データベースにテストデータを挿入
		TestDataBase db=new TestDataBase();
		db.setTestData("./testdata/story08/dbaccess_test.xls");

		// データベースから予約を読み込み
		ReservationManager rm=new ReservationManager();
		Reservation reservation=rm.getReservation(1);

		// 読み込んだオブジェクトのプロパティの値が適切かどうかをチェック
		assertThat(reservation.getRid(),is(1));
		assertThat(reservation.getUser().getRid(),is(1));
		assertThat(reservation.getRoom().getRid(),is(2));
		assertThat(reservation.getStartYear(),is(2016));
		assertThat(reservation.getStartMonth(),is(12));
		assertThat(reservation.getStartDay(),is(5));
		assertThat(reservation.getStartHour(),is(13));
		assertThat(reservation.getStartMinute(),is(0));
		assertThat(reservation.getPeriodHour(),is(1));
		assertThat(reservation.getPeriodMinute(),is(30));
	}

}

