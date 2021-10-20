
package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/CarritoServlet")
public class CarritoServlet extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
        response.setContentType("text/html;charset=UTF-8");
        
        String articuloNuevo = request.getParameter("articulo");
        
        HttpSession sesion = request.getSession();
         List<String> articulos = (List<String>) sesion.getAttribute("articulos");
         
         if (articulos == null) {
            articulos = new ArrayList<>();
            sesion.setAttribute("articulos", articulos);
        }
         
         if (articuloNuevo != null && !articuloNuevo.trim().equals("")) {
            articulos.add(articuloNuevo);
        }
         
         PrintWriter out = response.getWriter();
         
         out.print("<h1>Lista de Articulos</h1>");
         out.print("<br>");
         for (String a: articulos) {
            out.print("<li>" + a + "</li>");
        }
         
         out.print("<br>");
         out.print("<a href='/EjemploCarritoCompras'>Regresal al Inicio</a>");
         out.close();
    }
}
