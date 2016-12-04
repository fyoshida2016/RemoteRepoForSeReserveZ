package servlet;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Test;

import common.TestDataBase;
import common.TestServlet;
import model.Room;
import model.User;

public class RoomDetailsServletTest extends TestServlet {

	@Test
	public void RIDを指定して会議室を読み込む() throws Exception {
		// データベースにテストデータを挿入
		TestDataBase db=new TestDataBase();
		db.setTestData("./testdata/story06/RoomDetailsServlet_test.xls");

		// Postメソッドを指定
		setPost();

		// テキストボックスに入力値を設定
		webRequest.setParameter("RID", "5");

		// Servletを呼び出す。
		callServlet();

		// SessionにRoomオブジェクトが保存されていること（nullではないこと）を確認
		assertThat(session.getAttribute("Room"),is(notNullValue()));

		// SessionからRoomオブジェクトを読み込み
		Room room=(Room)session.getAttribute("Room");

		// 読み込んだオブジェクトのプロパティの値が適切かどうかをチェック
		assertThat(room.getName(),is("会議室"));
		assertThat(room.getBuildingName(),is("総合研究棟"));
		assertThat(room.getFloor(),is("6"));
		assertThat(room.getRoomNumber(),is("607"));
		assertThat(room.getArea(),is(98));
		assertThat(room.getCapacity(),is(50));
		assertThat(room.getTel(),is("5555"));
		assertThat(room.getWhiteboard(),is(5));
		assertThat(room.getProjecter(),is(0));
		assertThat(room.getScreen(),is(1));
		assertThat(room.getHdmi(),is(1));
		assertThat(room.getDsub(),is(1));
		assertThat(room.getComposite(),is(1));
		assertThat(room.getStereomini(),is(1));

	}

}
