package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.DodajBalanceService;

/**
 * Servlet implementation class DodajBalanceController
 */
@WebServlet("/DodajBalanceController")
public class DodajBalanceController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DodajBalanceService service = new DodajBalanceService();
		
		String idUser = request.getParameter("idUser");
		String balance = request.getParameter("balance");
		
		System.out.println("Id: " + idUser);
		System.out.println("Balance: " + balance);
		boolean daLiJeDodaoBalance = service.dodajBalance(idUser,balance);
		
		if(daLiJeDodaoBalance) {
			response.sendRedirect("AdminUserController");
		}else {
			response.sendRedirect("jsp/dodajBalance.jsp");
		}
		
		
	}

}
