package servlets;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;

import org.glassfish.jersey.client.ClientConfig;

/**
 * Servlet implementation class MySQLDistritosServlet
 */
@WebServlet("/mySQLDistritos")
@MultipartConfig(maxFileSize= 16177215)
public class MySQLDistritosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MySQLDistritosServlet() {
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
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Part filePart=request.getPart("txt");
		InputStream inputStream;
		RequestDispatcher rd=request.getRequestDispatcher("confirmar.jsp");
		String respuesta="No se encontró ninguna línea SQL";
		Scanner scan;
		String sql;
		if(filePart!=null){
			inputStream=filePart.getInputStream();
			scan=new Scanner(inputStream);			
			scan.useDelimiter("/");
			while(scan.hasNext()){
				sql=scan.next();
				respuesta = target().path("distritos/carga")
						.request()
						.accept("text/plain") //el cliente acepta un texto plano
						.post(
								Entity.text(sql),
								String.class//Cadena que devuelve un texto plano
								);
			}						
		}else{
			respuesta="Error al subir el archivo";			
		}
		request.setAttribute("msg", respuesta);
		rd.forward(request, response);
	}

}
