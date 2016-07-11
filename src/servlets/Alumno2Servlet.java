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

/**
 * Servlet implementation class Alumno2Servlet
 */
@WebServlet("/alumno2")
public class Alumno2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Alumno2Servlet() {
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
		
		String respuesta = target().path("alumnos").queryParam("id", id)
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
		int codigo = Integer.parseInt(request.getParameter("codigo"));
		int id_colegio = Integer.parseInt(request.getParameter("colegio"));
		
		Alumno alumno = new Alumno(id, nombres, apellido_paterno, apellido_materno, dni, foto_url, codigo, id_colegio);
		
			
		String respuesta = target().path("alumnos")
				.request()
				.accept("text/plain") //el cliente acepta un texto plano
				.put(
						Entity.json(alumno),
						String.class//Cadena que devuelve un texto plano
						);		
		RequestDispatcher rd=request.getRequestDispatcher("confirmar.jsp");
		request.setAttribute("msg", respuesta);		
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
