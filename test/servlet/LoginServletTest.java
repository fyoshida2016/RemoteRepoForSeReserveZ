package servlet;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

import common.TestDataBase;
import common.TestServlet;
import model.User;

public class LoginServletTest extends TestServlet {

	@Test
	public void ログインに成功する() throws Exception {
		// データベースにテストデータを挿入
		TestDataBase db=new TestDataBase();
		db.setTestData("./testdata/story01/LoginServlet_test.xls");

		// POSTメソッドを指定
		setGet();

		// テキストボックスに入力値を設定
		webRequest.setParameter("LoginName", "test1");
		webRequest.setParameter("PassWord", "xyz");

		// Servletを呼び出す。
		callServlet();

		// SessionにUserオブジェクトが保存されていること（nullではないこと）を確認
		assertThat(session.getAttribute("LoginUser"),notNullValue());

		// SessionからUserオブジェクトを読み込み
		User loginUser=(User)session.getAttribute("LoginUser");

		// 読み込んだオブジェクトのプロパティの値が適切かどうかをチェック
		assertThat(loginUser.getLoginName(),is("test1"));
		assertThat(loginUser.getPassWord(),is("xyz"));
		assertThat(loginUser.getName(),is("Mr.x"));

	}

	@Test
	public void ログインに失敗する() throws Exception {
		// データベースにテストデータを挿入
		TestDataBase db=new TestDataBase();
		db.setTestData("./testdata/story01/LoginServlet_test.xls");

		// POSTメソッドを指定
		setPost();
		// テキストボックスに入力値を設定
		webRequest.setParameter("LoginName", "test");
		webRequest.setParameter("PassWord", "xyz");

		// Servletを呼び出す。
		callServlet();

		// SessionにUserオブジェクトが保存されていないこと（nullであること）を確認
		assertThat(session.getAttribute("LoginUser"),nullValue());

	}

}

