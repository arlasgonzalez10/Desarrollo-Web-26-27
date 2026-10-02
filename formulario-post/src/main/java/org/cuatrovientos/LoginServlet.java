package org.cuatrovientos;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       String username = request.getParameter("username");
       String password = request.getParameter("password");

       boolean isAuthenticated = "admin".equals(username) && "password".equals(password);

       request.setAttribute("message", 
       isAuthenticated
       ? "Has iniciado sesión correctamente." 
       : "No has podido iniciar sesión. Credenciales inválidas!"
       );

       request.getRequestDispatcher("/WEB-INF/views/login-result.jsp").forward(request, response);
    }
}
