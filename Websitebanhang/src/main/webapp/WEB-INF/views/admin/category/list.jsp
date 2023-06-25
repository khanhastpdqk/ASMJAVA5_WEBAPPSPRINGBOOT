<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<div class="container">
    <h2>Quản lý loại sản phẩm:</h2>
    <form:form action="/admin/category" modelAttribute="item">
          <div class="mb-3">
            <label class="form-label">Id:</label>
            <form:input class="form-control" path="id" />
            <form:errors path="id" cssStyle="color: red"/>
        </div>
        <div class="mb-3">
            <label class="form-label">Name:</label>
            <form:input class="form-control" path="name"/>
            <p style="color: red">${mess}</p>
        </div>


        <button  class="btn btn-success" formaction="/admin/category/create">Create</button>
        <button  class="btn btn-success" formaction="/admin/category/update">Update</button>
        <button class="btn btn-success"
                onclick="return confirmDelete()"
                formaction="/admin/category/delete/${item.id}">Delete</button>
    </form:form>
    <hr>
    <table class="table" border="1" style="width:100%">
        <tr>
            <th scope="col">Id</th>
            <th scope="col">Name</th>

        </tr>
        <c:forEach var="item" items="${items}">
            <tr>
                <td>${item.id}</td>
                <td>${item.name}</td>
                <td><a href="/admin/category/edit/${item.id}">Edit</a></td>
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