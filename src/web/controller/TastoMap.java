package web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import web.model.Employee;   
import javax.servlet.http.HttpSession;

import logic.applicationController.MapController;
import logic.bean.EventBean;
import logic.utils.SessionArtist;
import logic.utils.SessionSponsor;
import logic.utils.SessionUser;

/**
 * Servlet implementation class Map
 */
@WebServlet("/TastoMap")
public class TastoMap extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Employee Utente = new Employee();
    String TipoUtente;
    SessionArtist sa = SessionArtist.getInstance();
	SessionSponsor ss = SessionSponsor.getInstance();
	int ringbell = 0;
	
    public TastoMap() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String result =request.getParameter("action");
        
        MapController mc = new MapController();
        List<EventBean> leb = mc.liveEventsList();
        
        HttpSession session = request.getSession();
        
        //ringbell is the variable that serves to understand if the targetted show is live
        
        for(int i=0; i<leb.size(); i++) {
        	if(leb.get(i).getPlace().equals(result)) {
        		session.setAttribute("mapPlace", leb.get(i).getPlace());
        		session.setAttribute("mapArtist", leb.get(i).getArtist());
        		session.setAttribute("mapDescription", leb.get(i).getDescription());
        		ringbell = 1;
        	}
        }
        
        if(ringbell==0) {
        	session.setAttribute("mapPlace", "there is no show here");
    		session.setAttribute("mapArtist", "there is no show here");
    		session.setAttribute("mapDescription", "there is no show here");
        }
        
        ringbell=0;
        SessionUser su = SessionUser.getInstance();
        if(sa.getUsername()!=null) {
        	RequestDispatcher dispatcherN = request.getRequestDispatcher("/WEB-INF/views/MapArtist.jsp");
        	dispatcherN.forward(request, response);
        }
        if(su.getId()==3) {
        	RequestDispatcher dispatcherM = request.getRequestDispatcher("/WEB-INF/views/MapArtist.jsp");
        	dispatcherM.forward(request, response);
        }
        else {
        	RequestDispatcher dispatcherJ = request.getRequestDispatcher("/WEB-INF/views/Map.jsp");
        	dispatcherJ.forward(request, response);
        }
        
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	    if (sa.getUsername()!=null){
	    RequestDispatcher dispatcher2 = request.getRequestDispatcher("/WEB-INF/views/MapArtist.jsp");
		dispatcher2.forward(request, response);
	    }
	    if (ss.getUsername()!=null){
		    RequestDispatcher dispatcher3 = request.getRequestDispatcher("/WEB-INF/views/Homepagesponsor.jsp");
			dispatcher3.forward(request, response); 
	    }
	    else{
		RequestDispatcher dispatcher1 = request.getRequestDispatcher("/WEB-INF/views/Map.jsp");
	    dispatcher1.forward(request, response);
		}
		
		
		
	   
	}
	}

