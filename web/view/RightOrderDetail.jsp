<%-- 
    Document   : RightOrderDetailPage.jsp
    Created on : Aug 22, 2021, 4:48:46 PM
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
        <link href="/order/css/RightOrderDetailStyle.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="right">
            <c:set var="foods" value="${requestScope.foods}" scope="request"/>
            <c:set var="serviceses" value="${requestScope.serviceses}" scope="request"/>
            <c:set var="comboFoods" value="${requestScope.comboFoods}" scope="request"/>
            
            <c:set var="totalFoodsMoney" value="${requestScope.totalFoodsMoney}" scope="request"/>
            <c:set var="totalServicesesMoney" value="${requestScope.totalServicesesMoney}" scope="request"/>
            <c:set var="totalComboFoodsMoney" value="${requestScope.totalComboFoodsMoney}" scope="request"/>

            <c:import url="FoodTable.jsp"/>
            <c:import url="ComboFoodTable.jsp"/>
            <c:import url="ServiceTable.jsp"/>
        </div>

        <!-- Optional JavaScript -->
        <!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
        <script src="/order/js/order.js"></script>
    </body>
</html>
