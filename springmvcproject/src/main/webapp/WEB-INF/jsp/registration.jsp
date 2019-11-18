<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="header.jsp"/>
    <form method="POST" action="${pageContext.request.contextPath}/registration">
        <div class="container mt-5">
            <h5>Registration new user</h5>
            <c:forEach items="${errorsOfUser}" var="error">
                <p class="text-danger">
                    <c:out value="${error.defaultMessage}"/>
                </p>
            </c:forEach>
            <div class="form-group row">
                <label class="col-sm-2 col-form-label">First name:</label>
                <div class="col-sm-6">
                    <input type="text" name="firstName" class="form-control" id="firstName" placeholder="Enter first name">
                    <small class="form-text text-muted">Please enter your first name</small>
                </div>
            </div>
            <div class="form-group row">
                <label class="col-sm-2 col-form-label">Last name:</label>
                <div class="form-group col-md-6">
                    <input type="text" name="lastName" class="form-control" id="lastName" placeholder="Enter last name">
                    <small class="form-text text-muted">Please enter your last name</small>
                </div>
            </div>
            <div class="form-group row">
                <label class="col-sm-2 col-form-label">Your email:</label>
                <div class="form-group col-md-6">
                      <input type="email" name="email" class="form-control" id="email" placeholder="Enter your email">
                      <small class="form-text text-muted">Your email will be used for login</small>
                </div>
            </div>
            <div class="form-group row">
                <label class="col-sm-2 col-form-label">Password:</label>
                <div class="form-group col-md-6">
                      <input type="password" name="password" class="form-control" id="password" placeholder="Your password">
                      <small class="form-text text-muted">Please enter your last password</small>
                </div>
            </div>
            <button type="submit" class="btn btn-primary">Submit</button>
        </div>
    </form>
<jsp:include page="footer.jsp"/>