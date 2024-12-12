package com.innowise.ticketbookingsystem.controller;

import com.innowise.ticketbookingsystem.model.User;
import com.innowise.ticketbookingsystem.model.UserRole;
import com.innowise.ticketbookingsystem.repository.impl.UserRepositoryImpl;
import com.innowise.ticketbookingsystem.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/registration")
public class RegistrationController extends HttpServlet {
    private final UserService userService;

    public RegistrationController() {
        this.userService = new UserService(new UserRepositoryImpl());
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/registration.jsp").forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String confirmPassword = req.getParameter("confirmPassword");
        String email = req.getParameter("email");

        if (password.length() < 8) {
            req.setAttribute("errorMessage", "Пароль должен быть не меньше 8 символов.");
            req.getRequestDispatcher("/WEB-INF/views/registration.jsp").forward(req, resp);
            return;
        }

        if (!password.equals(confirmPassword)) {
            req.setAttribute("errorMessage", "Пароли не совпадают.");
            req.getRequestDispatcher("/WEB-INF/views/registration.jsp").forward(req, resp);
            return;
        }

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setUserRole(UserRole.User);

        if (userService.registerUser(user)) {
            resp.sendRedirect("login");
        } else {
            req.setAttribute("errorMessage", "Логин или почта уже существуют.");
            req.getRequestDispatcher("/WEB-INF/views/registration.jsp").forward(req, resp);
        }
    }
}
