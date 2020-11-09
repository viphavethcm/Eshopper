<%--
  Created by IntelliJ IDEA.
  User: asus s510u
  Date: 3/18/2020
  Time: 10:20 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/common/Tablibs.jsp" %>
<div class="modal-dialog">
    <div class="modal-content" style="border: 1px">
        <div class="modal-header" style="background-color: #FE980F;">
            <button class="close" data-dismiss="modal">&times;</button>
            <h4 class="modal-title" align="center">EDIT USER</h4>
        </div>
        <div class="modal-body">
            <div class="row">
                <div class="col-md-6">
                    <div class="form-group">
                        <div class="input-group">
                                <span class="input-group-addon">
                                    <i class="fa fa-user" aria-hidden="true"></i>
                                </span>
                            <input type="text" class="w-90 form-control" value="${user.pojo.userName}"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="fa fa-lock" aria-hidden="true"></i></span>
                            <input type="password" class="form-control" value="${user.pojo.passWord}"/>
                        </div>
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="form-group">
                        <div class="input-group">
                                <span class="input-group-addon">
                                    <i class="fa fa-envelope" aria-hidden="true"></i>
                                </span>
                            <input type="text" class="form-control" value="${user.pojo.email}"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="input-group">
                                <span class="input-group-addon">
                                    <i class="fa fa-map-marker" aria-hidden="true"></i>
                                </span>
                            <input type="text" class="form-control" value="${user.pojo.address}"/>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="modal-footer">
            <button class="btn btn-primary">Save</button>
            <button class="btn btn-primary" data-dismiss="modal">Exit</button>
        </div>
    </div>
</div>


