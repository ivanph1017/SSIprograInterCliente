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

import beans.Departamento;

/**
 * Servlet implementation class ListaDepartamentosFiltroServlet
 */
@WebServlet("/listaDepartamentosFiltro")
public class ListaDepartamentosFiltroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListaDepartamentosFiltroServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("pais"));
		String action=request.getParameter("action");
		ClientConfig config = new ClientConfig();		
		Client client = ClientBuilder.newClient(config);
		WebTarget target = client.target(
				"http://localhost:8080/Grupo5WebServices/rest/");
		
		List<Departamento> respuesta = target.path("departamentos/listaFiltro").queryParam("idPais", id)
			.request()
			.accept("application/json")
			.get(new GenericType<List<Departamento>>(){});
		if(action.equalsIgnoreCase("registrar")){
			RequestDispatcher rd=request.getRequestDispatcher("agregarProvincia.jsp");
			request.setAttribute("departamentosFiltro", respuesta);
			rd.forward(request, response);
		}else if(action.equalsIgnoreCase("editar")){
			RequestDispatcher rd=request.getRequestDispatcher("editarProvincia.jsp");
			request.setAttribute("departamentosFiltro", respuesta);
			rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

}
