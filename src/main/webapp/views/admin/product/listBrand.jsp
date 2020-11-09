<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: asus s510u
  Date: 4/17/2020
  Time: 10:19 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/common/Tablibs.jsp" %>
<html>
<head>
    <style>

    </style>
</head>
<body>
<div class="modal fade" id="listBrand" tabindex="-1">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title" style="text-align: center;">List Brand</h4>
            </div>
            <div class="modal-body">
                <table class="table">
                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>Brand Name</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="brand" items="brands">
                        <tr>
                            <td>${brand.brandID}</td>
                            <td>${brand.brandName}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
</body>
</html>
