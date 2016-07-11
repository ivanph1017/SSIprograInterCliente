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

import com.owlike.genson.Genson;


import requestsresponses.Profesor;
import requestsresponses.ProfesorResponse;

/**
 * Servlet implementation class ProfesorServlet
 */
@WebServlet("/profesor")
public class ProfesorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfesorServlet() {
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
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
		String action=request.getParameter("action");		
		
		
		ProfesorResponse respuesta = target().path("profesores").queryParam("id", id)
				.request()
				.accept("application/json")//recibe el json
				.get(ProfesorResponse.class);
		if(action.equals("ver")){
			RequestDispatcher rd=request.getRequestDispatcher("verProfesor.jsp");
			request.setAttribute("profesor", respuesta);		
			rd.forward(request, response);
		}else if(action.equals("editar")){
			RequestDispatcher rd=request.getRequestDispatcher("editarProfesor.jsp");
			request.setAttribute("profesor", respuesta);		
			rd.forward(request, response);
		}			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombres = request.getParameter("nombre");
		String apellido_paterno = request.getParameter("apellidop");
		String apellido_materno= request.getParameter("apellidom");
		String dni = request.getParameter("dni");
		String foto_url = request.getParameter("urlfoto");		
		int id_estudio = Integer.parseInt(request.getParameter("estudio"));
		
		Profesor profe=new Profesor(0, nombres, apellido_paterno, apellido_materno, dni, foto_url, id_estudio);
		
		
		
		String respuesta = target().path("profesores")
				.request()
				.accept("text/plain") //el cliente acepta un texto plano
				.post(
						Entity.json(profe),
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
