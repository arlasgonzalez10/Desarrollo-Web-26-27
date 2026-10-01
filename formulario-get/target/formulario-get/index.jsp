<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<html>
    <body>

    <h2>Hello World!</h2>

    <form action="search" method="get">
        <label>
            Texto de búsqueda:
            <input type="search" name="query">
        </label> 
        <label>
            Categoría:
            <select name="category">
                <option value="all">Todas</option>
                <option value="books">Libros</option>
                <option value="electronics">Electrónica</option>
                <option value="videojuegos">Videojuegos</option>
                <option value="perifericos">perifericos</option>
            </select>
        </label>
        <button type="submit">Buscar</button>
    </form>

    </body>
</html>
