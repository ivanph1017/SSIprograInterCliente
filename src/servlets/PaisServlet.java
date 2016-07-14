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

import beans.Pais;


/**
 * Servlet implementation class AlumnoServlet
 */
@WebServlet("/pais")
public class PaisServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PaisServlet() {
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
		
		
		Pais respuesta = target().path("paises").queryParam("id", id)
				.request()
				.accept("application/json")//recibe el json
				.get(Pais.class);
		if(action.equals("ver")){
			RequestDispatcher rd=request.getRequestDispatcher("verPais.jsp");
			request.setAttribute("pais", respuesta);		
			rd.forward(request, response);
		}else if(action.equals("editar")){
			RequestDispatcher rd=request.getRequestDispatcher("editarPais.jsp");
			request.setAttribute("pais", respuesta);		
			rd.forward(request, response);
		}				
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombre = request.getParameter("nombre");
		int poblacion=Integer.parseInt(request.getParameter("poblacion"));
		float pbi=Float.parseFloat(request.getParameter("pbi"));		
		
		Pais pais=new Pais(0, nombre, poblacion, pbi);
		
			
		String respuesta = target().path("paises")
				.request()
				.accept("text/plain") //el cliente acepta un texto plano
				.post(
						Entity.json(pais),
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
