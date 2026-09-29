package org.cuatrovientos;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/product")
public class HtmlResponseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter writer = response.getWriter();
        writer.println("<!doctype html>");
        writer.println("<head>");
        writer.println("<title>Nuestro Producto</title>");
        writer.println("</head>");
        writer.println("<body>");
        writer.println("<h1>Nuestro Producto</h1>");
        writer.println("<p>Nombre: Teclado Mecánico</p>");
        writer.println("<p>Precio: 50.00 €</p>");
        writer.println("<p>Marca: Ozone</p>");
        writer.println("<p>Nombre: Teclado Mecánico</p>");
        writer.println("</body>");
        writer.println("</html>");
    }
}
