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

public class LoginServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, java.io.IOException {
        try {
            UserBean user = new UserBean();
            user.setUserName(request.getParameter("username"));
            user.setPassword(request.getParameter("password"));
            user = UserDatabase.login(user);
            if (user.isValid()) {
                HttpSession session = request.getSession(true);
                session.setAttribute("currentSessionUser",user);
                response.sendRedirect("CorrectLogin.jsp");//logged-in page
            }
            else response.sendRedirect("ErrorLogin.jsp"); //error page
        } catch (Throwable theException) {
            System.out.println(theException);
            }
    }
}