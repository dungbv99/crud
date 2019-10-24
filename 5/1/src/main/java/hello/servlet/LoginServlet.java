package hello.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String name = request.getParameter("u");
        String password = request.getParameter("p");
        request.getRequestDispatcher("link.html").include(request, response);
        System.out.println("1111" + password);
        if (password.equals("admin123")) {
            out.print("<font color=blue>You are successfully loggedin!</font>");
            out.print("<br>Welcome, " + name);
            Cookie ck = new Cookie("name", name);
            response.addCookie(ck);
        } else {
            out.print("<font color=red>sorry, username or password error!");
            request.getRequestDispatcher("login.html").include(request,response);
        }
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
