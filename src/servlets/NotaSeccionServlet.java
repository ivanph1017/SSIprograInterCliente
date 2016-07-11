package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

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
import javax.ws.rs.core.GenericType;

import org.glassfish.jersey.client.ClientConfig;

import requestsresponses.AlumnoSeccion;
import requestsresponses.SeccionResponse;

/**
 * Servlet implementation class NotaSeccion
 */
@WebServlet("/notaSeccion")
public class NotaSeccionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NotaSeccionServlet() {
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
		
		SeccionResponse seccion = target().path("secciones").queryParam("id", id)
			.request()
			.accept("application/json")//recibe el json
			.get(SeccionResponse.class);
		
		int id_seccion=id;
		
		List<AlumnoSeccion> alumnosSeccion = target().path("alumnosSeccion/lista").queryParam("id_seccion", id_seccion)
				.request()
				.accept("application/json")//recibe el json
				.get(new GenericType<List<AlumnoSeccion>>(){});
		
		Map<Integer, Integer> relacionAlumnos = target().path("notasSeccion").queryParam("id_seccion", id_seccion)
			.request()
			.accept("application/json")//recibe el json
			.get(new GenericType<Map<Integer, Integer>>(){}); //convierte en el json en un mapa de integer y integer
		
		RequestDispatcher rd=request.getRequestDispatcher("asignarNotasAlumnoSeccion.jsp");
		request.setAttribute("seccionNotas", seccion);
		request.setAttribute("alumnosSeccion", alumnosSeccion);
		request.setAttribute("relacionAlumnosNotas", relacionAlumnos);			
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
					
		Enumeration<String> listaID=request.getParameterNames();
		List<String> lista = Collections.list(listaID);
		Map<Integer, Integer> mapita=new LinkedHashMap<>();
		for(int i=0;i<lista.size();i++){
			int nota=Integer.parseInt(request.getParameter(lista.get(i)));
			mapita.put(Integer.parseInt(lista.get(i)), nota);
		}
		String respuesta = target().path("notasSeccion")
				.request()
				.accept("text/plain") //el cliente acepta un texto plano
				.post(
						Entity.json(mapita),
						String.class//Cadena que devuelve un texto plano
						);		
		RequestDispatcher rd=request.getRequestDispatcher("confirmar.jsp");	
		request.setAttribute("msg", respuesta);
		rd.forward(request, response);
	}

}
