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

@WebServlet("/NewUserServlet")
public class NewUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/NewUser.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String newId = request.getParameter("newId");
		String pass = request.getParameter("pass");
		String pass2 =request.getParameter("pass2");
		String userName =request.getParameter("userName");
		String birth =request.getParameter("birth");

		if(!pass.equals(pass2)) {
			request.setAttribute("errMsg", "入力したパスワードが一致しません");

			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/NewUser.jsp");
			dispatcher.forward(request, response);
			return;
		}
		UserDao userDao = new UserDao();
		User user = userDao.newUser(newId,pass,pass2,userName,birth);

		if (user == null) {
			request.setAttribute("errMsg", "入力された内容は正しくありません");

			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/NewUser.jsp");
			dispatcher.forward(request, response);
			return;
		}
		response.sendRedirect("UserListServlet");
	}

}
