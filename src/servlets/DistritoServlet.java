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

import beans.Distrito;
import beans.Provincia;

/**
 * Servlet implementation class SeccionServlet
 */
@WebServlet("/distrito")
public class DistritoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DistritoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    

	protected WebTarget target(){
    	ClientConfig config = new ClientConfig();		
		Client client = ClientBuilder.newClient(config);
		WebTarget target = client.target(
				"http://localhost:8080/SergioSandraIvanWebServices/rest/");
		return target;
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
		String action=request.getParameter("action");	
		
		Distrito respuesta = target().path("distritos").queryParam("id", id)
				.request()
				.accept("application/json")//recibe el json
				.get(Distrito.class);
		if(action.equals("ver")){
			RequestDispatcher rd=request.getRequestDispatcher("verDistrito.jsp");
			request.setAttribute("distrito", respuesta);		
			rd.forward(request, response);
		}else if(action.equals("editar")){
			RequestDispatcher rd=request.getRequestDispatcher("editarDistrito.jsp");
			request.setAttribute("distrito", respuesta);		
			rd.forward(request, response);
		}		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombre=request.getParameter("nombre");
		int idProvincia=Integer.parseInt(request.getParameter("provincia"));
		int poblacion=Integer.parseInt(request.getParameter("poblacion"));
		
		Provincia provincia = target().path("provincias").queryParam("id", idProvincia)
				.request()
				.accept("application/json")//recibe el json
				.get(Provincia.class);
		
		Distrito distrito = new Distrito(0, nombre, poblacion, provincia);
		
		String respuesta = target().path("distritos")
				.request()
				.accept("text/plain") //el cliente acepta un texto plano
				.post(
						Entity.json(distrito),
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
		
		
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
