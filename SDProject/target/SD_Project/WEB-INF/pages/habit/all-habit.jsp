<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <%@include file="../../resources/cssResources.jsp" %>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>Habits List</title>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-8 offset-md-2 col-12">
            <div class="row my-3">
                <div class="col-sm my-auto">
                    <h1>Habits</h1>
                </div>
                <div class="col-sm my-auto"></div>
                <div class="col-sm my-auto">
                    <button type="button" class="col-sm btn btn-primary btn-lg" data-toggle="modal" data-target="#add-modal">Add Habit</button>
                </div>
            </div>
            <table class="table text-center">
                <thead>
                <tr>
                    <td class="text-center"><b>Habit Name</b></td>
                    <td class="text-center"><b>Actions</b></td>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${habits}" var="habit">
                    <tr>
                        <td class="text-center for-name">${habit.name}</td>
                        <td class="text-center">
                            <div class="text-center">
                                <div class="d-inline-block">
                                    <div class="btn-toolbar mx-auto" role="toolbar">
                                        <div class="btn-group" role="group">
                                            <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#update-modal" data-id="${habit.id}" data-name="${habit.name}">Update</button>
                                            <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#delete-modal" data-id="${habit.id}" data-name="${habit.name}">Delete</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>

<div class="modal fade" id="update-modal" role="dialog" aria-labelledby="delete-modal-label" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Update habit</h5>
                <button type="button" class="close" data-dismiss="modal">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <form
                        class="needs-validation"
                        id="updateForm"
                        method="POST"
                        action="${pageContext.request.contextPath}/habits/update">
                    <div class="form-group">
                        <input
                                name="id"
                                id="habitId"
                                class="form-control"
                                type="hidden"/>
                    </div>
                    <div class="form-group">
                        <label class="p-1">habit name</label>
                        <input
                                name="name"
                                id="habitName"
                                class="form-control js-needs-validation"
                                type="text" placeholder="Enter new habit name"/>
                        <div class="invalid-feedback p-0">
                            Please provide a valid habit name.
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">No</button>
                <button type="button" class="btn btn-primary send-update-habit">Save changes</button>
            </div>
        </div>
    </div>
</div>

<div class="modal fade" id="delete-modal" role="dialog" aria-labelledby="delete-modal-label" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Delete habit</h5>
                <button type="button" class="close" data-dismiss="modal">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                Are you sure you want to delete this habit ?
                <div class="invalid-feedback p-0 habit-on-product">
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">No</button>
                <button type="button" class="btn btn-primary delete-habit">Yes</button>
            </div>
        </div>
    </div>
</div>

<div class="modal fade" id="add-modal" tabindex="-1" role="dialog" aria-labelledby="add-modal-label" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="add-modal-label">Add habit</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <c:url value="/habits/add-habit" var="addHabitUrl"/>
            <form:form id="submit-habit" method="POST" action="${addHabitUrl}" modelAttribute="habitDto">
                <div class="modal-body">

                    <div class="form-group">
                        <from:label path="name" for="addHabit">New habit name</from:label>
                        <form:input path="name" type="text" class="form-control js-needs-validation" id="addHabit" aria-describedby="addingNewHabit" placeholder="Enter habit name"/>
                        <div class="invalid-feedback p-0">
                            Please provide a habit name.
                        </div>
                    </div>


                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">No</button>
                    <button type="submit" class="add-habit btn btn-primary">Yes</button>
                </div>
            </form:form>
        </div>
    </div>
</div>

<div class="fixed-top m-2">
    <button class="btn btn-light" onclick="location.href = '${pageContext.request.contextPath}'">Back</button>
</div>
<%@include file="../../resources/javascriptResources.jsp" %>
</body>
</html>