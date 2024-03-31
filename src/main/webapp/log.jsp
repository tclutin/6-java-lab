<%--
  Created by IntelliJ IDEA.
  User: Lutin
  Date: 23.03.2024
  Time: 19:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="ru">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <title>Reg</title>
</head>
<body>
<div class="container mt-3">
    <form method="POST">
        <div class="mb-3">
            <label for="exampleInputLogin" class="form-label">Login</label>
            <input type="text" name="login" class="form-control" id="exampleInputLogin" aria-describedby="LoginHelp">
        </div>
        <div class="mb-3">
            <label for="exampleInputPassword1" class="form-label">Password</label>
            <input type="password" name="pass" class="form-control" id="exampleInputPassword1">
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
    <p><a href="reg">Registration</a></p>
</div>
</body>
</html>