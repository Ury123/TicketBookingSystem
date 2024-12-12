<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        .form-container {
            max-width: 400px;
            margin: 0 auto;
        }
    </style>
</head>
<body>
<div class="container mt-5">
    <h1 class="text-center">Вход в аккаунт</h1>
    <div class="form-container">
    <form method="post" action="login" class="mt-4">
        <div class="mb-3">
            <label for="username" class="form-label">Логин</label>
            <input type="text" name="username" id="username" class="form-control" required>
        </div>
        <div class="mb-3">
            <label for="password" class="form-label">Пароль</label>
            <input type="password" name="password" id="password" class="form-control" required>
        </div>
        <% if (request.getAttribute("errorMessage") != null) { %>
        <div class="alert alert-danger"><%= request.getAttribute("errorMessage") %></div>
        <% } %>
        <button type="submit" class="btn btn-primary">Войти</button>
    </form>
        <div class="mt-3 text-center">
            <a href="registration" class="text-decoration-none">Нет аккаунта? Зарегистрируйтесь</a>
        </div>
    </div>
</div>
</body>
</html>
