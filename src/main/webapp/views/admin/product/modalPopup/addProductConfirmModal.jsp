<%--
  Created by IntelliJ IDEA.
  User: asus s510u
  Date: 7/13/2020
  Time: 1:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/Tablibs.jsp" %>
<html>
<div class="modal-dialog">
    <div class="modal-content" style="border-radius: 5px;">
        <div class="modal-body" id="">
            <h2 style="text-align: center;">Save SuccessFull</h2>
        </div>
        <div class="modal-footer">
            <button class="btn btn-danger" id="btnClose" data-dismiss="modal">Close</button>
        </div>
    </div>
</div>
<script type="text/javascript">
    $(document).ready(function () {
        $('#btnClose').click(function () {
            window.location.href = ${pageContext.request.contextPath}+"/admin-update-productImage";
        })
    })
</script>
</html>
