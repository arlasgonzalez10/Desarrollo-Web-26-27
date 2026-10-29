<%@ page isELIgnored="false" %>
    <%@ taglib prefix="c" uri="jakarta.tags.core" %>

        <jsp:include page="/WEB-INF/views/partials/header.jsp" />

        <h2>Edit Product</h2>

        <form action="${pageContext.request.contextPath}/products/update" method="post">


            <input type="text" id="id" name="id" value="${product.id}" hidden><br><br>

            <label for="name">Name </label>
            <input type="text" id="name" name="name" value="${product.name}" required><br><br>

            <label for="description">Description </label>
            <textarea type="text" id="description" name="description" required>${product.description}</textarea><br><br>

            <label for="price">Price </label>
            <input type="number" id="price" name="price" value="${product.price}" required><br><br>


            <input type="submit" value="Edit product">

        </form>