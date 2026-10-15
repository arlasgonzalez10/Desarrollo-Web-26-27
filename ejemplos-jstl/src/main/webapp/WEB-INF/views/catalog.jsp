<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!doctype html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Catálogo</title>
</head>
<body>
    <h1>Catálogo de productos</h1>

    <c:choose>
        <c:when test="${empty products}">
            <p>No hay productos disponibles.</p>
        </c:when>
        <c:otherwise>
            <table>
                <thead>
                    <tr>
                        <th>#</th>
                        <th>Nombre</th>
                        <th>Precio</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${products}" var="product" varStatus="status">
                        <tr>
                            <td>${status.count}</td>
                            <td><c:out value="${product.name}"/></td>
                            <td><c:out value="${product.price}"/> €</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </c:otherwise>
    </c:choose>
</body>
</html>
