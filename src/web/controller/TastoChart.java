package web.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import logic.utils.SessionArtist;
import logic.utils.SessionSponsor;
import web.model.Employee;   

/**
 * Servlet implementation class TastoChart
 */
@WebServlet("/TastoChart")
public class TastoChart extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Employee Utente = new Employee();
    String TipoUtente;
    String Artist;

    public TastoChart() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Artist = request.getParameter("artist");
		HttpSession session = request.getSession();
		session.setAttribute("artist2", Artist);
		RequestDispatcher dispatcher4 = request.getRequestDispatcher("/WEB-INF/views/Chart.jsp");
	    dispatcher4.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SessionArtist sa = SessionArtist.getInstance();
		SessionSponsor ss = SessionSponsor.getInstance();
		
	    if (sa.getUsername()!=null){
	    RequestDispatcher dispatcher2 = request.getRequestDispatcher("/WEB-INF/views/ChartPerformer.jsp");
		dispatcher2.forward(request, response);
	    }
	    if (ss.getUsername()!=null){
		    RequestDispatcher dispatcher3 = request.getRequestDispatcher("/WEB-INF/views/Homepagesponsor.jsp");
			dispatcher3.forward(request, response); 
	    }
	    else{
		RequestDispatcher dispatcher1 = request.getRequestDispatcher("/WEB-INF/views/Search.jsp");
	    dispatcher1.forward(request, response);
		}
		
	}
	}

