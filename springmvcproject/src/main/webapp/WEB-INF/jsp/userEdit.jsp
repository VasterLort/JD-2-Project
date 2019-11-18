<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="header.jsp"/>
    <div class="container mt-5">
        <h5>User editor:</h5>
        <form action="/user" method="post">
            <input type="text" name="username" value="${user.email}">
            <c:forEach var="role" items="${roles}">
                <div>
                    <label><input type="checkbox" name="${role}">${role}</label>
                </div>
            </c:forEach>
            <button type="submit">Save</button>
        </form>
    </div>
<jsp:include page="footer.jsp"/>