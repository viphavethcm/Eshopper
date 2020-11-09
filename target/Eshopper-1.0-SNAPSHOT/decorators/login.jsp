<%--
  Created by IntelliJ IDEA.
  User: pojo
  Date: 27/11/19
  Time: 7:52 am
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"  %>
<%@include file="/common/Tablibs.jsp"%>
<html>
<head>
    <title><dec:title default="Login"/> </title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Login | E-Shopper</title>
    <link href="<c:url value='/templates/css/bootstrap.min.css'/>" rel="stylesheet">
    <link href="<c:url value='/templates/css/font-awesome.min.css'/> " rel="stylesheet">
    <link href="<c:url value='/templates/css/prettyPhoto.css'/> " rel="stylesheet">
    <link href="<c:url value='/templates/css/price-range.css'/> " rel="stylesheet">
    <link href="<c:url value='/templates/css/animate.css'/> " rel="stylesheet">
    <link href="<c:url value='/templates/css/main.css'/> " rel="stylesheet">
    <link href="<c:url value='/templates/css/responsive.css'/> " rel="stylesheet">
    <script src="<c:url value='/templates/js/jquery.js'/> "></script>
    <dec:head/>
</head>

<body>
<%--    heder--%>
        <%@include file="/common/login/header.jsp"%>
            <div>
        <dec:body/>
            </div>

        <%@include file="/common/login/footer.jsp"%>

</body>
<script src="<c:url value='/templates/js/price-range.js'/> "></script>
<script src="<c:url value="/templates/js/jquery.scrollUp.min.js"/> "></script>
<script src="<c:url value='/templates/js/bootstrap.min.js'/> "></script>
<script src="<c:url value='/templates/js/main.js'/> "></script>
</html>
