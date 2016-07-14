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
import beans.Provincia;

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
		int id=Integer.parseInt(request.getParameter("pais"));		
		String action=request.getParameter("action");
		
		List<Departamento> respuesta = target().path("departamentos/filtro/lista").queryParam("idPais", id)
			.request()
			.accept("application/json")
			.get(new GenericType<List<Departamento>>(){});
		if(action.equalsIgnoreCase("registrarProvincia")){
			RequestDispatcher rd=request.getRequestDispatcher("postProvincia.jsp");
			request.setAttribute("departamentosFiltro", respuesta);
			rd.forward(request, response);
		}else if(action.equalsIgnoreCase("editarProvincia")){
			int idProvincia=Integer.parseInt(request.getParameter("idProvincia"));
			Provincia prov = target().path("provincias").queryParam("id", idProvincia)
					.request()
					.accept("application/json")//recibe el json
					.get(Provincia.class);
			RequestDispatcher rd=request.getRequestDispatcher("putProvincia.jsp");
			request.setAttribute("departamentosFiltro", respuesta);
			request.setAttribute("provincia", prov);
			rd.forward(request, response);
		}else if(action.equalsIgnoreCase("registrarDistrito")){
			RequestDispatcher rd=request.getRequestDispatcher("selectorDepartamento.jsp");
			request.setAttribute("departamentosFiltro", respuesta);
			rd.forward(request, response);
		}else if(action.equalsIgnoreCase("editarDistrito")){
			Integer idDistrito=Integer.parseInt(request.getParameter("idDistrito"));			
			RequestDispatcher rd=request.getRequestDispatcher("selectorDepartamento.jsp");
			request.setAttribute("departamentosFiltro", respuesta);
			request.setAttribute("idDistrito", idDistrito);
			rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

}
