<%@ page pageEncoding="utf-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<nav class="navbar navbar-expand-lg navbar-dark bg-primary p-0">
  <div class="navbar-nav collapse navbar-collapse">
    <a class="nav-item nav-link" href="/admin/category">Quản lý nhóm sản phẩm</a>
    <a class="nav-item nav-link" href="/admin/product">Quản lý sản phẩm</a>
    <a class="nav-item nav-link" href="/admin/account">Quản lý tài khoản</a>
    <a class="nav-item nav-link" href="/admin/order">Quản lý đơn hàng</a>
  </div>

  <ul class="navbar-nav ml-auto">
    <li class="nav-item no-arrow">
      <a class="nav-link dropdown-toggle p-0" data-bs-toggle="dropdown" href="#">
        <img alt="" class="rounded-circle" style="width:60px"
          src="/static/images/user.svg" />
      </a>
      <div class="dropdown-menu dropdown-menu-end">
        <a class="dropdown-item" href="/">
          Màn hình user
        </a>
        <a class="dropdown-item" href="/logout">
          Đăng xuất
        </a>
      </div>
    </li>
  </ul>
</nav>