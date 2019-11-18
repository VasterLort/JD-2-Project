<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="header.jsp"/>
    <div class="container mt-5">
        <div class="alert alert-danger col-md-3" role="alert">
            Registration error!
        </div>
        <a class="btn btn-primary" href="${pageContext.request.contextPath}/registration" role="button">Back</a>
    </div>
<jsp:include page="footer.jsp"/>