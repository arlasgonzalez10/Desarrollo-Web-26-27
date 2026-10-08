package org.cuatrovientos.web; 
  
import java.io.IOException; 
import java.time.Instant; 
  
import jakarta.servlet.ServletException; 
import jakarta.servlet.annotation.WebServlet; 
import jakarta.servlet.http.HttpServlet; 
import jakarta.servlet.http.HttpServletRequest; 
import jakarta.servlet.http.HttpServletResponse; 
import jakarta.servlet.http.HttpSession; 
  
@WebServlet("/session") 
public class SessionServlet extends HttpServlet { 
  
    private static final String VISITS_ATTRIBUTE = "visits"; 
  
    @Override 
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
        HttpSession session = request.getSession(); 
        Integer previousVisits = (Integer) session.getAttribute(VISITS_ATTRIBUTE); 
        int visits = previousVisits == null ? 1 : previousVisits + 1; 
        session.setAttribute(VISITS_ATTRIBUTE, visits); 
  
        request.setAttribute("sessionId", session.getId()); 
        request.setAttribute("newSession", session.isNew()); 
        request.setAttribute("createdAt", Instant.ofEpochMilli(session.getCreationTime()).toString()); 
        request.setAttribute("visits", visits); 
        request.setAttribute("maxInactiveInterval", session.getMaxInactiveInterval()); 
  
        request.getRequestDispatcher("/WEB-INF/views/session.jsp").forward(request, response); 
    } 
  
    @Override 
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException { 
        HttpSession session = request.getSession(false); 
        if (session != null) {session.invalidate(); 
        } 
  
        String destination = request.getContextPath() + "/session"; 
        response.sendRedirect(response.encodeRedirectURL(destination)); 
    } 
} 