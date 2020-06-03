<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="../resources/javascriptResources.jsp" %>
<html>
<head>
    <title>Create Customer Account</title>
</head>
<div class="container">
    <div class="row">
        <div class="col-md-8 offset-md-2 col-12">
            <form:form method="POST"
                       action="${pageContext.request.contextPath}/users" modelAttribute="user">
                <div class="form-group m-0">
                    <label><form:label path="email">Email</form:label></label>
                    <form:input path="email" cssClass="form-control"/>
                    <label class="invalid-feedback d-block">${email_error}</label>
                </div>
                <div class="form-group m-0">
                    <label><form:label path="password">Password</form:label></label>
                    <form:input path="password" type="password" cssClass="form-control"/>
                    <label class="invalid-feedback d-block">${password_error}</label>
                </div>
                <div class="form-group m-0">
                    <label><form:label path="firstName">First Name</form:label></label>
                    <form:input path="firstName" cssClass="form-control"/>
                    <label class="invalid-feedback d-block">${firstName_error}</label>
                </div>
                <div class="form-group m-0">
                    <label><form:label path="lastName">Last Name</form:label></label>
                    <form:input path="lastName" cssClass="form-control"/>
                    <label class="invalid-feedback d-block">${lastName_error}</label>
                    <div class="form-group m-0">
                        <label><form:label path="IDNumber">ID Number</form:label></label>
                        <form:input path="IDNumber" cssClass="form-control"/>
                        <label class="invalid-feedback d-block">${idNumber_error}</label>
                    </div>
                    <div class="form-group m-0">
                        <label><form:label path="phoneNumber">Phone Number</form:label></label>
                        <form:input path="phoneNumber" cssClass="form-control"/>
                        <label class="invalid-feedback d-block">${phoneNumber_error}</label>
                    </div>
                    <div class="form-group m-0">
                        <label><form:label path="country">Country</form:label></label>
                        <form:input path="country" cssClass="form-control"/>
                        <label class="invalid-feedback d-block">${country_error}</label>
                    </div>
                    <div class="form-group m-0">
                        <label><form:label path="city">City</form:label></label>
                        <form:input path="city" cssClass="form-control"/>
                        <label class="invalid-feedback d-block">${city_error}</label>
                    </div>
                    <div class="form-group m-0">
                        <label><form:label path="zipCode">Zip Code</form:label></label>
                        <form:input path="zipCode" cssClass="form-control"/>
                        <label class="invalid-feedback d-block">${zipCode_error}</label>
                    </div>
                    <div class="form-group m-0">
                        <label><form:label path="streetName">Street Name</form:label></label>
                        <form:input path="streetName" cssClass="form-control"/>
                        <label class="invalid-feedback d-block">${streetName_error}</label>
                    </div>
                    <div class="form-group m-0">
                        <label><form:label path="streetNumber">Street Number</form:label></label>
                        <form:input path="streetNumber" cssClass="form-control"/>
                        <label class="invalid-feedback d-block">${streetNumber_error}</label>
                    </div>
                    <div class="form-group m-0">
                        <label><form:label path="flatNumber">Flat Number</form:label></label>
                        <form:input path="flatNumber" cssClass="form-control"/>
                        <label class="invalid-feedback d-block">${flatNumber_error}</label>
                    </div>
                    <div class="form-group m-0">
                        <label><form:label path="buildingNumber">Building Number</form:label></label>
                        <form:input path="buildingNumber" cssClass="form-control"/>
                        <label class="invalid-feedback d-block">${buildingNumber_error}</label>
                    </div>
                    <div class="row">
                        <div class="col-md">
                            <input class="btn btn-primary btn-block" type="submit" value="Submit"/>
                        </div>
                        <div class="col-md text-center">
                            <label class="text-success">${status}</label>
                        </div>
                    </div>
                </div>
            </form:form>
        </div>
    </div>
</div>
<div class="fixed-top m-2">
    <button class="btn btn-light" onclick="location.href = '${pageContext.request.contextPath}/'">Back to
        HomePage
    </button>
</div>
</body>
<%@include file="../resources/cssResources.jsp" %>
</html>