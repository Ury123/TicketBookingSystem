package com.innowise.ticketbookingsystem.controller;

import com.innowise.ticketbookingsystem.model.User;
import com.innowise.ticketbookingsystem.repository.impl.UserRepositoryImpl;
import com.innowise.ticketbookingsystem.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.Optional;

@WebServlet("/login")
public class LoginController extends HttpServlet {

    private final UserService userService;

    public LoginController() {
        this.userService = new UserService(new UserRepositoryImpl());
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if (userService.validateUser(username, password)) {
            User user = userService.getUserByUsername(username);
            req.getSession().setAttribute("currentUser", user);
            resp.sendRedirect("sessions");
        } else {
            req.setAttribute("errorMessage", "Неверный логин или пароль.");
            req.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(req, resp);
        }
    }

}
