<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <c:set var="contextPath" value="${pageContext.request.contextPath}"/>
    <%@include file="../../resources/cssResources.jsp" %>
    <title>Users</title>
</head>
<body>

<div class="container-fluid">
    <div class="row my-2">
        <div class="col">
            <table class="table text-center">
                <thead class="thead-dark">
                <tr>
                    <th scope="col">E-mail</th>
                    <th scope="col">Role</th>
                    <th scope="col">First Name</th>
                    <th scope="col">Last Name</th>
                    <th scope="col">Phone</th>
                    <th scope="col">ID Number</th>
                    <th scope="col">Country</th>
                    <th scope="col">City</th>
                    <th scope="col">Zip Code</th>
                    <th scope="col">Street Name</th>
                    <th scope="col">Street Number</th>
                    <th scope="col">Flat Number</th>
                    <th scope="col">Building Number</th>
                    <th scope="col">Actions</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${users}" var="user">
                    <tr>
                        <td><c:out value="${user.email}"/></td>
                        <td><c:out value="${user.role}"/></td>
                        <td><c:out value="${user.firstName}"/></td>
                        <td><c:out value="${user.lastName}"/></td>
                        <td><c:out value="${user.phoneNumber}"/></td>
                        <td><c:out value="${user.IDNumber}"/></td>
                        <td><c:out value="${user.country}"/></td>
                        <td><c:out value="${user.city}"/></td>
                        <td><c:out value="${user.zipCode}"/></td>
                        <td><c:out value="${user.streetName}"/></td>
                        <td><c:out value="${user.streetNumber}"/></td>
                        <td><c:out value="${user.flatNumber}"/></td>
                        <td><c:out value="${user.buildingNumber}"/></td>
                        <td>
                            <div class="btn-group m-0 p-0" role="group">
                                <button class="btn btn-primary"
                                        onClick="location.href = '${pageContext.request.contextPath}/users/update/${user.email}'">
                                    Update
                                </button>
                                <button class="btn btn-primary"
                                        onClick="location.href = '${pageContext.request.contextPath}/users/delete/${user.email}'">
                                    Delete
                                </button>
                            </div>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
<div class="btn-group ml-3" role="group">
    <button class="btn btn-primary"
            onclick="location.href = '${pageContext.request.contextPath}/users/insert-admin'">
        Add an
        admin account
    </button>
    <button class="btn btn-primary" onclick="location.href = '${pageContext.request.contextPath}'">Back</button>
</div>
</body>


<%@include file="../../resources/javascriptResources.jsp" %>
</html>
