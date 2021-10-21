<%-- 
    Document   : OrderPage
    Created on : Aug 22, 2021, 8:46:37 AM
    Author     : HP
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css" />
        <link href="/order/css/OrderStyle.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <jsp:include page="OrderDetailPage.jsp" />
        <input type="hidden" id="checkShowModal" data-id="${orderId}"/>
        <input type="hidden" id="message" data-id="${status}"/>
        
        <jsp:include page="Header.jsp" />
        <div class="container">
            <div class="main">
                <!-- Navbar -->
                <nav class="navbar navbar-expand-lg navbar-light">
                    <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
                        <div class="navbar-nav center">
                            <a class="nav-item nav-link" href="#"><p class="color-black">Thông tin</p></a>
                            <a class="nav-item nav-link" href="#"><p class="color-black">Ảnh</p></a>
                            <a class="nav-item nav-link" href="#"><p class="color-black">Thực đơn</p></a>
                            <a class="nav-item nav-link" href="#"><p class="color-black">Combo món ăn</p></a>
                            <a class="nav-item nav-link" href="#"><p class="color-black">Dịch vụ</p></a>
                            <a class="nav-item nav-link" href="#"><p class="color-black">Khuyến mãi</p></a>
                            <a class="nav-item nav-link active" href="#"><p class="color-black">Đơn hàng</p></a>
                        </div>
                    </div>
                </nav>

                <h3 class="line-bottom center">Đơn hàng</h3>

                <!-- Search -->
                <div class="search-parent center">
                    <div class="search-name">
                        <p class="color-black">Mã đơn hàng</p>
                    </div>
                    <div class="search">
                        <form action="order">
                            <input class="code" required type="text" minlength="0" maxlength="10" placeholder="Nhập mã đơn hàng" value="${code}" name="code"/>
                            <button type="submit" class="btnSubmit"><i class="fa fa-search" aria-hidden="true"></i></button>
                        </form>
                    </div>
                </div>

                <!-- Table -->               
                <table class="table table-border-custom">
                    <thead class="thead-green">
                        <tr>
                            <th scope="col">Mã đơn</th>
                            <th scope="col">Tổng tiền</th>
                            <th scope="col">Ngày đặt</th>
                            <th scope="col">Trạng thái</th>
                            <th scope="col"></th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${listOrder}" var="o">
                            <tr>
                                <th scope="row">${o.orderCode}</th>
                                <td>${o.getTotalMoneyFormatted()} VNĐ</td>
                                <td>${o.orderDate}</td>
                                <td>${o.status.statusContent}</td>
                                <td><a class="btn btn-primary demo" data-id="${o.id}" href="#" role="button"><i class="fa fa-eye"></i> Chi tiết</a></td>

                            </tr>
                        </c:forEach>

                    </tbody>

                </table>

                <div class="center move-page-parent">
                    <c:if test="${index > 1}">
                        <a class="btn btn-move-page" href="order?index=${index-1}&code=${code}" role="button">Trang trước</a>
                    </c:if>

                    <c:forEach begin="1" end="${endPage}" var="i">
                        <a class="${i==index?"btn":"btn btn-move-page"}" 
                           href="order?index=${i}&code=${code}" 
                           role="button">${i}</a>
                    </c:forEach>

                    <c:if test="${index < endPage}">
                        <a class="btn btn-move-page" href="order?index=${index+1}&code=${code}" role="button">Trang sau</a>
                    </c:if>
                </div>

                <c:if test="${listOrderSize == 0}">
                    <p class="error">Không tìm thấy kết quả</p>
                </c:if>

            </div>

        </div>



        <jsp:include page="Aboutus.jsp" />
        <jsp:include page="Footer.jsp" />

        <!-- Optional JavaScript -->
        <!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
        <script src="/order/js/order.js"></script>
    </body>
</html>
