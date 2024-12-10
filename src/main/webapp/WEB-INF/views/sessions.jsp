<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.innowise.ticketbookingsystem.model.Session" %>
<%@ page import="java.time.LocalDate" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.ArrayList" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sessions</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
    <h1 class="text-center mb-4">Доступные сеансы</h1>

    <form action="sessions" method="get" class="row g-3 align-items-center mb-4 justify-content-center">
        <!-- Поле для ввода названия фильма -->
        <div class="col-auto">
            <input type="text" name="movieTitle" class="form-control" placeholder="Название фильма"
                   style="width: 200px;"
                   value="<%= request.getParameter("movieTitle") != null ? request.getParameter("movieTitle") : "" %>">
        </div>

        <!-- Поле для выбора даты -->
        <div class="col-auto">
            <input type="date" name="filterDate" class="form-control"
                   value="<%= request.getParameter("filterDate") != null ? request.getParameter("filterDate") : "" %>">
        </div>

        <!-- Кнопка для отправки формы -->
        <div class="col-auto">
            <button type="submit" class="btn btn-primary">Поиск</button>
        </div>
    </form>

    <%
        Map<LocalDate, List<Session>> sessionsByDate = (Map<LocalDate, List<Session>>) request.getAttribute("sessionsByDate");
        if (sessionsByDate != null) {

            // Сортируем даты по возрастанию
            List<LocalDate> sortedDates = new ArrayList<>(sessionsByDate.keySet());
            sortedDates.sort(LocalDate::compareTo);

            // Выводим сеансы, сгруппированные по датам
            for (LocalDate date : sortedDates) {
    %>
    <div class="mb-4">
        <h2 class="text-center mb-3"><%= date %></h2>
        <ul class="list-group">
            <%
                List<Session> sessionsForDate = sessionsByDate.get(date);

                sessionsForDate.sort((s1, s2) -> s1.getStartDateTime().toLocalTime().compareTo(s2.getStartDateTime().toLocalTime()));

                for (Session movieSession : sessionsForDate) {
            %>
            <li class="list-group-item d-flex justify-content-between align-items-center">
                <div>
                    <h5><%= movieSession.getMovie().getTitle() %></h5>
                    <p>
                        <strong>Время:</strong> <%= movieSession.getStartDateTime().toLocalTime() %>
                    </p>
                </div>
                <a href="bookTicket?id=<%= movieSession.getId() %>" class="btn btn-primary">Забронировать билет</a>
            </li>
            <%
                }
            %>
        </ul>
    </div>
    <%
        }
    } else {
    %>
    <p class="text-center">No sessions available.</p>
    <%
        }
    %>

</div>
</body>
</html>

