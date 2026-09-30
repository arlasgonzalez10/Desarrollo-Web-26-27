<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<!DOCTYPE html>
<html lang ="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Saludo</title>
</head>
<body>
    <h1>Hola, ${name}!</h1>
    <!-- <p> query String recibida: ${queryString}</p> -->
    <p> query String recibida: ${queryString? "No se recibió nada": queryString}</p>
    <a href="${pageContext.request.contextPath}/">Volver</a>
</body>
</html>