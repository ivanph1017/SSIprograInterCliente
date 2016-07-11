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
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;

import org.glassfish.jersey.client.ClientConfig;

import requestsresponses.Alumno;
import requestsresponses.AlumnoResponse;
import requestsresponses.Colegio;
import requestsresponses.Curso;
import requestsresponses.CursoResponse;
import requestsresponses.Escuela;
import requestsresponses.Estudio;
import requestsresponses.ProfesorResponse;
import requestsresponses.SeccionResponse;

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
		/*ClientConfig config = new ClientConfig();		
		Client client = ClientBuilder.newClient(config);
		WebTarget target = client.target( //direccion de los servicios
				"http://localhost:8080/Grupo5WebServices/rest/");
		
		List<Colegio> colegios = target.path("colegios/lista")//direccion de un solo servicio
				.request()
				.accept("application/json") //un solo metodo del ese servicio (operacion get, post...)
				.get(new GenericType<List<Colegio>>(){});
		List<Escuela> escuelas = target.path("escuelas/lista")//direccion de un solo servicio
				.request()
				.accept("application/json") //un solo metodo del ese servicio (operacion get, post...)
				.get(new GenericType<List<Escuela>>(){});
		List<Estudio> estudios = target.path("estudios/lista")//direccion de un solo servicio
				.request()
				.accept("application/json") //un solo metodo del ese servicio (operacion get, post...)
				.get(new GenericType<List<Estudio>>(){});
		List<CursoResponse> cursos = target.path("cursos/lista")
				.request()
				.accept("application/json")
				.get(new GenericType<List<CursoResponse>>(){});
		List<ProfesorResponse> profesores = target.path("profesores/lista")
				.request()
				.accept("application/json")
				.get(new GenericType<List<ProfesorResponse>>(){});
		List<AlumnoResponse> alumnos = target.path("alumnos/lista")
				.request()
				.accept("application/json")//recibe el json
				.get(new GenericType<List<AlumnoResponse>>(){}); //convierte en el json en una lista AlumnosResponse
		List<SeccionResponse> secciones = target.path("secciones/lista")
				.request()
				.accept("application/json")
				.get(new GenericType<List<SeccionResponse>>(){});
		RequestDispatcher rd=request.getRequestDispatcher("sesion.jsp");
		request.getSession().setAttribute("colegios", colegios);
		request.getSession().setAttribute("escuelas", escuelas);
		request.getSession().setAttribute("estudios", estudios);
		request.getSession().setAttribute("cursos", cursos);
		request.getSession().setAttribute("profesores", profesores);
		request.getSession().setAttribute("alumnos", alumnos);
		request.getSession().setAttribute("secciones", secciones);
		rd.forward(request, response);*/
		RequestDispatcher rd=request.getRequestDispatcher("sesion.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
