<%--
  Created by IntelliJ IDEA.
  User: asus s510u
  Date: 4/15/2020
  Time: 3:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="<c:url value="/templates/css/select2.css"/>" rel="stylesheet"/>
    <link href="<c:url value="/templates/css/add-product.css"/>" rel="stylesheet"/>
</head>
<div class="col-sm-9">
    <div class="tab-content">
        <div class="tab-pane active" id="home">
            <hr>
            <form id="add-form" method="post" class="zoomOut">
                <div class="page">
                    <span>Step 1</span>
                    <div class="input-group component">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-pencil"></i></span>
                        <input id="productName" type="text" class="form-control" name="productName"
                               placeholder="Product Name">
                    </div>
                    <div class="input-group component">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-usd"></i></span>
                        <input id="price" type="text" class="form-control" name="price" placeholder="Price">
                    </div>
                    <div class="component">
                        <select id="brand" class="form-control"></select>
                    </div>
                </div>
                <div class="page">
                    <span>Step 2</span>
                    <div class="component">
                        <select id="size" class="form-control" multiple="multiple" style="width: 100%"></select>
                    </div>
                    <div class="component">
                        <select id="color" class="form-control" multiple="multiple" style="width: 100%"></select>
                    </div>
                    <div class="component">
                        <select id="typeCategory" class="form-control" multiple="multiple" style="width: 100%"></select>
                    </div>
                </div>
                <button type="button" class="btn btn-success" id="prevBtn" onclick="nextPrev(-1)"> Previous</button>
                <button type="button" class="btn btn-success" id="nextBtn" onclick="nextPrev(1)" style="float: right">
                    Continue
                </button>
            </form>
        </div>
    </div>
