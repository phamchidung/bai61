<%-- 
    Document   : LeftOrderDetailPage.jsp
    Created on : Aug 22, 2021, 4:46:08 PM
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
        <link href="/order/css/LeftOrderDetailStyle.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="left-order-detail">
            <h3 class="center mb20">Thông tin đơn hàng</h3>
            <c:if test="${showMess != null}">
                <c:if test="${status.statusCode == 'DH'}">
                    <div class="alert alert-danger" role="alert">
                        Đơn hàng ${requestScope.statusContent} thành công!
                    </div>
                </c:if>
                <c:if test="${status.statusCode == 'DD'}">
                    <div class="alert alert-success" role="alert">
                        Đơn hàng ${requestScope.status.statusContent} thành công!
                    </div>
                </c:if>

                <script>
                    setTimeout(function () {
                        $(".alert").remove();
                    }, 4000);
                </script>
            </c:if>

            <div class="order-info order-info-line center">
                <p class="color-black">Mã số đơn hàng: ${requestScope.orderCode}</p>
                <p class="color-black">Loại bàn: ${requestScope.tableType}</p>
                <p class="color-black">Thời gian đặt: ${requestScope.orderDate}</p>
                <p class="color-black">Thời gian tổ chức: ${requestScope.dateTakesPlace}</p>
                <p class="color-black">Ghi chú: ${requestScope.note}</p>
                <p class="color-dodgerblue">Trạng thái: ${requestScope.statusContent}</p>
            </div>

            <div class="total-money center mt20">
                <p class="color-black">Tổng tiền: ${requestScope.totalMoney} VNĐ</p>
                <p class="color-black">Tiền đặt cọc (10%): ${requestScope.deposit} VNĐ</p>
            </div>

            <div class="center btn-order-parent">
                <c:if test="${requestScope.statusCode == 'CD'}">
                    <form id="acept-form" action="order" method="post" class="inlinte-block">
                        <input type="hidden" value="${index}" name="index"/>
                        <input type="hidden" value="${code}" name="code"/>
                        <input type="hidden" value="${requestScope.id}" name="id"/>
                        <input type="hidden" value="DD" name="statusCode"/>
                        <button onclick="acept()" type="button" class="btn btn-success">Nhận đơn</button>
                        <script>
                            function acept() {
                                var acepted = confirm("Bạn chắc chắn nhận đơn?");
                                if (acepted === true) {
                                    document.getElementById("acept-form").submit();
                                }
                            }
                        </script>
                    </form>
                </c:if>

                <c:if test="${requestScope.statusCode == 'CD' or requestScope.statusCode == 'DD'}">
                    <form id="reject-form" action="order" method="post" class="inlinte-block">
                        <input type="hidden" value="${index}" name="index"/>
                        <input type="hidden" value="${code}" name="code"/>
                        <input type="hidden" value="${requestScope.id}" name="id"/>
                        <input type="hidden" value="DH" name="statusCode"/>
                        <button onclick="reject()" type="button" class="btn btn-danger">Hủy đơn</button>
                        <script>
                            function reject() {
                                var rejected = confirm("Bạn chắc chắn hủy đơn?");
                                if (rejected === true) {
                                    document.getElementById("reject-form").submit();
                                }
                            }
                        </script>
                    </form>
                </c:if>
            </div>
        </div>

        <!-- Optional JavaScript -->
        <!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
        <script src="/order/js/order.js"></script>
    </body>
</html>
