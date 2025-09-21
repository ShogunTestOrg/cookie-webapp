import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/CreateCookieServlet")
public class CreateCookieServlet extends HttpServlet {
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        // Get form data
        String username = request.getParameter("username");
        String secretcode = request.getParameter("secretcode");
        
        // Create cookies
        Cookie userCookie = new Cookie("username", username);
        Cookie codeCookie = new Cookie("secretcode", secretcode);
        
        // Set cookie expiry (30 minutes)
        userCookie.setMaxAge(30 * 60);
        codeCookie.setMaxAge(30 * 60);
        
        // Add cookies to response
        response.addCookie(userCookie);
        response.addCookie(codeCookie);
        
        // Display confirmation
        out.println("<html><head><title>Cookie Created</title></head><body>");
        out.println("<h2>Cookie Created Successfully!</h2>");
        out.println("<p>Name: " + username + "</p>");
        out.println("<p>Secret Code: " + secretcode + "</p>");
        out.println("<p>Cookie will expire in 30 minutes.</p>");
        out.println("<br><a href='index.html'>Go Back</a>");
        out.println("<br><a href='ReadCookieServlet'>Read Cookie</a>");
        out.println("</body></html>");
    }
}
