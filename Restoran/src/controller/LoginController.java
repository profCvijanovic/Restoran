package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Rola;
import model.User;
import service.LoginService;

/**
 * Servlet implementation class LoginController
 */
@WebServlet(description = "ovo je kontroler za log in", urlPatterns = { "/LoginController" })
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		LoginService service = new LoginService();
		
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		
		User userIzBaze = service.vratiUseraSaOvimUserNameom(userName);
		
		if(userIzBaze != null) {
			// idemo dalje, poredimo password
			boolean poredimPassworde = service.uporediPassworde(password, userIzBaze.getPassword());
			if(poredimPassworde) {
				//sve ok, postoji user sa tim usernameom i tim passwordom
				System.out.println("OK je password");
				
				//pravim session object
				HttpSession sessionObject = request.getSession();
				// ubacujem user object (model) u sesiju
				sessionObject.setAttribute("user", userIzBaze);
				
				if(userIzBaze.getRola() == Rola.KORISNIK) {
					response.sendRedirect("jsp/userPage.jsp");
				}else {
					response.sendRedirect("jsp/adminPage.jsp");
				}			
			}else {
				System.out.println("Los je password");
				response.sendRedirect("html_fajlovi/neuspesno.html");
			}	
		}else {
			response.sendRedirect("html_fajlovi/neuspesno.html");
		}
		
		
		
		
		
		
		
		
	}

}
