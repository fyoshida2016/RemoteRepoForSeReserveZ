package servlet;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

import common.TestDataBase;
import common.TestServlet;
import model.User;

public class LoginAdminServletTest extends TestServlet {

	@Test
	public void 管理者ログインに成功する() throws Exception {
		// データベースにテストデータを挿入
		TestDataBase db=new TestDataBase();
		db.setTestData("./testdata/story02/LoginAdminServlet_test.xls");

		// POSTメソッドを指定
		setPost();

		// テキストボックスに入力値を設定
		webRequest.setParameter("LoginName", "admin");
		webRequest.setParameter("PassWord", "admin");

		// Servletを呼び出す。
		callServlet();

		// SessionにUserオブジェクトが保存されていること（nullではないこと）を確認
		assertThat(session.getAttribute("LoginUser"),notNullValue());

		// SessionからUserオブジェクトを読み込み
		User loginUser=(User)session.getAttribute("LoginUser");

		// 読み込んだオブジェクトのプロパティの値が適切かどうかをチェック
		assertThat(loginUser.getLoginName(),is("admin"));
		assertThat(loginUser.getPassWord(),is("admin"));
		assertThat(loginUser.getName(),is("Mr.Admin"));

	}

	@Test
	public void 通常ユーザは管理者ログインに失敗する() throws Exception {
		// データベースにテストデータを挿入
		TestDataBase db=new TestDataBase();
		db.setTestData("./testdata/story02/LoginAdminServlet_test.xls");

		// POSTメソッドを指定
		setPost();
		// テキストボックスに入力値を設定
		webRequest.setParameter("LoginName", "test1");
		webRequest.setParameter("PassWord", "xyz");

		// Servletを呼び出す。
		callServlet();

		// SessionにUserオブジェクトが保存されていないこと（nullであること）を確認
		assertThat(session.getAttribute("LoginUser"),nullValue());

	}

	@Test
	public void 未登録ユーザは管理者ログインに失敗する() throws Exception {
		// データベースにテストデータを挿入
		TestDataBase db=new TestDataBase();
		db.setTestData("./testdata/story02/LoginAdminServlet_test.xls");

		// POSTメソッドを指定
		setPost();
		// テキストボックスに入力値を設定
		webRequest.setParameter("LoginName", "aaa");
		webRequest.setParameter("PassWord", "bbb");

		// Servletを呼び出す。
		callServlet();

		// SessionにUserオブジェクトが保存されていないこと（nullであること）を確認
		assertThat(session.getAttribute("LoginUser"),nullValue());

	}


}
