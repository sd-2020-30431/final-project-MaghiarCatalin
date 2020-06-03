<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>
<%@include file="../../resources/cssResources.jsp" %>
<html>
<head>
    <title>Delete a user</title>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-8 offset-md-2 col-12">
            <form:form method="POST" action="${pageContext.request.contextPath}/users/delete-my-account" modelAttribute="email">
                <div class="form-group m-2 text-center">
                    <h3>Are you sure you want to remove your account ${email}</h3>
                </div>
                <div class="form-group text-center">
                    <input class="btn btn-danger" type="submit" value="DELETE"/>
                </div>
            </form:form>
        </div>
    </div>
</div>
<div class="fixed-top m-2">
    <button  class="btn btn-light" onclick="location.href = '${pageContext.request.contextPath}'">Back</button>
</div>
</body>
<%@include file="../../resources/javascriptResources.jsp" %>
</html>