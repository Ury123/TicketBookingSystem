package com.innowise.ticketbookingsystem.controller;

import com.innowise.ticketbookingsystem.model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/bookTicket")
public class BookTicketController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        User currentUser = (session != null) ? (User) session.getAttribute("currentUser") : null;

        if (currentUser == null) {
            resp.sendRedirect("login");
        } else {
            String sessionId = req.getParameter("id");
            req.setAttribute("sessionId", sessionId);
            req.getRequestDispatcher("/WEB-INF/views/booking.jsp").forward(req, resp);
        }
    }
}
