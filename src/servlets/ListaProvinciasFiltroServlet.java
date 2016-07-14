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

import beans.Distrito;
import beans.Provincia;

/**
 * Servlet implementation class ListaProvinciasFiltroServlet
 */
@WebServlet("/listaProvinciasFiltro")
public class ListaProvinciasFiltroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListaProvinciasFiltroServlet() {
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
		int id=Integer.parseInt(request.getParameter("departamento"));
		String action=request.getParameter("action");		
		
		List<Provincia> respuesta = target().path("provincias/filtro/lista").queryParam("idDepartamento", id)
			.request()
			.accept("application/json")
			.get(new GenericType<List<Provincia>>(){});
		if(action.equalsIgnoreCase("registrarDistrito")){
			RequestDispatcher rd=request.getRequestDispatcher("postDistrito.jsp");
			request.setAttribute("provinciasFiltro", respuesta);
			rd.forward(request, response);
		}else if(action.equalsIgnoreCase("editarDistrito")){
			Integer idDistrito=Integer.parseInt(request.getParameter("idDistrito"));
			Distrito dist = target().path("distritos").queryParam("id", idDistrito)
					.request()
					.accept("application/json")//recibe el json
					.get(Distrito.class);			
			RequestDispatcher rd=request.getRequestDispatcher("putDistrito.jsp");
			request.setAttribute("provinciasFiltro", respuesta);
			request.setAttribute("distrito", dist);
			rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

	}

}
