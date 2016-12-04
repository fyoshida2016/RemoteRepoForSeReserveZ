package servlet;

import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import db.RoomManager;
import db.UserManager;
import model.Room;
import model.User;

@WebServlet(name = "RoomListServlet", urlPatterns = { "/RoomListServlet" })
public class RoomListServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		doMain(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		doMain(req, res);
	}

	public void doMain(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html; charset=UTF-8");

		RoomManager rm=new RoomManager();
		LinkedList<Room> rooms=rm.getRooms();

		req.setAttribute("Rooms", rooms);
		req.getRequestDispatcher("RoomList.jsp").forward(req, res);


	}
}
