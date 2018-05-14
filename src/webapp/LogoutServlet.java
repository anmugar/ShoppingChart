package webapp;

/**
 * Created by AnaBelén on 24/01/2017.
 */
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/** * Servlet implementation class LoginServlet */

@SuppressWarnings("serial")
public class LogoutServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, java.io.IOException {
        try {
        	HttpSession session = request.getSession(true);
        	session.setAttribute("currentSessionUser",null);
            response.sendRedirect("login.html");//loggedout-in page
        }
        catch (Throwable theException) {
        System.out.println(theException);
        }
}
}