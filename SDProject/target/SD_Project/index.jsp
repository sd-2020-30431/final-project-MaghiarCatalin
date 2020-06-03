<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <title>Lift above yourself (break bad habits)</title>
    <%@include file="WEB-INF/resources/cssResources.jsp" %>
</head>
<body>
<h1 class="display-4">Lift above yourself  </h1>
<hr class="my-4">
<div class="lead">
    <c:if test="${sessionScope.get(\"SPRING_SECURITY_CONTEXT\") == null}">
        <a class="btn btn-primary" href="${pageContext.request.contextPath}/users/login">Login </a>
        <a class="btn btn-primary" href="${pageContext.request.contextPath}/users/sign-up">Sign Up </a>
    </c:if>
    <c:if test="${sessionScope.get(\"SPRING_SECURITY_CONTEXT\") != null}">
        <sec:authorize access="hasAuthority('ADMIN')">
            <a class="btn btn-primary" href="${pageContext.request.contextPath}/users">Users </a>
            <a class="btn btn-primary" href="${pageContext.request.contextPath}/habits">Get Habits</a>
        </sec:authorize>
        <a class="btn btn-primary" href="${pageContext.request.contextPath}/users/update-account">My Account </a>
        <a class="btn btn-primary" href="${pageContext.request.contextPath}/logout">Logout </a>
    </c:if>
    <p>
        <c:if test="${param.message != null && !param.message.equals(\"\")}">
            <c:out value="${param.message}"/>
        </c:if>
    </p>
</div>
<%@include file="WEB-INF/resources/javascriptResources.jsp" %>
</body>
</html>
