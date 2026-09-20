import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String userpwd = request.getParameter("userpwd");
        System.out.println(username+":"+userpwd);
        if ("林子豪".equals(username) && "24104010705".equals(userpwd)){
            request.setAttribute("account",username);
            request.getRequestDispatcher("welcome.jsp").forward(request,response);

        }else {
            response.sendRedirect("login.html");
        }
    }
}
