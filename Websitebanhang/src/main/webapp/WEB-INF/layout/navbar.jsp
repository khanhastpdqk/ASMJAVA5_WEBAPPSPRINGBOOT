<%@ page pageEncoding="utf-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "f" uri = "http://java.sun.com/jsp/jstl/functions" %>

<nav class="navbar navbar-expand-lg navbar-dark bg-primary p-0">
  <div class="navbar-nav collapse navbar-collapse">
    <a class="nav-item nav-link active" href="/">Sản phẩm</a>
    <a class="nav-item nav-link" href="/about">Giới thiệu</a>
  </div>

  <ul class="navbar-nav ml-auto">
    <li class="nav-item no-arrow">
      <c:if test="${cart.total > 0}">
        <a href="/cart" class="nav-link mt-2 text-light">
          <img alt="" style="width:40px"
            src="/static/images/cart.png" />
            (${cart.total})
        </a>
      </c:if>
    </li>
    <li class="nav-item no-arrow">
      <a class="nav-link dropdown-toggle p-0" data-bs-toggle="dropdown" href="#">
        <img alt="" class="rounded-circle" style="width:60px"
          src="/static/images/user.svg" />
      </a>
      <div class="dropdown-menu dropdown-menu-end">
<%--        <c:if test="${user.getAdmin == false}">--%>
        <a class="dropdown-item" href="/admin/category">
          Màn hình admin
        </a>
<%--        </c:if>--%>
        <a class="dropdown-item" href="/logout">
          Đăng xuất
        </a>
      </div>
    </li>
  </ul>
</nav>