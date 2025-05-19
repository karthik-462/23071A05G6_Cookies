package com.studentapp;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;

public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String inputUsername = req.getParameter("username");
        String inputPassword = req.getParameter("password");

        HttpSession session = req.getSession(false);
        String storedUsername = (String) session.getAttribute("username");
        String storedPassword = (String) session.getAttribute("password");

        if (storedUsername != null && storedPassword != null &&
            storedUsername.equals(inputUsername) && storedPassword.equals(inputPassword)) {
            res.sendRedirect("addcookies");
        } else {
            res.setContentType("text/html");
            res.getWriter().println("<p style='color:red;'>Invalid credentials. <a href='login.html'>Try again</a></p>");
        }
    }
}
