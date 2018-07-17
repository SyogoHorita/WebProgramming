package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import model.User;

@WebServlet("/KousinServlet")
public class KousinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		 String loginId = request.getParameter("loginId");
		UserDao userDao = new UserDao();
		User user = userDao.detailUser(loginId);

		request.setAttribute("userDetail", user);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/kousin.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String loginId = request.getParameter("loginId");
		String pass = request.getParameter("pass");
		String pass2 = request.getParameter("pass2");
		String username = request.getParameter("username");
		String birth = request.getParameter("birth");

		if(!pass.equals(pass2)) {
			UserDao userDao = new UserDao();
			User user = userDao.detailUser(loginId);

			request.setAttribute("userDetail", user);
			request.setAttribute("errMsg", "入力したパスワードが一致しません");

			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/kousin.jsp");
			dispatcher.forward(request, response);
			return;
		}
		UserDao userDao = new UserDao();
		if(pass.equals("")) {
			userDao.kousinUser(loginId,username,birth);
		}else {
		userDao.kousinUser(loginId,pass,username,birth);
		}
		response.sendRedirect("UserListServlet");
	}
}
