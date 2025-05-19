package com.studentapp;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;

public class AddCookies extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html");

        Cookie usernameCookie = new Cookie("username", "Karthik");
        Cookie roleCookie = new Cookie("role", "student");
        Cookie languageCookie = new Cookie("language", "java");
        Cookie helloCookie = new Cookie("hello","hi");
        
        int oneDay = 24 * 60 * 60;
        usernameCookie.setMaxAge(oneDay);
        roleCookie.setMaxAge(oneDay);
        languageCookie.setMaxAge(oneDay);
        helloCookie.setMaxAge(oneDay);
        
        res.addCookie(usernameCookie);
        res.addCookie(roleCookie);
        res.addCookie(languageCookie);
        res.addCookie(helloCookie);
        
        PrintWriter out = res.getWriter();
        out.println("<html><body>");
        out.println("<h3>4 cookies have been added to your browser!</h3>");

        out.println("<table border='1' cellpadding='5'>");
        out.println("<tr><th>Cookie Name</th><th>Cookie Value</th></tr>");
        out.println("<tr><td>username</td><td>Karthik</td></tr>");
        out.println("<tr><td>role</td><td>student</td></tr>");
        out.println("<tr><td>language</td><td>java</td></tr>");
        out.println("<tr><td>hello</td><td>hi</td></tr>");
        out.println("</table>");

        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        doGet(req, res);
    }
}
