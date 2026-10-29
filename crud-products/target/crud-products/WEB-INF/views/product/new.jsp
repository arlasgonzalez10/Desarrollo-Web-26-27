<%@ page isELIgnored="false" %>
    <%@ taglib prefix="c" uri="jakarta.tags.core" %>

        <jsp:include page="/WEB-INF/views/partials/header.jsp" />

        <h2>New Product</h2>

        <form action="${pageContext.request.contextPath}/products/create" method="post">

            <label for="name">Name </label>
            <input type="text" id="name" name="name" required><br><br>

            <label for="description">Description </label>
            <textarea type="text" id="description" name="description" required></textarea><br><br>

            <label for="price">Price </label>
            <input type="number" id="price" name="price" required><br><br>


            <input type="submit" value="Create product">

        </form>