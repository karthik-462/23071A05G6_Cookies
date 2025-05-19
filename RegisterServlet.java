package com.studentapp;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;

public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        // Save user data in session (or ideally in DB)
        HttpSession session = req.getSession();
        session.setAttribute("username", username);
        session.setAttribute("password", password);

        // Redirect to login page
        res.sendRedirect("Login.html");
    }
}
