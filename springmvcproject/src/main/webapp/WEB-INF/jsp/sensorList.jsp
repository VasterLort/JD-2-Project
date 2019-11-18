<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="header.jsp"/>
    <div class="container mt-5">
        <h5>Sensors List:</h5>
        <table class="table table-bordered">
            <thead>
                <tr>
                    <th scope="col">#</th>
                    <th>Name</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="sensor" items="${sensorList}">
                    <tr>
                        <td>${sensor.sensorId}</td>
                        <td><a href="${pageContext.request.contextPath}/device-list/deviceImei/${deviceImei}/sensor/${sensor.sensorName}" class="badge badge-light">${sensor.sensorName}</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
<jsp:include page="footer.jsp"/>