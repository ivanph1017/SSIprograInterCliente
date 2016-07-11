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

import requestsresponses.Seccion;

/**
 * Servlet implementation class Seccion2Servlet
 */
@WebServlet("/seccion2")
public class Seccion2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Seccion2Servlet() {
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
		
		String respuesta = target().path("secciones").queryParam("id", id)
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
		int id= Integer.parseInt(request.getParameter("id"));
		int codigo = Integer.parseInt(request.getParameter("codigo"));
		int id_curso = Integer.parseInt(request.getParameter("curso"));						
		int id_profesor = Integer.parseInt(request.getParameter("profesor"));
		
		Seccion seccion=new Seccion(id, codigo, id_curso, id_profesor);
		
		String respuesta = target().path("secciones")
				.request()
				.accept("text/plain") //el cliente acepta un texto plano
				.put(
						Entity.json(seccion),
						String.class//Cadena que devuelve un texto plano
						);
		RequestDispatcher rd=request.getRequestDispatcher("confirmar.jsp");
		request.setAttribute("msg", respuesta);		
		rd.forward(request, response);
	}

}
