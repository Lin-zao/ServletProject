import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

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
            response.setContentType("text/html;charset=utf-8");
            PrintWriter out = response.getWriter();
            out.println("<h2>登录失败，2秒后返回登录页面</h2>");
            response.setHeader("refresh", "2;url=login.html");
        }
    }
}
