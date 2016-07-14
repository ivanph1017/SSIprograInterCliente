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


import beans.Departamento;
import beans.Provincia;


/**
 * Servlet implementation class CursoServlet
 */
@WebServlet("/provincia")
public class ProvinciaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProvinciaServlet() {
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
		int id = Integer.parseInt(request.getParameter("id"));
		String action=request.getParameter("action");	
		
		Provincia respuesta = target().path("provincias").queryParam("id", id)
				.request()
				.accept("application/json")//recibe el json
				.get(Provincia.class);
		if(action.equals("ver")){
			RequestDispatcher rd=request.getRequestDispatcher("verProvincia.jsp");
			request.setAttribute("provincia", respuesta);		
			rd.forward(request, response);
		}else if(action.equals("editar")){
			RequestDispatcher rd=request.getRequestDispatcher("editarProvincia.jsp");
			request.setAttribute("provincia", respuesta);		
			rd.forward(request, response);
		}
					
				
	}	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombre = request.getParameter("nombre");
		int idDepa = Integer.parseInt(request.getParameter("departamento"));				
		
		Departamento depa = target().path("departamentos").queryParam("id", idDepa)
				.request()
				.accept("application/json")//recibe el json
				.get(Departamento.class);
		
		Provincia provincia = new Provincia(0, nombre, depa);
		
		String respuesta = target().path("provincias")
				.request()
				.accept("text/plain") //el cliente acepta un texto plano
				.post(
						Entity.json(provincia),
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
