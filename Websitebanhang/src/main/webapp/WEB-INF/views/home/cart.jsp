<%@ page pageEncoding="utf-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<div class="container mt-3">
    <table class="table">
        <thead>
            <tr>
                <th>Sản phẩm</th>
                <th>Đơn giá</th>
                <th>Số lượng</th>
                <th>Thành tiền</th>
                <th></th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="item" items="${cart.getCartDetails()}">

                    <tr>
                        <td>${item.product.name}</td>
                        <td>${item.price}</td>
                        <td>
                           ${item.quantity}
                        </td>
                        <td>${item.price * item.quantity}</td>
                        <td>
                            <a class="btn btn-sm btn-danger" href="/remove-cart/${item.product.id}">Xóa</a>
                        </td>
                    </tr>
            </c:forEach>
        </tbody>
    </table>
    <div class="my-2">Tổng số tiền: ${tong}</div>
    <a class="btn btn-secondary" href="/">Tiếp tục mua hàng</a>
    <a class="btn btn-primary" href="/confirm">Thanh toán</a>
</div>