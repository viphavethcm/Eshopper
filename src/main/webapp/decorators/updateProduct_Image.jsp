<%--
  Created by IntelliJ IDEA.
  User: asus s510u
  Date: 7/15/2020
  Time: 7:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/Tablibs.jsp"%>
<html>
<head>
    <title>Eshopper</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <title><dec:title default="Home | E-Shopper"/></title>
    <link href="<c:url value='/templates/css/bootstrap.min.css'/> " rel="stylesheet">
    <link href="<c:url value='/templates/css/font-awesome.min.css'/> " rel="stylesheet">
    <link href="<c:url value='/templates/css/prettyPhoto.css'/> " rel="stylesheet">
    <link href="<c:url value='/templates/css/price-range.css'/> " rel="stylesheet">
    <link href="<c:url value='/templates/css/animate.css'/> " rel="stylesheet">
    <link href="<c:url value='/templates/css/main.css'/> " rel="stylesheet">
    <link href="<c:url value='/templates/css/responsive.css'/> " rel="stylesheet">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.css" rel="stylesheet">
    <script src="<c:url value='/templates/js/jquery.js'/> "></script>
    <script src="<c:url value='/templates/js/jquery-ui.js'/>"></script>
    <script src="<c:url value='/templates/js/price-range.js'/> "></script>
    <script src="<c:url value='/templates/js/bootstrap.min.js'/> "></script>
    <dec:head/>
</head>
<body>
<%--Begin header--%>
<header id="header">
    <%@ include file="/common/admin/header.jsp"%>
</header>

<%--Begin slider--%>
<section id="slider"><!--slider-->
    <%@ include file="/common/admin/slider.jsp"%>
</section>
<%--End Slider--%>

<%--Begin menu--%>
<section>
    <div class="container">
        <div class="row">
            <%@ include file="/common/admin/menu.jsp"%>
            <dec:body/>
        </div>
    </div>
</section>
<%--End menu--%>

<%--Begin footer--%>
<section id="footer">
    <%@include file="/common/admin/footer.jsp"%>
</section>
<%--End slider--%>
</body>
</html>
