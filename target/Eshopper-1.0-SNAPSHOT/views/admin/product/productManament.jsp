<%--
  Created by IntelliJ IDEA.
  User: asus s510u
  Date: 3/7/2020
  Time: 10:35 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@include file="/common/Tablibs.jsp" %>
<c:url var="deleteUrl" value="/admin-deleteProduct"/>
<c:url var="listUrl" value="/admin-listProduct"/>
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

        .baseImg img {
            height: 35px;
            width: 35px;
            padding-left: 7px;
        }
    </style>
</head>
<div class="col-sm-9 padding-right">
    <div id="search">
        <input class="form-control" style="width: 50%; display: initial" id="myInput" type="text"
               placeholder="Search..">
        <button id="btnDelete" style="vertical-align: bottom; margin-top: 0px; float: right; margin-right: 37px"
                class="btn btn-sm btn-primary btn-delete" data-target="addModal" data-toggle="modal" title="Delete"><i
                class="fa fa-trash-o" aria-hidden="true"></i></button>
        <button id="btnAdd" style="vertical-align: bottom; margin-top: 0px; float: right;margin-right: 37px"
                class="btn btn-sm btn-primary btn-add" data-toggle="tooltip" title="New Product"><i class="fa fa-plus"
                                                                                                    aria-hidden="true"></i>
        </button>

    </div>
    <form action="<c:url value="/admin-listProduct"/>" id="formSubmit">
        <table class="table table-hover">
            <thead>
            <tr>
                <th scope="col"><input type="checkbox" name="checkList" class="check-box-element"/></th>
                <th scope="col">ID</th>
                <th scope="col">Product Name</th>
                <th scope="col">Price</th>
                <th scope="col">Created Date</th>
                <th scope="col">Brand Name</th>
                <th scope="col">Image</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="product" items="${model.listResult}">
                <tr>
                    <td scope="row"><input type="checkbox" name="checkList" id="checkbox_${product.ID}"
                                           value="${product.ID}" class="check-box-element"/></td>
                    <td>${product.ID}</td>
                    <td>${product.productName}</td>
                    <td>${product.price}</td>
                    <td>${product.create_Day}</td>
                    <td>${product.brandID.brandName}</td>
                    <c:url var="productDetailUrl" value="/ajax-product-detail">
                        <c:set var="id" value="${product.ID}"/>
                    </c:url>
                    <td class="baseImg"><img
                            src="<c:url value="/templates/images/product-details/${product.baseImage}"/>"></td>
                    <td>
                        <button id="btnDetail" style="vertical-align: bottom; margin-top: 0px"
                                class="btn btn-sm btn-primary btn-edit" data-href="${product.ID}" title="Details"><i
                                class="fa fa-pencil-square-o" aria-hidden="true"></i></button>
                    </td>
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
<%-- Product Details modal popup --%>
<div class="modal fade" id="detailModal" data-keyboard="false" data-backdrop="static" tabindex="-1"></div>

<%-- Add Product modal popup --%>
<div class="modal fade" id="addModal" data-keyboard="false" data-backdrop="static" tabindex="-1"></div>
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
                    $('#sortName').val('productID');
                    $('#sortBy').val('asc');
                    $('#formSubmit').submit();
                }

                $(document).ready(function () {
                    // load Product Details
                    $('#btnDetail').click(function (e) {
                        e.preventDefault();
                        var productID = $(this).attr('data-href');
                        $.ajax({
                            method: 'get',
                            url: '/Eshopper/ajax-product-detail',
                            data: {productID: productID},
                            success: function (response) {
                                $('#detailModal').html(response);
                                $('#detailModal').modal('show');
                            }
                        })
                    })

                })
            }
        });
    });
</script>
</html>
