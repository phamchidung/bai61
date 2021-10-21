<%-- 
    Document   : OrderDetailPage
    Created on : Aug 22, 2021, 2:17:27 PM
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
        <c:forEach items="${listOrder}" var="o">
            <c:set var="orderCode" value="${o.orderCode}" scope="request"/>
            <c:set var="tableType" value="${o.tableType}" scope="request"/>
            <c:set var="orderDate" value="${o.orderDate}" scope="request"/>
            <c:set var="dateTakesPlace" value="${o.dateTakesPlace}" scope="request"/>
            <c:set var="note" value="${o.note}" scope="request"/>
            <c:set var="statusContent" value="${o.status.statusContent}" scope="request"/>
            <c:set var="statusCode" value="${o.status.statusCode}" scope="request"/>
            <c:set var="totalMoney" value="${o.getTotalMoneyFormatted()}" scope="request"/>
            <c:set var="deposit" value="${o.getDepositFormatted()}" scope="request"/>
            <c:set var="index" value="${index}" scope="request"/>
            <c:set var="code" value="${code}" scope="request"/>
            <c:set var="id" value="${o.id}" scope="request"/>

            <c:set var="foods" value="${o.foods}" scope="request"/>
            <c:set var="serviceses" value="${o.serviceses}" scope="request"/>
            <c:set var="comboFoods" value="${o.comboFoods}" scope="request"/>

            <c:set var="totalFoodsMoney" value="${o.getTotalFoodsMoneyFormatted()}" scope="request"/>
            <c:set var="totalServicesesMoney" value="${o.getTotalServiceMoneyFormatted()}" scope="request"/>
            <c:set var="totalComboFoodsMoney" value="${o.getTotalComboFoodsMoneyFormatted()}" scope="request"/>

            <!-- Modal -->
            <div class="modal fade" id="orderDetailModal${o.id}" tabindex="-1" role="dialog">
                <div class="modal-dialog modal-xl" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5>Chi tiết đơn hàng</h4>
                        </div>

                        <div class="modal-body">
                            <div class="container">
                                <div class="row">
                                    <div class="col-sm">
                                        <c:import url="LeftOrderDetail.jsp" />
                                    </div>
                                    <div class="col-sm">
                                        <c:import url="RightOrderDetail.jsp"/>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Trở lại</button>
                        </div>
                    </div>
                </div>
            </div>
        </c:forEach>

        <!-- Optional JavaScript -->
        <!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
        <script src="/order/js/order.js"></script>
    </body>
</html>
