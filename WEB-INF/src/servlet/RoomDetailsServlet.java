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

@WebServlet(name = "RoomDetailsServlet", urlPatterns = { "/RoomDetailsServlet" })
public class RoomDetailsServlet extends HttpServlet {

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
		HttpSession session=req.getSession();

		if( req.getParameter("RID")!=null){
			String str=req.getParameter("RID");
			int rid=Integer.parseInt(str);

			RoomManager rm=new RoomManager();
			Room room=rm.getRoom(rid);
			session.setAttribute("Room", room);
		}

		req.getRequestDispatcher("RoomDetails.jsp").forward(req, res);
	}
}
