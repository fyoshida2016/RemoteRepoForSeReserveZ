package servlet;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

import common.TestDataBase;
import common.TestServlet;
import model.User;

public class LogoutAdminServletTest extends TestServlet {


	public void initialize(){
		User loginUser=new User();
		session.setAttribute("LoginUser", loginUser);
	}

	@Test
	public void 管理者ログアウトに成功する() throws Exception {

		// POSTメソッドを指定
		setPost();

		// Servletを呼び出す。
		callServlet();

		// Sessionに保存されているUserオブジェクトが削除されていること（nullであること）を確認
		assertThat(session.getAttribute("LoginUser"),is(nullValue()));

	}
}
