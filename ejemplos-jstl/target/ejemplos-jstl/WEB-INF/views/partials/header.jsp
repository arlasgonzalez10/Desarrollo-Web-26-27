<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!doctype html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title><c:out value="${pageTitle}"/></title>
</head>
<body>
    <header>
        <nav aria-label="Navegación principal">
            <c:url var="homeUrl" value="/"/>
            <c:url var="catalogUrl" value="/catalog"/>
            <a href="${homeUrl}">Inicio</a>
            <a href="${catalogUrl}">Productos</a>
        </nav>
    </header>
    <main>
