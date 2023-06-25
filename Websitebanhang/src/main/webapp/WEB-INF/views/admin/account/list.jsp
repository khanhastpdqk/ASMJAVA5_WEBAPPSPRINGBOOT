<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<div class="container">
    <h2>Quản lý tài khoản:</h2>
<form:form action="/admin/account" modelAttribute="item">
    <div class="mb-3">
        <label class="form-label">Username:</label>
        <form:input class="form-control" path="username" placeholder="Account Username?"/>
        <form:errors path="username" cssStyle="color: red"/>
    </div>
    <div class="mb-3">
        <label class="form-label">Password:</label>
        <form:input class="form-control" path="password" placeholder="Account Password?"/>
        <form:errors path="password" cssStyle="color: red"/>
    </div>
    <div class="mb-3">
        <label class="form-label">Fullname:</label>
        <form:input class="form-control" path="fullname" placeholder="Account Fullname?"/>
        <form:errors path="fullname" cssStyle="color: red"/>
    </div>
    <div class="mb-3">
        <label class="form-label">Email:</label>
        <form:input class="form-control" path="email" placeholder="Account Email?"/>
        <form:errors path="email" cssStyle="color: red"/>
    </div>
    <div class="mb-3">
        <label class="form-label">Photo:</label>
        <form:input type="file" class="form-control" path="photo" placeholder="Account Photo?"/>
        <form:errors path="photo" cssStyle="color: red"/>
    </div>
    <div class="mb-3">
        <label class="form-label">Activated:</label>
        <form:select class="form-control" path="activated" placeholder="Account activated?">
            <option value="">----</option>
            <form:option class="form-control" value="0" /> Yes
            <form:option class="form-control" value="1" /> No
        </form:select>
        <form:errors path="activated" cssStyle="color: red"/>
    </div>
    <div class="mb-3">
        <label class="form-label">Admin:</label>
        <form:select class="form-control" path="admin" placeholder="Account admin?">
            <option value="">----</option>
            <form:option class="form-control" value="0" /> Yes
            <form:option class="form-control" value="1" /> No
        </form:select>
        <form:errors path="admin" cssStyle="color: red"/>
    </div>
    <hr>

    <button  class="btn btn-success" formaction="/admin/account/create">Create</button>
    <button  class="btn btn-success" formaction="/admin/account/update">Update</button>
    <button class="btn btn-success"
            onclick="return confirmDelete()"
            formaction="/admin/account/delete/${item.username}">Delete</button>
</form:form>
<hr>
<table class="table" border="1" style="width:100%">
    <tr>
        <th scope="col">Username</th>
        <th scope="col">Password</th>
        <th scope="col">Fullname</th>
        <th scope="col">Email</th>
        <th scope="col">Photo</th>
        <th scope="col">Activated</th>
        <th scope="col">Admin</th>
    </tr>
    <c:forEach var="item" items="${items}">
        <tr>
            <td>${item.username}</td>
            <td>${item.password}</td>
            <td>${item.fullname}</td>
            <td>${item.email}</td>
            <td><img width="40px" height="auto" src="/static/images/${item.photo}"></td>
            <td>${item.activated}</td>
            <td>${item.admin}</td>
            <td><a href="/admin/account/edit/${item.username}">Edit</a></td>
        </tr>
    </c:forEach>
</table>
</div>
<script>
    function confirmDelete() {
        if (confirm("Bạn có chắc muốn xoá?")) {
            return true;
        } else {
            return false;
        }
    }
</script>