<%@page import="com.sqa.qldiem.utils.SessionUtil"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/common/lib.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
        <title>Quản lý người dùng</title>

        <link rel="stylesheet" href="css/user.css">
        <style>
            .btn-success {
                width : 100px;
            }
        </style>
    </head>
    <body>
        <%@include file="/common/header.jsp"%>
        <div class="container-fluid">
            <div class="panel panel-primary">
                <div class="panel-heading">
                    <h1 class="title">Quản lý người dùng</h1>
                </div>
                <div class="panel-body">
                    <form action='<c:url value="/giaovu-capnhatnguoidung"/>' method="get">
                        <input type='hidden' name="action" value="addUserForm" />
                        <input type="submit" class="btn btn-success" value="Thêm" />
                    </form>
                    <br>
                    <c:if test="${not empty message}">
                        <div class="alert alert-success" style="text-align: center">${message}</div>
                        <%
                            SessionUtil.getInstance().removeValue(request, "message");
                        %>
                    </c:if>
                    <iframe src="views/table/userTable.jsp" width="100%" height="550px" name="the-iFrame" frameborder="0"></iframe>
                </div>
            </div>
        </div>

        <%@include file="/common/footer.jsp"%>
    </body>
</html>
