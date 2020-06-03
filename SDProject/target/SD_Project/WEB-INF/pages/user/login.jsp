<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Login</title>
    <%@include file="../../resources/cssResources.jsp" %>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-6 offset-md-3">
            <c:if test='${param.error != null && !param.error.equals("")}'>
                <div class="alert alert-danger alert-dismissible">
                    <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                    <c:out value="${param.error}"/>
                </div>
            </c:if>

            <form method="post" action="${pageContext.request.contextPath}/login" class="needs-validation">
                <div class="form-group">
                    <label class="p-1">E-mail:</label>
                    <input type="email" name="email" class="form-control js-needs-validation"/>
                    <div class="invalid-feedback p-0">
                        Please provide an E-mail
                    </div>
                </div>

                <div class="form-group">
                    <label class="p-1">Password:</label>
                    <input type="password" name="password" class="form-control js-needs-validation"/>
                    <div class="invalid-feedback p-0">
                        Please provide a Password
                    </div>
                </div>

                <input type="submit" value="Login" class="btn btn-primary">
            </form>

        </div>
    </div>
</div>
<%@include file="../../resources/javascriptResources.jsp" %>
</body>
</html>
