<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meeta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Resultado de la Busqueda</title>
    </head>

    <body>
        <h2>Resultado de la Busqueda</h2>
        <!--<p>Texto: ${query}</p>
        <p>Categoria: ${category}</p>-->
        <p>Texto: ${empty query ? 'No se proporcionó texto de búsqueda' : query}</p>
        <p>Categoria: ${empty category ? 'No se proporcionó categoría' : category}</p>
    </body>
</html>