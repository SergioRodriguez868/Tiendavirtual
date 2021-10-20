package co.edu.unbosque.Ciclo3;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet_clientes
 */
@WebServlet("/Servlet_clientes")
public class Servlet_clientes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet_clientes() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String listar = request.getParameter("Listar");
		String agregar = request.getParameter("Agregar");
		if (agregar != null) {
			agregarClientes(request, response);
		}
		if (listar != null) {
			listarClientes(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	
	public void agregarClientes (HttpServletRequest request, HttpServletResponse response) {
		Clientes cliente = new Clientes();
		cliente.setIDcliente(Long.valueOf(request.getParameter("IDcliente")));
		cliente.setNombres(request.getParameter("Nombres"));
		cliente.setApellidos(request.getParameter("Apellidos"));
		cliente.setCelular(Long.valueOf(request.getParameter("Celular")));
		cliente.setCorreo(request.getParameter("Correo"));
		cliente.setDireccion(request.getParameter("Direccion"));
		cliente.setUsuario(request.getParameter("Usuario"));
		cliente.setPassword(request.getParameter("Password"));
		int respuesta = 0;
		try {
			respuesta = ClientesJSON.postJSON(cliente);
			PrintWriter writer = response.getWriter();
			if (respuesta == 200) {
				writer.println("Registro agregado");
			}else {
				writer.println("Error" + respuesta);
			}
			writer.close();
		}catch (IOException e){
			e.printStackTrace();
		}
		
	}
	public void listarClientes (HttpServletRequest request, HttpServletResponse response) {
		try {
			ArrayList<Clientes> lista = ClientesJSON.getJSON();
			String pagina = "/Lista_clientes.jsp";
			request.setAttribute("lista", lista);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
			dispatcher.forward(request, response);
		}catch (Exception e){
			e.printStackTrace();
		}
	}
}
