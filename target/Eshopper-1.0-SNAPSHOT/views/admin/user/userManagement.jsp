<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2/27/2020
  Time: 9:07 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@include file="/common/Tablibs.jsp" %>
<html>
<head>
    <script src="<c:url value='/templates/js/jquery.twbsPagination.js'/> "></script>
    <script src="<c:url value='/templates/js/jquery.twbsPagination.min.js'/> "></script>
    <link href="<c:url value='/templates/css/admin.css'/> " rel="stylesheet">
    <style>
        #search {
            padding-left: 25px;
            padding-bottom: 15px;
        }
    </style>
</head>
<body>
<div class="col-sm-9 padding-right">
    <div id="search">
        <input class="form-control" style="width: 50%; display: initial" id="myInput" type="text"
               placeholder="Search..">
        <a style="vertical-align: bottom; margin-top: 0px; float: right; margin-right: 45px"
           class="btn btn-sm btn-primary btn-delete" data-href="${deleteUrl}" data-toggle="tooltip" title="Delete"
           onclick="delete (this)"><i class="fa fa-trash-o" aria-hidden="true" id="deleteProduct"></i></a>
    </div>
    <form action="<c:url value="/admin-listUser"/>" id="formSubmit">
        <table class="table table-hover">
            <thead>
            <tr>
                <th scope="col"><input type="checkbox" name="checkList" class="check-box-element"/></th>
                <th scope="col">ID</th>
                <th scope="col">User Name</th>
                <th scope="col">Created Date</th>
                <th scope="col">Role</th>
                <th scope="col">Active</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="user" items="${model.listResult}">
                <tr>
                    <td scope="row"><input type="checkbox" name="checkList" class="check-box-element"/></td>
                    <td>${user.ID}</td>
                    <td>${user.userName}</td>
                    <td>${user.create_Day}</td>
                    <td>${user.roleName}</td>
                    <td>${user.status}</td>
                    <td><a style="vertical-align: bottom; margin-top: 0px" class="btn btn-sm btn-primary btn-edit"
                           data-href="${editUrl}" data-toggle="tooltip" title="Detail" onclick="update(this)"><i
                            class="fa fa-pencil-square-o" aria-hidden="true" id="editProduct"></i></a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <nav aria-label="Page navigation" style="text-align:center">
            <ul class="pagination" id="pagination"></ul>
        </nav>
        <input type="hidden" value="" id="page" name="page"/>
        <input type="hidden" value="" id="maxPageItem" name="maxPageItem"/>
        <input type="hidden" value="" id="sortName" name="sortName"/>
        <input type="hidden" value="" id="sortBy" name="sortBy"/>
    </form>
</div>
<script type="text/javascript">
    var totalPages =
    ${model.totalPages}
    var currentPage = ${model.page};
    var limit = 2;
    $(function () {
        window.pagObj = $('#pagination').twbsPagination({
            totalPages: totalPages,
            visiblePages: 10,
            startPage: currentPage,
            onPageClick: function (event, page) {
                if (currentPage != page) {
                    $('#maxPageItem').val(limit);
                    $('#page').val(page);
                    $('#sortName').val('userName');
                    $('#sortBy').val('desc');
                    $('#formSubmit').submit();
                }
            }
        });
    });
</script>
</body>
</html>
