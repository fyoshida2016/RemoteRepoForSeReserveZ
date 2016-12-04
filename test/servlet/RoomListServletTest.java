package servlet;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Test;

import common.TestDataBase;
import common.TestServlet;
import model.Room;
import model.User;

public class RoomListServletTest extends TestServlet {

	@Test
	public void 全会議室を読み込む() throws Exception {
		// データベースにテストデータを挿入
		TestDataBase db=new TestDataBase();
		db.setTestData("./testdata/story05/RoomListServlet_test.xls");

		// Postメソッドを指定
		setPost();

		// Servletを呼び出す。
		callServlet();

		// RequestにRoomオブジェクトが保存されていること（nullではないこと）を確認
		assertThat(request.getAttribute("Rooms"),is(notNullValue()));

		// RequestからRoomオブジェクトを読み込み
		LinkedList<Room> rooms=(LinkedList<Room>)request.getAttribute("Rooms");

		// 読み込んだリストに登録されている部屋の数をチェック
		assertThat(rooms.size(),is(5));

		// 読み込んだオブジェクトのプロパティの値が適切かどうかをチェック
		Room room=rooms.get(4);
		assertThat(room.getName(),is("会議室"));
		assertThat(room.getBuildingName(),is("総合研究棟"));
		assertThat(room.getFloor(),is("6"));
		assertThat(room.getRoomNumber(),is("607"));
		assertThat(room.getArea(),is(98));
		assertThat(room.getCapacity(),is(50));

	}

}
