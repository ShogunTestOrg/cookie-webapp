import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/ReadCookieServlet")
public class ReadCookieServlet extends HttpServlet {
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        out.println("<html><head><title>Cookie Information</title></head><body>");
        out.println("<h2>Stored Cookie Information</h2>");
        
        // Get all cookies
        Cookie[] cookies = request.getCookies();
        
        String username = null;
        String secretcode = null;
        
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("username".equals(cookie.getName())) {
                    username = cookie.getValue();
                } else if ("secretcode".equals(cookie.getName())) {
                    secretcode = cookie.getValue();
                }
            }
        }
        
        // Display cookie information
        if (username != null && secretcode != null) {
            out.println("<table border='1'>");
            out.println("<tr><th>Field</th><th>Value</th></tr>");
            out.println("<tr><td>Name</td><td>" + username + "</td></tr>");
            out.println("<tr><td>Secret Code</td><td>" + secretcode + "</td></tr>");
            out.println("</table>");
        } else {
            out.println("<p>No cookies found or cookies have expired.</p>");
            out.println("<p>Please create cookies first.</p>");
        }
        
        out.println("<br><a href='index.html'>Create New Cookie</a>");
        out.println("</body></html>");
    }
}