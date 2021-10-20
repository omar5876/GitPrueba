
package web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/SesionesServlet")
public class SesionesServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
        response.setContentType("text/html;charset=UTF-8");
        HttpSession sesion = request.getSession();
        
        String titulo = null;
        
        Integer contadorVisitas = (Integer) sesion.getAttribute("contadorVisitas");
        
        if (contadorVisitas == null) {
            contadorVisitas = 1;
            titulo = "Bienvenido por primera vez";
        }
        else{
            contadorVisitas++;
            titulo = "Bienvenido nuevamente";
        }
        
        sesion.setAttribute("contadorVisitas", contadorVisitas);
        
        PrintWriter out = response.getWriter();
        out.print(titulo);
        out.print("<br>");
        out.print("Contador Visitas: " + contadorVisitas);
        out.print("<br>");
        out.print("ID de la session: " + sesion.getId());
        out.close();
    }
    
}
