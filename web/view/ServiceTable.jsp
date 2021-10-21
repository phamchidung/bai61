<%-- 
    Document   : ServiceTable
    Created on : Aug 22, 2021, 7:21:55 PM
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
        <link href="/order/css/TableStyle.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>

        <div class="service">
            <h3>Dịch vụ</h3>
            <!-- Table -->               
            <table class="table table-border-custom">
                <thead class="thead-green">
                    <tr>
                        <th scope="col">#</th>
                        <th scope="col">Tên dịch vụ</th>
                        <th scope="col">Giá (VNĐ)</th>
                        <th scope="col">Số lượng</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${requestScope.serviceses}" var="o">
                        <tr>
                            <th scope="row">1</th>
                            <td>${o.name}</td>
                            <td class="table-element-left"><p>${o.price}</p></td>
                            <td class="table-element-left"><p>${o.amount}</p></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>

            <p class="color-green">Tổng tiền dịch vụ: ${requestScope.totalServicesesMoney} VNĐ</p>
        </div>

        <!-- Optional JavaScript -->
        <!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
        <script src="/order/js/order.js"></script>
    </body>
</html>
