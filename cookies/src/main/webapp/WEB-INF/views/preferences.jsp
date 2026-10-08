<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %> 
<!doctype html> 
<html lang="es"> 
<head> 
  <meta charset="UTF-8"> 
  <title>Preferencias</title> 
  <style> 
    body { font-family: sans-serif; margin: 2rem; } 
    body.dark { color: #f5f5f5; background: #222; } 
  </style> 
</head> 
<body class="${theme}"> 
  <h1>Preferencias mediante cookies</h1> 
  <p>Tema actual: ${theme}</p> 
  <p>Visitas registradas por la cookie: ${visits}</p> 
  <form action="${pageContext.request.contextPath}/preferences" method="post"> 
    <label> 
      Tema: 
      <select name="theme"> 
        <option value="light">Claro</option> 
        <option value="dark">Oscuro</option> 
      </select> 
    </label> 
    <button type="submit">Guardar preferencia</button> 
  </form> 
</body> 
</html> 