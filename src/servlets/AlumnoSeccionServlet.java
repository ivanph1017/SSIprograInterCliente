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

import requestsresponses.AlumnoResponse;
import requestsresponses.RequestAlumnosSeccion;
import requestsresponses.SeccionResponse;

/**
 * Servlet implementation class AlumnoSeccionServlet
 */
@WebServlet("/alumnoSeccion")
public class AlumnoSeccionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AlumnoSeccionServlet() {
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
		
			Map<Integer, Integer> relacionAlumnos = target().path("alumnosSeccion").queryParam("id_seccion", id_seccion)
				.request()
				.accept("application/json")//recibe el json
				.get(new GenericType<Map<Integer, Integer>>(){}); //convierte en el json en un mapa de integer y booleans
			
			RequestDispatcher rd=request.getRequestDispatcher("asignarAlumnosASeccion.jsp");
			request.setAttribute("seccionPertenece", seccion);
			request.setAttribute("relacionAlumnos", relacionAlumnos);			
			rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id_seccion = Integer.parseInt(request.getParameter("idSeccion"));
		Map<Integer, Integer> mapaPertenece=new LinkedHashMap<>();
		
		List<AlumnoResponse> listaAlumnos = target().path("alumnos/lista")
				.request()
				.accept("application/json")//recibe el json
				.get(new GenericType<List<AlumnoResponse>>(){}); //convierte en el json en una lista AlumnosResponse
		
		Enumeration<String> listaID=request.getParameterNames();
		List<String> lista = Collections.list(listaID);
		for(int i=1;i<lista.size();i++){
			String valor=request.getParameter(lista.get(i));
			if(valor.equalsIgnoreCase("true")){
				mapaPertenece.put(Integer.parseInt(lista.get(i)), 1);
			}else if(valor.equalsIgnoreCase("false")){
				mapaPertenece.put(Integer.parseInt(lista.get(i)), 0);
			}
		}		
		
		RequestAlumnosSeccion alumnosSeccion=new RequestAlumnosSeccion(mapaPertenece, id_seccion);
		
		String respuesta = target().path("alumnosSeccion")
				.request()
				.accept("text/plain") //el cliente acepta un texto plano
				.post(
						Entity.json(alumnosSeccion),
						String.class//Cadena que devuelve un texto plano
						);		
		RequestDispatcher rd=request.getRequestDispatcher("confirmar.jsp");
		request.setAttribute("msg", respuesta);		
		rd.forward(request, response);
			
	}

}
