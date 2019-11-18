<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="header.jsp"/>
    <form method="POST" action="${pageContext.request.contextPath}/add-device" enctype="multipart/form-data">
        <div class="container mt-5">
            <h5>Add new device</h5>
            <c:forEach items="${errorsOfDevice}" var="error">
                <p class="text-danger">
                    <c:out value="${error.defaultMessage}"/>
                </p>
            </c:forEach>
            <div class="form-group row">
                <label class="col-sm-2 col-form-label">Device name:</label>
                <div class="col-sm-6">
                    <input type="text" name="deviceName" class="form-control" id="exampleDeviceName1" placeholder="Device name">
                    <small class="form-text text-muted">Please enter name of device</small>
                </div>
            </div>
            <div class="form-group row">
                <label class="col-sm-2 col-form-label">Device imei:</label>
                <div class="col-sm-6">
                    <input type="number" name="imei" class="form-control" id="exampleInputPassword1" placeholder="Device imei">
                    <small class="form-text text-muted">Please enter imei of device</small>
                </div>
            </div>
            <div class="form-group row">
                <label class="col-sm-2 col-form-label">Device Country:</label>
                <div class="form-group col-md-6">
                    <input type="text" name="country" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter device country">
                    <small class="form-text text-muted">Please enter country of device</small>
                </div>
            </div>
            <button type="submit" class="btn btn-primary">Submit</button>
        </div>
    </form>
<jsp:include page="footer.jsp"/>