</div>
<%--            <form id="form2" style="display:none" method="post">--%>
<%--               --%>
<%--            </form>--%>
<%--<div class="modal fade" id="Save-modalPopup" data-keyboard="false" data-backdrop="static" tabindex="-1">--%>
<%--    <div class="modal-dialog" >--%>
<%--        <div class="modal-content" style="border-radius: 5px;">--%>
<%--            <div class="modal-body" id="">--%>
<%--                <h2 style="text-align: center;">Are you sure</h2>--%>
<%--            </div>--%>
<%--            <div class="modal-footer">--%>
<%--                <button class="btn btn-success" id="btnSave" type="submit">Save</button>--%>
<%--                <button class="btn btn-danger" data-dismiss ="modal">Close</button>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--</div>--%>
<script src="<c:url value='/templates/js/select2.min.js'/>"></script>
<script src="<c:url value='/templates/js/add-product.js'/>"></script>
<script type="text/javascript">
    let listForm = ['form1', 'form2']
    let attributesOnPage = {
        attributes: [],
        categories: [],
        brands: []
    }
    <%-- Get Size and Color --%>
    <c:forEach var="attribute" items="${model.attributes}">
    <c:choose>
    <c:when test="${attribute.attributeName == 'Size'}">
    var attributes = {
        ID: "",
        attributeName: "",
        attributeValues: []
    };
    attributes.ID = "${attribute.ID}";
    attributes.attributeName = "${attribute.attributeName}";
    <c:forEach var="attributeValue" items="${attribute.attributeValues}">
    var attributeValues = {};
    attributeValues["attributeValueID"] = "${attributeValue.attributeValueID}";
    attributeValues["valueName"] = "${attributeValue.valueName}";
    attributes.attributeValues.push(attributeValues);
    </c:forEach>
    attributesOnPage.attributes.push(attributes);
    let sizeName = attributes.attributeValues.map(({valueName}) => valueName);
    </c:when>
    <c:otherwise>
    var attributes = {
        ID: "",
        attributeName: "",
        attributeValues: []
    };
    attributes.ID = "${attribute.ID}";
    attributes.attributeName = "${attribute.attributeName}";
    <c:forEach var="attributeValue" items="${attribute.attributeValues}">
    var attributeValues = {};
    attributeValues["attributeValueID"] = "${attributeValue.attributeValueID}";
    attributeValues["valueName"] = "${attributeValue.valueName}";
    attributes.attributeValues.push(attributeValues);
    </c:forEach>
    attributesOnPage.attributes.push(attributes);
    let colorName = attributes.attributeValues.map(({valueName}) => valueName);
    </c:otherwise>
    </c:choose>
    </c:forEach>
    <%-- Get Size and Color --%>

    <%-- Get Brand --%>
    <c:forEach var="brand" items="${model.brands}">
    var brand = {};
    brand["brandID"] = "${brand.brandID}";
    brand["brandName"] = "${brand.brandName}"
    attributesOnPage.brands.push(brand)
    </c:forEach>
    let brandName = attributesOnPage.brands.map(({brandName}) => brandName);
    <%-- Get Brand --%>

    <%-- Get Type Category --%>
    <c:forEach var="category" items="${model.categories}">
    var category = {};
    category["ID"] = "${category.ID}";
    category["categoryName"] = "${category.categoryName}"
    attributesOnPage.categories.push(category)
    </c:forEach>
    let categoryName = attributesOnPage.categories.map(({categoryName}) => categoryName);
    <%-- Get Type Category --%>
    $(document).ready(function () {
        $('#typeCategory').select2({
            tags: true,
            data: categoryName,
            closeOnSelect: true,
            tokenSeparators: [','],
            placeholder: "Add category here",

        });
        $('#size').select2({
            tags: true,
            data: sizeName,
            closeOnSelect: true,
            tokenSeparators: [','],
            placeholder: "Add size here",
        });
        $('#color').select2({
            tags: true,
            data: colorName,
            closeOnSelect: true,
            tokenSeparators: [','],
            placeholder: "Add color here",
        });
        $('#brand').select2({
            tags: false,
            data: brandName,
            closeOnSelect: true,
        });
        // $('#btnSave').click(function () {
        //
        //     var productDTO = {
        //         listAttributeProduct: {
        //             attributes: [],
        //             categories: [],
        //             brands: []
        //         },
        //         productName : "",
        //         price : ""
        //     }
        //     productDTO.productName = document.getElementById("productName").value;
        //     productDTO.price = document.getElementById("price").value;
        //     getAttributes('Size');
        //     getAttributes('Color');
        //     $.each($("#brand option:selected"), function () {
        //         var brand = attributesOnPage.brands.find(obj =>{return obj.brandName === $(this).val()});
        //         productDTO.listAttributeProduct.brands.push(brand);
        //     })
        //     $.each($("#typeCategory option:selected"), function () {
        //         var category = attributesOnPage.categories.find(obj =>{return obj.categoryName === $(this).val()});
        //         productDTO.listAttributeProduct.categories.push(category);
        //     })
        //     console.log(JSON.stringify(productDTO))
        //
        //     // function get Color and Size be chosen
        //     function getAttributes(attributeName) {
        //         for (var i = 0;i < attributesOnPage.attributes.length; i++) {
        //             if (attributesOnPage.attributes[i].attributeName === attributeName) {
        //                 var attributes = {
        //                     ID: "",
        //                     attributeName: "",
        //                     attributeValues: []
        //                 };
        //                 attributes.ID = attributesOnPage.attributes[i].ID;
        //                 attributes.attributeName = attributesOnPage.attributes[i].attributeName;
        //                 if (attributeName ==='Color'){
        //                     $.each($("#color option:selected"), function () {
        //                         var attributeValues = {} = attributesOnPage.attributes[i].attributeValues.find(obj => {return obj.valueName === $(this).val()});
        //                         attributes.attributeValues.push(attributeValues);
        //                     })
        //                 }else {
        //                     $.each($("#size option:selected"), function () {
        //                         var attributeValues = {} = attributesOnPage.attributes[i].attributeValues.find(obj => {return obj.valueName === $(this).val()});
        //                         attributes.attributeValues.push(attributeValues);
        //                     })
        //                 }
        //                 productDTO.listAttributeProduct.attributes.push(attributes)
        //             }
        //         }
        //     }
        //     $.ajax({
        //         method:'post',
        //         url:"/Eshopper/admin-addProduct",
        //         data:JSON.stringify(productDTO),
        //         contentType:'application/json; charset=utf-8',
        //         dataType:'json',
        //         success:function (response) {
        //             $('#Save-modalpopup').html(response);
        //             $('#Save-modalPopup').modal('show');
        //         },
        //         error:function (error) {
        //             alert(error);
        //         }
        //     })
        // })
    });

</script>

</html>
