package org.cuatrovientos.web; 
  
import java.io.IOException; 
import java.util.Arrays; 
import java.util.Optional; 
import java.util.Set; 
  
import jakarta.servlet.ServletException; 
import jakarta.servlet.annotation.WebServlet; 
import jakarta.servlet.http.Cookie; 
import jakarta.servlet.http.HttpServlet; 
import jakarta.servlet.http.HttpServletRequest; 
import jakarta.servlet.http.HttpServletResponse; 
  
@WebServlet("/preferences") 
public class CookieServlet extends HttpServlet { 
  
    private static final Set<String> THEMES = Set.of("light", "dark"); 
  
    @Override 
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
        String theme = readCookie(request, "theme").filter(THEMES::contains).orElse("light"); 
        int visits = readCookie(request, "visits").map(this::parsePositiveInteger).orElse(0) + 1; 
  
        Cookie visitsCookie = new Cookie("visits", Integer.toString(visits)); 
        configureCookie(visitsCookie, request, 7 * 24 * 60 * 60); 
        response.addCookie(visitsCookie); 
  
        request.setAttribute("theme", theme); 
        request.setAttribute("visits", visits); 
        request.getRequestDispatcher("/WEB-INF/views/preferences.jsp").forward(request, response); 
    } 
  
    @Override 
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException { 
        String requestedTheme = request.getParameter("theme"); 
        String theme = THEMES.contains(requestedTheme) ? requestedTheme : "light"; 
        Cookie themeCookie = new Cookie("theme", theme); 
        configureCookie(themeCookie, request, 30 * 24 * 60 * 60); 
        response.addCookie(themeCookie); 
  
        response.sendRedirect(request.getContextPath() + "/preferences"); 
    } 
  
    private Optional<String> readCookie(HttpServletRequest request, String name) { 
        if (request.getCookies() == null) { 
            return Optional.empty(); 
        } 
  
        return Arrays.stream(request.getCookies()) 
            .filter(cookie -> name.equals(cookie.getName())) 
            .map(Cookie::getValue) 
            .findFirst(); 
    } 
  
    private int parsePositiveInteger(String value) { 
        try { 
            return Math.max(0, Integer.parseInt(value)); 
        } catch (NumberFormatException exception) { 
            return 0; 
        } 
    } 
  
    private void configureCookie( Cookie cookie, HttpServletRequest request, int maxAgeSeconds) { 
        String contextPath = request.getContextPath(); 
        cookie.setPath(contextPath.isEmpty() ? "/" : contextPath); 
        cookie.setMaxAge(maxAgeSeconds); 
        cookie.setHttpOnly(true); 
        cookie.setSecure(request.isSecure()); 
        cookie.setAttribute("SameSite", "Lax"); 
    } 
} 