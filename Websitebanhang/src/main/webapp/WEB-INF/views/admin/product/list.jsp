<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<div class="container">
    <h2>Quản lý sản phẩm:</h2>
    <form:form action="/admin/product" modelAttribute="item">
        <div class="mb-3">
            <form:input type="hidden" class="form-control" path="id"/>
            <form:errors path="id" cssStyle="color: red"/>
        </div>
        <div class="mb-3">
            <label class="form-label">Name:</label>
            <form:input class="form-control" path="name" placeholder="Product Username?"/>
            <form:errors path="name" cssStyle="color: red"/>
        </div>
        <div class="mb-3">
            <label class="form-label">Image:</label>
            <form:input type="file" class="form-control" path="image" placeholder="Product Image?"/>
            <form:errors path="image" cssStyle="color: red"/>
        </div>
        <div class="mb-3">
            <label class="form-label">Price:</label>
            <form:input type="number" class="form-control" path="price" placeholder="Product price?"/>
            <form:errors path="price" cssStyle="color: red"/>
        </div>
        <div class="mb-3">
            <label class="form-label">Category:</label>
            <form:select path="category.id" class="form-control" placeholder="Tên sản phẩm">
                <option value="">----</option>
                <form:options items="${categoryList}" itemLabel="name" itemValue="id"/>
            </form:select>
            <form:errors path="category.id" element="div" cssStyle="color: red"/>
        </div>
        <div class="mb-3">
            <label class="form-label">Date:</label>
            <form:input class="form-control" path="createDate" placeholder="Product date?"/>
            <form:errors path="createDate" cssStyle="color: red"/>
        </div>

        <button  class="btn btn-success" formaction="/admin/product/create">Create</button>
        <button  class="btn btn-success" formaction="/admin/product/update">Update</button>
        <button class="btn btn-success"
                onclick="return confirmDelete()"
                formaction="/admin/product/delete/${item.id}">Delete</button>
    </form:form>
    <hr>
    <table class="table" border="1" style="width:100%">
        <tr>
            <th scope="col">Id</th>
            <th scope="col">Name</th>
            <th scope="col">Image</th>
            <th scope="col">Price</th>
            <th scope="col">Category</th>
            <th scope="col">Date</th>

        </tr>
        <c:forEach var="pro" items="${items}">
            <tr>
                <td>${pro.id}</td>
                <td>${pro.name}</td>
                <td><img width="40px" height="auto"  src="/static/images/${pro.image}"></td>
                <td>${pro.price}</td>
                <td>${pro.category.name}</td>
                <td>${pro.createDate}</td>
                <td><a href="/admin/product/edit/${pro.id}">Edit</a></td>
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