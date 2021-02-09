package com.uniovi.sdi;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.org.apache.xml.internal.utils.IntVector;

/**
 * Servlet implementation class ServletEliminar
 */
@WebServlet("/eliminarDeCarrito")
public class ServletEliminar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletEliminar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		HashMap<String, Integer> carrito = (HashMap<String, Integer>) request.getSession().getAttribute("carrito");
		
		if(carrito != null) {
			String	producto = request.getParameter("par");
			if(producto != null) {
				eliminarDelCarrito(carrito, producto);
			}
		}
		
		request.setAttribute("paresCarrito",	carrito);
		getServletContext().getRequestDispatcher("/vista-carrito.jsp").forward(request, response);
	
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<HTML>");
		out.println("<HEAD><TITLE>Tienda	SDI:	carrito</TITLE></HEAD>");
		out.println("<BODY>");
		out.println(carritoEnHTML(carrito) + "<br>");
		out.println("<a	href=\"index.jsp\">Volver</a></BODY></HTML>");
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private void eliminarDelCarrito(Map<String,Integer> carrito, String claveProducto) {
		if(carrito.get(claveProducto) != null) {
			int numeroArticulos = (Integer)carrito.get(claveProducto).intValue();
			if(numeroArticulos > 1) {
				carrito.put(claveProducto, new Integer(numeroArticulos-1));
				//carrito.put(claveProducto, new Integer(1));
			}
			else {
				/*
				int numeroArticulos = (Integer)carrito.get(claveProducto).intValue();
				carrito.put(claveProducto, new Integer(numeroArticulos+1));
				*/
				carrito.remove(claveProducto);
			}
		}
	}
	
	private String carritoEnHTML(Map<String,Integer> carrito) {
		String carritoEnHTML="";
		for(String key:carrito.keySet())
			carritoEnHTML +="<p>["+key+"], "+ carrito.get(key)+" unidades</p>";
		return carritoEnHTML;
	}

}
