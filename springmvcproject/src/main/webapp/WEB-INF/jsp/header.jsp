<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
        <script type="text/javascript">
            google.charts.load('current', {'packages':['corechart']});
            google.charts.setOnLoadCallback(drawChart);

            function drawChart() {
                var data = google.visualization.arrayToDataTable([
                    ['Date',  'Value'],
                    <c:forEach items="${cieDataList}" var="entry">
                        [ '${entry.sensorDate}', ${entry.value} ],
                    </c:forEach>
                ]);

                var options = {
                    title: 'Temperature sensor',
                    vAxis: {title: 'Temperature scale °C', titleTextStyle: {color: '#333'}},
                    hAxis: {title: 'Date',  titleTextStyle: {color: '#333'}},
                    isStacked: true
                };

                var chart1 = new google.visualization.SteppedAreaChart(document.getElementById('chart_div_temp'));

                chart1.draw(data, options);
            }
        </script>
        <script type="text/javascript">
          google.charts.load('current', {'packages':['corechart']});
          google.charts.setOnLoadCallback(drawChart);

          function drawChart() {
            var data = google.visualization.arrayToDataTable([
              ['Date',  'Value'],
              <c:forEach items="${cieDataList}" var="entry">
                  [ '${entry.sensorDate}', ${entry.value} ],
              </c:forEach>
            ]);

            var options = {
              title: 'Accelerometer sensor',
              vAxis: {title: 'Accelerometer scale km', titleTextStyle: {color: '#333'}},
              hAxis: {title: 'Date',  titleTextStyle: {color: '#333'}},
            };

            var chart2 = new google.visualization.AreaChart(document.getElementById('chart_div_accel'));
            chart2.draw(data, options);
          }
        </script>
    </head>
<body>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item">
                    <a class="nav-link active" href="${pageContext.request.contextPath}/home">Home</a>
                </li>
                <sec:authorize access="isAuthenticated()">
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/device-list">Device List</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/add-device">Add Device</a>
                    </li>
                </sec:authorize>
                <sec:authorize access="hasRole('ADMIN')">
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/user">User List</a>
                    </li>
                </sec:authorize>
                <sec:authorize access="!isAuthenticated()">
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/registration">Registration</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/login">Login</a>
                    </li>
                </sec:authorize>
            </ul>
            <ul class="navbar-nav">
                <sec:authorize access="isAuthenticated()">
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/logout">Logout</a>
                </li>
                </sec:authorize>
            </ul>
        </div>
    </nav>