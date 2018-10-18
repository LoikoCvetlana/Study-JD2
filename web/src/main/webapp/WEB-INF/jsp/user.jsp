<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    <h1>${requestScope.user.name} ${requestScope.user.lastname}</h1> <br>
    <i> ${requestScope.user.role}<br></i>
    Дата регистрации: ${requestScope.user.registrationDate}<br>
    Организация: ${requestScope.user.organization}<br>
    E-mail: ${requestScope.user.email}<br>
    О себе: ${requestScope.user.otherInformation}
</div>
</body>
</html>
