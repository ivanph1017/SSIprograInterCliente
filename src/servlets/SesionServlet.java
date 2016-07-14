package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;

import org.glassfish.jersey.client.ClientConfig;

import beans.Pais;
;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/sesion")
public class SesionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SesionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ClientConfig config = new ClientConfig();		
		Client client = ClientBuilder.newClient(config);
		WebTarget target = client.target( //direccion de los servicios
				"http://localhost:8080/SergioSandraIvanWebServices/rest/");
		List<Pais> paises = target.path("paises/lista") //direccion de un solo servicio
				.request()
				.accept("application/json") //un solo metodo del ese servicio (operacion get, post...)
				.get(new GenericType<List<Pais>>(){});
		
		RequestDispatcher rd=request.getRequestDispatcher("sesion.jsp");
		request.getSession().setAttribute("paises", paises);		
		rd.forward(request, response);
	}

}
