<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

        <jsp:include page="/WEB-INF/views/partials/header.jsp" />

        <h2>Product List</h2>

        <c:choose>
            <c:when test="${not empty products}">
                <ul>
                    <c:forEach items="${products}" var="product">
                        <li>
                            ${product.name} - ${product.price}  
                            <a href="${pageContext.request.contextPath}/products/edit?id=${product.id}">Edit</a>
                            
                            <!-- Formulario para enviar por POST -->
                            <form action="${pageContext.request.contextPath}/products/delete" method="POST" style="display:inline;">
                                <input type="hidden" name="id" value="${product.id}" />
                                <button type="submit" onclick="return confirm('Are you sure you want to delete this product?');">
                                    Delete
                                </button>   
                            </form>
                        </li>
                    </c:forEach>
                </ul>
            </c:when>
            <c:otherwise>
                <p>No products available</p>
            </c:otherwise>
        </c:choose>
