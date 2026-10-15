package org.cuatrovientos; 
  
import java.io.IOException; 
  
import jakarta.servlet.ServletException; 
import jakarta.servlet.annotation.WebServlet; 
import jakarta.servlet.http.HttpServlet; 
import jakarta.servlet.http.HttpServletRequest; 
import jakarta.servlet.http.HttpServletResponse; 
  
@WebServlet("/product-status") 
public class ProductStatusServlet extends HttpServlet { 
  
    @Override 
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 

        request.setAttribute("productName", "Teclado mecánico"); 
        request.setAttribute("stock", 4); 
        request.getRequestDispatcher("/WEB-INF/views/product-status.jsp").forward(request, response); 
  
    }
} 