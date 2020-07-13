package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.User;
import service.AdminUserService;

/**
 * Servlet implementation class AdminUserController
 */
@WebServlet(description = "ovde admin kontrolise usere", urlPatterns = { "/AdminUserController" })
public class AdminUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		AdminUserService service = new AdminUserService();
		
		List<User> sviUseriIzBaze = new ArrayList<User>();
		
		sviUseriIzBaze = service.vratiSveUsereIzBaze();
		
		if(sviUseriIzBaze != null) {
			request.setAttribute("listaUsera", sviUseriIzBaze);
			RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/adminUser.jsp");
			dispatcher.forward(request, response);
					
		}else {
			response.sendRedirect("jsp/adminPage.jsp");
		}
		
		
	}

}
