<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <Title>Title</Title>
</head>
<body>
<form:form method="POST" action="${pageContext.request.contextPath}/habits/add-habit" modelAttribute="habitDto">
    <form:label path="name">Name</form:label>
    <form:input path="name" />

    <input type="submit" value="Submit" />
</form:form>

<c:if test="${param.Success != null}">
    <c:out value="${param.Success}"/>
</c:if>

<c:if test="${param.Error != null}">
    <c:out value="${param.Error}"/>
</c:if>
</body>
</html>
