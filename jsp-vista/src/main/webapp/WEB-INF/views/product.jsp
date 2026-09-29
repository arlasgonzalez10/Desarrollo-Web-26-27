<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<!DOCTYPE html>
<html>  
<head>
    <meta charset="UTF-8">
    <title>Product Page</title> 
</head>
<body>
    <h1>Nuestro Producto</h1>
    <p>Nombre: ${productName}</p>
    <p>Precio: ${productPrice}</p>
    <p>Marca: ${productBrand}</p>
    <a href="${pageContext.request.contextPath}/index.jsp">Volver a la página principal</a>
</body>
</html>