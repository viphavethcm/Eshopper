<%--
  Created by IntelliJ IDEA.
  User: asus s510u
  Date: 4/27/2020
  Time: 2:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@include file="/common/Tablibs.jsp"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"  %>

<html>
<head>
    <title>Eshopper</title>
    <meta charset="utf-8">
    <meta http-equiv='Content-Type' content='text/html; charset=UTF-8' />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <title><dec:title default="Home | E-Shopper"/></title>
    <link href="<c:url value='/templates/css/bootstrap.min.css'/> " rel="stylesheet"/>
    <link href="<c:url value='/templates/css/font-awesome.min.css'/> " rel="stylesheet"/>
    <link href="<c:url value='/templates/css/prettyPhoto.css'/> " rel="stylesheet"/>
    <link href="<c:url value='/templates/css/price-range.css'/> " rel="stylesheet"/>
    <link href="<c:url value='/templates/css/animate.css'/> " rel="stylesheet"/>
    <link href="<c:url value='/templates/css/main.css'/> " rel="stylesheet"/>
    <link href="<c:url value='/templates/css/responsive.css'/> " rel="stylesheet"/>
</head>
<body>
<%--Begin header--%>
<header id="header">
    <%@ include file="/common/home/header.jsp"%>
</header>

<%--Begin slider--%>
<section id="slider"><!--slider-->
    <%@ include file="/common/home/slider.jsp"%>
</section>
<%--End Slider--%>

<%--Begin menu--%>
<section>
    <div class="container">
        <div class="row">
            <%@ include file="/common/home/menu.jsp"%>
            <dec:body/>
        </div>
    </div>
</section>
<%--End menu--%>

<%--Begin footer--%>
<section id="footer">
    <%@include file="/common/home/footer.jsp"%>
</section>
<%--End slider--%>
</body>
<script src="<c:url value='/templates/js/jquery.js'/> " type="text/javascript"></script>
<script src="<c:url value='/templates/js/price-range.js'/> " type="text/javascript"></script>
<script src="<c:url value='/templates/js/jquery.scrollUp.min.js'/> "type="text/javascript"></script>
<script src="<c:url value='/templates/js/bootstrap.min.js'/> "type="text/javascript"></script>
<script src="<c:url value='/templates/js/main.js'/> "type="text/javascript"></script>
</html>
