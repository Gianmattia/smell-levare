package web.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logic.utils.SessionArtist;
import logic.utils.SessionSponsor;
import logic.utils.SessionUser;
import web.model.Employee;   

/**
 * Servlet implementation class TastoProfile
 */
@WebServlet("/TastoProfile")
public class TastoProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Employee Utente = new Employee();
    String TipoUtente;

    public TastoProfile() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		SessionArtist sa = SessionArtist.getInstance();
		SessionSponsor ss = SessionSponsor.getInstance();
		SessionUser su = SessionUser.getInstance();
		
		
	    if (sa.getUsername()!=null){
	    RequestDispatcher dispatcher2 = request.getRequestDispatcher("/WEB-INF/views/HomepageArtists.jsp");
		dispatcher2.forward(request, response);
	    }
	    if (su.getId()==3){
		    RequestDispatcher dispatcher3 = request.getRequestDispatcher("/WEB-INF/views/HomepageUsersSponsor.jsp");
			dispatcher3.forward(request, response); 
	    }
	    else{
		RequestDispatcher dispatcher1 = request.getRequestDispatcher("/WEB-INF/views/Profileusers.jsp");
	    dispatcher1.forward(request, response);
		}
		
	
	}
	}

