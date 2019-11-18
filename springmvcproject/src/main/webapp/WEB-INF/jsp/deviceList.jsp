<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="header.jsp"/>
    <div class="container mt-5">
        <h5>Device List:</h5>
        <table class="table table-bordered">
            <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">Name</th>
                    <th scope="col">Country</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="device" items="${catalog}">
                    <tr>
                        <th scope="row">${device.id}</th>
                        <td><a href="${pageContext.request.contextPath}/device-list/device/${device.imei}" class="badge badge-light">${device.deviceName}</a></td>
                        <td>${device.country}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
<jsp:include page="footer.jsp"/>