package com.innowise.ticketbookingsystem.controller;

import com.innowise.ticketbookingsystem.model.Session;
import com.innowise.ticketbookingsystem.repository.impl.SessionRepositoryImpl;
import com.innowise.ticketbookingsystem.service.SessionService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.time.LocalDate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/sessions")
public class SessionController extends HttpServlet {
    private final SessionService sessionService;

    public SessionController() {
        this.sessionService = new SessionService(new SessionRepositoryImpl());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String movieTitle = req.getParameter("movieTitle");
        String filterDateParam = req.getParameter("filterDate");

        List<Session> allSessions = sessionService.getUpcomingSessions();
        List<Session> filteredSessions;

        if ((movieTitle != null && !movieTitle.trim().isEmpty()) || (filterDateParam != null && !filterDateParam.trim().isEmpty())) {
            filteredSessions = new ArrayList<>();
            LocalDate filterDate = null;

            if (filterDateParam != null && !filterDateParam.isEmpty()) {
                filterDate = LocalDate.parse(filterDateParam);
            }

            for (Session session : allSessions) {
                boolean matchesTitle = movieTitle == null || movieTitle.trim().isEmpty() ||
                        session.getMovie().getTitle().toLowerCase().contains(movieTitle.toLowerCase());
                boolean matchesDate = filterDate == null ||
                        session.getStartDateTime().toLocalDate().equals(filterDate);

                if (matchesTitle && matchesDate) {
                    filteredSessions.add(session);
                }
            }
        } else {
            filteredSessions = allSessions;
        }

        // Группируем сессии по датам
        Map<LocalDate, List<Session>> sessionsByDate = new HashMap<>();
        for (Session movieSession : filteredSessions) {
            LocalDate sessionDate = movieSession.getStartDateTime().toLocalDate();
            sessionsByDate.computeIfAbsent(sessionDate, k -> new ArrayList<>()).add(movieSession);
        }

        req.setAttribute("sessionsByDate", sessionsByDate);

        req.getRequestDispatcher("/WEB-INF/views/sessions.jsp").forward(req, resp);
    }
}
