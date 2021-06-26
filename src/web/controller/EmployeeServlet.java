package web.controller;

import java.util.Enumeration;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import logic.applicationController.HomepageArtistController;
import logic.bean.EventBean;
import web.model.Employee;
import web.entity.Artist;
import web.model.Employee;   
@WebServlet("/register")
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Employee Utente = new Employee();
    String TipoUtente;

    public EmployeeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		session.setAttribute("Capienza", 0); //questo serve perchè altrimenti al primo avvio mapArtist va in errore
		
	   
		    RequestDispatcher dispatcher1 = request.getRequestDispatcher("/WEB-INF/views/Login.jsp");
		    dispatcher1.forward(request, response);
	    
	    
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		 //not used
		}
		}


