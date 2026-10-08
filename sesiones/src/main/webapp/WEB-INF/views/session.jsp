<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%> 
<!doctype html> 
<html lang="es"> 
<head> 
  <meta charset="UTF-8"> 
  <title>Datos de sesión</title> 
</head> 
<body> 
  <h1>Datos de la sesión</h1> 
  <dl> 
    <dt>Identificador</dt> 
    <dd>${sessionId}</dd> 
    <dt>¿Es nueva?</dt> 
    <dd>${newSession}</dd> 
    <dt>Creada en</dt> 
    <dd>${createdAt}</dd> 
    <dt>Visitas durante esta sesión</dt> 
    <dd>${visits}</dd> 
    <dt>Inactividad máxima</dt> 
    <dd>${maxInactiveInterval} segundos</dd> 
  </dl> 
  <p><a href="${pageContext.request.contextPath}/session">Recargar</a></p> 
  <form action="${pageContext.request.contextPath}/session" method="post"> 
    <button type="submit">Invalidar la sesión</button> 
  </form> 
</body> 
</html> 