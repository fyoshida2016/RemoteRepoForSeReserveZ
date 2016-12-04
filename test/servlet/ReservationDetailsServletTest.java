package servlet;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Test;

import common.TestDataBase;
import common.TestServlet;
import model.Reservation;
import model.Room;
import model.User;

public class ReservationDetailsServletTest extends TestServlet {

	@Test
	public void RIDを指定して予約情報を読み込む() throws Exception {
		// データベースにテストデータを挿入
		TestDataBase db=new TestDataBase();
		db.setTestData("./testdata/story08/ReservationDetailsServlet_test.xls");

		// Postメソッドを指定
		setPost();

		// テキストボックスに入力値を設定
		webRequest.setParameter("RID", "1");

		// Servletを呼び出す。
		callServlet();

		// RequestにReservationオブジェクトが保存されていること（nullではないこと）を確認
		assertThat(request.getAttribute("Reservation"),is(notNullValue()));

		// RequestからReservationオブジェクトを読み込み
		Reservation reservation=(Reservation)request.getAttribute("Reservation");

		// 読み込んだオブジェクトのプロパティの値が適切かどうかをチェック
		assertThat(reservation.getRid(),is(1));
		assertThat(reservation.getUser().getRid(),is(1));
		assertThat(reservation.getRoom().getRid(),is(2));
		assertThat(reservation.getStartMonth(),is(12));
		assertThat(reservation.getStartDay(),is(5));
		assertThat(reservation.getStartHour(),is(13));
		assertThat(reservation.getStartMinute(),is(0));
		assertThat(reservation.getPeriodHour(),is(1));
		assertThat(reservation.getPeriodMinute(),is(30));

	}

}
