package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;

import org.glassfish.jersey.client.ClientConfig;

import requestsresponses.Alumno;
import requestsresponses.Profesor;

/**
 * Servlet implementation class Profesor2Servlet
 */
@WebServlet("/profesor2")
public class Profesor2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Profesor2Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    protected WebTarget target(){
    	ClientConfig config = new ClientConfig();		
		Client client = ClientBuilder.newClient(config);
		WebTarget target = client.target(
				"http://localhost:8080/Grupo5WebServices/rest/");
		return target;
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		
		String respuesta = target().path("profesores").queryParam("id", id)
				.request()
				.accept("text/plain")//recibe texto plano
				.delete(String.class);
		RequestDispatcher rd=request.getRequestDispatcher("confirmar.jsp");
		request.setAttribute("msg", respuesta);
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("id"));
		String nombres = request.getParameter("nombre");
		String apellido_paterno = request.getParameter("apellidop");
		String apellido_materno= request.getParameter("apellidom");
		String dni = request.getParameter("dni");
		String foto_url = request.getParameter("urlfoto");
		int id_estudio = Integer.parseInt(request.getParameter("idEstudio"));
		
		
		Profesor profesor = new Profesor(id, nombres, apellido_paterno, apellido_materno, dni, foto_url, id_estudio);
		
			
		String respuesta = target().path("profesores")
				.request()
				.accept("text/plain") //el cliente acepta un texto plano
				.put(
						Entity.json(profesor),
						String.class//Cadena que devuelve un texto plano
						);		
		RequestDispatcher rd=request.getRequestDispatcher("confirmar.jsp");
		request.setAttribute("msg", respuesta);		
		rd.forward(request, response);
	}

}