<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/common/lib.jsp"%>	
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Đăng nhập</title>

        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <link href="<c:url value='/css/loginn.css' />" rel="stylesheet" type="text/css" media="all"/>

        <style>
            h2 {
                font-size: 40px;
                font-weight: bold;
                margin-bottom: 20px;
                color: black;
            }

            .container {
                text-align: center;
            }
        </style>
    </head>
    <body>
        <div class="container">
            <h2>Hệ thống quản lý điểm PTIT</h2>
            <div class="wrapper fadeInDown">
                <div id="formContent">
                    <c:if test="${not empty message}">
                        <div class="alert alert-${alert}" style="text-align: center">
                            ${message}
                        </div>
                    </c:if>
                    <div class="fadeIn first">
                        <img src="image/user.png" id="icon" alt="User Icon" />
                    </div>

                    <form action="<c:url value='/dang-nhap'/>" id="formLogin" method="post">
                        <input type="text" id="userName" class="fadeIn second" name="userName" placeholder="Tên đăng nhập" required>
                        <input type="password" id="password" class="fadeIn third" name="password" placeholder="Mật khẩu" required>
                        <input type="hidden" value="login" name="action"/>
                        <input type="submit" class="fadeIn fourth" value="Đăng nhập">
                    </form>

                    <div id="formFooter">
                        <a class="underlineHover" href="#">Quên mật khẩu?</a>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
