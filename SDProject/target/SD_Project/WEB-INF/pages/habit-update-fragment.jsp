<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<input id="status" value="${status}" type="hidden">
<table>
    <tr>
        <td class="text-center for-name">${habit.name}</td>
        <td class="text-center">
            <div class="text-center">
                <div class="d-inline-block">
                    <div class="btn-toolbar mx-auto" role="toolbar">
                        <div class="btn-group" role="group">
                            <button type="button" class="btn btn-primary" data-toggle="modal"
                                    data-target="#update-modal" data-id="${habit.habitId}" data-name="${habit.name}">
                                Update
                            </button>
                            <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#delete-modal"
                                    data-id="${habit.habitId}" data-name="${habit.name}">Delete
                            </button>
                        </div>
                    </div>
                </div>
            </div>
        </td>
    </tr>
</table>
</body>
</html>
