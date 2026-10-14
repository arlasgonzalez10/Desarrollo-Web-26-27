<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false" %> 
<%@ taglib prefix="c" uri="jakarta.tags.core" %> 
<!doctype html> 
<html lang="es"> 
<head> 
  <meta charset="UTF-8"> 
  <title>Estado del producto</title> 
</head> 
<body> 
  <h1>Estado del producto</h1>
  <c:out value="${productName}"/>
  
  <c:if test="${stock > 0}"> 
    <p>Disponible: ${stock} unidades.</p> 
  </c:if> 
</body> 
</html> 