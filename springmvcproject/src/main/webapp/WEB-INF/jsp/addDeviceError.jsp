<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="header.jsp"/>
    <div class="container mt-5">
        <div class="alert alert-danger col-md-3" role="alert">
            Add device error!
        </div>
        <a class="btn btn-primary" href="${pageContext.request.contextPath}/add-device" role="button">Back</a>
    </div>
<jsp:include page="footer.jsp"/>