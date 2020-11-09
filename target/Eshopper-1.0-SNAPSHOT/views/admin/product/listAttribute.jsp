<%--
  Created by IntelliJ IDEA.
  User: asus s510u
  Date: 4/16/2020
  Time: 3:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/common/Tablibs.jsp" %>
<c:url value="/admin-showList-attribute.html" var="formUtil"/>
<c:url value="/ajax-list-Brand" var="listBrandbtn">
    <c:param name="urlType" value="show_listBrand"/>
</c:url>
<html>
<head>
    <link href="<c:url value='/templates/css/admin.css'/> " rel="stylesheet">
    <style>
        #attributes {
            display: flex;
            justify-content: space-between;
            align-items: center;
        }
    </style>
</head>
<body>
<div class="col-sm-9 padding-right">
    <div class="table">
        <h2 class="title text-center">Attributes</h2>
        <div id="attributes">
            <div class="dropdown">
                <button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">Brands
                    <span class="caret"></span></button>
                <ul class="dropdown-menu">
                    <li><a href="#" id="show_listBrand" data-href="${listBrandbtn}">List Brand</a></li>
                    <li><a href="#">New Brand</a></li>
                </ul>
            </div>
            <div class="dropdown">
                <button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">Colors
                    <span class="caret"></span></button>
                <ul class="dropdown-menu">
                    <li><a href="#">List Color</a></li>
                    <li><a href="#">New Color</a></li>
                </ul>
            </div>
            <div class="dropdown">
                <button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">Sizes
                    <span class="caret"></span></button>
                <ul class="dropdown-menu">
                    <li><a href="#">List Size</a></li>
                    <li><a href="#">New Size</a></li>
                </ul>
            </div>
        </div>
    </div>
</div>
<div class="modal fade" id="listBrand" tabindex="-1"></div>
<script type="text/javascript">
    $(document).ready(function () {
        $('#show_listBrand').click(function () {
            var url = $('#show_listBrand').attr("data-href")
            $('#listBrand').load(url, "", function () {
                $('#listBrand').modal('show');
            })
        })
    })
</script>
</body>
</html>

