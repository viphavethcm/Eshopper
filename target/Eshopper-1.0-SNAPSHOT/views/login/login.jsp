<%--
  Created by IntelliJ IDEA.
  User: asus s510u
  Date: 6/10/2020
  Time: 9:57 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<section id="form"><!--form-->
    <div class="container">
        <div class="row">
            <div class="col-sm-4 col-sm-offset-1">
                <div class="login-form"><!--login form-->
                    <c:if test="${not empty message}">
                        <div class="alert alert-${alert}">
                                ${message}
                        </div>
                    </c:if>
                    <h2>Login to your account</h2>
                    <form action="<c:url value="/user/login"/> " method="post" id="formLogin">
                        <input type="text" placeholder="Username" name="userName">
                        <input type="password" placeholder="Password" name="passWord">
                        <input type="hidden" value="login" name="action"/>
                        <span>
								<input type="checkbox" class="checkbox">
								Keep me signed in
							</span>
                        <button id="btn-login" class="btn btn-default">Login</button>
                    </form>
                </div><!--/login form-->
            </div>
            <div class="col-sm-1">
                <h2 class="or">OR</h2>
            </div>
            <div class="col-sm-4">
                <div class="signup-form"><!--sign up form-->
                    <h2>New User Signup!</h2>
                    <form action="<c:url value="/user/login"/>" id="formSignup" method="post">
                        <input type="text" placeholder="User Name" name="userName">
                        <input type="password" placeholder="Password" name="passWord">
                        <input type="email" placeholder="Email" name="email">
                        <input type="text" placeholder="Full Name" name="fullName">
                        <input type="hidden" value="register" name="action"/>
                        <button id="btn-signup" class="btn btn-default">Signup</button>
                    </form>
                </div><!--/sign up form-->
            </div>
        </div>
    </div>
</section>

<script>
    $(document).ready(function () {
        var action;
        $('#btn-login').click(function () {
            $('#action').val("login");
            $('#formLogin').submit();
        });

        $('#btn-signup').click(function () {
            $('#crudactionRegister').val("signup");
            $('#formSignup').submit();
        });
    });

    function test() {
        return "<h1>abc</h1>"
    }
</script>