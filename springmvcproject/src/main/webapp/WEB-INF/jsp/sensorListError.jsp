<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="header.jsp"/>
    <div class="container mt-5">
        <div class="alert alert-danger col-md-3" role="alert">
            Sensor list is empty!
        </div>
        <a class="btn btn-primary" href="${pageContext.request.contextPath}/device-list" role="button">Back</a>
    </div>
<jsp:include page="footer.jsp"/>