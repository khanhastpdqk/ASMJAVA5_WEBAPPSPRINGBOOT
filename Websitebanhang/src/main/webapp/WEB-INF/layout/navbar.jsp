<%@ page pageEncoding="utf-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "f" uri = "http://java.sun.com/jsp/jstl/functions" %>
<header>
    <div>
        <div class="container">
<nav class="header__menu mobile-menu">
    <div class="row">
    <div class="col-lg-7 col-md-7">
        <ul>
      <li class="active"><a  href="/">Sản phẩm</a></li>
      <li><a href="/about">Giới thiệu</a></li>
        </ul>
    </div>
        <div class="col-lg-5 col-md-5">
  <ul class="header__top__right">
    <li class="header__top__links">
        <a href="/cart" class="nav-link mt-2 text-light" style="width:40px">
          <img alt="" style="width:40px"
            src="/static/images/cart.png" />
        </a>
    </li>
    <li class="header__top__links">
      <a class="header__top__links" data-bs-toggle="dropdown" href="#" style="width:40px">
        <img alt="" class="rounded-circle" style="width:60px"
          src="/static/images/user.svg" />
      </a>
      <div class="dropdown-menu dropdown-menu-end">
        <c:if test="${checkrole == true}">
        <a class="dropdown-item" href="/admin/product">
          Màn hình admin
        </a>
        </c:if>
        <a class="dropdown-item" href="/logout">
          Đăng xuất
        </a>
      </div>
    </li>
  </ul>
        </div>
    </div>
</nav>
        </div>
    </div>

    <hr>
</header>