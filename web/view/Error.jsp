<%-- 
    Document   : Error
    Created on : Feb 20, 2021, 7:33:49 PM
    Author     : HP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css" />
        <link href="/order/css/OrderStyle.css" rel="stylesheet" type="text/css"/>
        <link href="/order/css/ErrorStyle.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <jsp:include page="Header.jsp" />
        <div class="content-error">
            <p class="error">Lỗi hệ thống không xác định!</p>
        </div>
        <jsp:include page="Aboutus.jsp" />
        <jsp:include page="Footer.jsp" />
    </body>
</html>
