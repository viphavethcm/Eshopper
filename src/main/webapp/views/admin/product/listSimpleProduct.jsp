<%--
  Created by IntelliJ IDEA.
  User: asus s510u
  Date: 4/17/2020
  Time: 8:21 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<div class="modal-dialog">
    <div class="modal-content" style="  border-radius: 5px;">
        <div class="modal-header" style="background:#FE980F">
            <button class="close" data-dismiss="modal">&times;</button>
            <h4 class="modal-title" style="text-align: center;">Product Detail</h4>
        </div>
        <div class="modal-body" id="product_detail">
            <table class="table table-hover">
                <div id="search">
                    <input class="form-control" style="width: 50%; display: initial" id="myInput" type="text"
                           placeholder="Search..">
                    <button id="btnDelete"
                            style="vertical-align: bottom; margin-top: 0px; float: right; margin-right: 45px"
                            class="btn btn-sm btn-primary btn-delete" data-toggle="tooltip" title="Delete"><i
                            class="fa fa-trash-o" aria-hidden="true" id="deleteProduct"></i></button>
                </div>
                <thead>
                <tr>
                    <th scope="col"><input type="checkbox" name="checkList" class="check-box-element"/></th>
                    <th scope="col">Color</th>
                    <th scope="col">Size</th>
                    <th scope="col">Quantity</th>
                    <th scope="col">Image</th>
                </tr>
                <c:forEach var="product" items="${model}">
                    <tr>
                        <td scope="row"><input type="checkbox" name="checkList" id="checkbox_${product.ID}"
                                               value="${product.ID}" class="check-box-element"/></td>
                        <td>${product.color}</td>
                        <td>${product.size}</td>
                        <td>${product.quantity}</td>
                        <td class="baseImg"><img
                                src="<c:url value="/templates/images/product-details/${product.baseImage}"/>"></td>
                    </tr>
                </c:forEach>
                </thead>
            </table>
        </div>
        <div class="modal-footer">
            <button class="btn btn-primary" data-dismiss="modal">Close</button>
        </div>
    </div>
</div>
</html>
