<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
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
    <h1 class="text-center">Создайте аккаунт</h1>
    <div class="form-container">
    <form method="post" action="registration" class="mt-4">
        <div class="mb-3">
            <label for="username" class="form-label">Логин</label>
            <input type="text" name="username" id="username" class="form-control" required>
        </div>
        <div class="mb-3">
            <label for="email" class="form-label">Email</label>
            <input type="email" name="email" id="email" class="form-control" required>
        </div>
        <div class="mb-3">
            <label for="password" class="form-label">Пароль</label>
            <input type="password" name="password" id="password" class="form-control" required>
        </div>
        <div class="mb-3">
            <label for="confirmPassword" class="form-label">Подтвердите пароль</label>
            <input type="password" name="confirmPassword" id="confirmPassword" class="form-control" required>
        </div>
        <% if (request.getAttribute("errorMessage") != null) { %>
        <div class="alert alert-danger"><%= request.getAttribute("errorMessage") %></div>
        <% } %>
        <button type="submit" class="btn btn-primary">Зарегестрироваться</button>
    </form>
    </div>
</div>
</body>
</html>
