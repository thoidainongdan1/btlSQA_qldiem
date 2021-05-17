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
                width: 100px;
                float : right;
            }
            
            .tab {
                overflow: hidden;
                border: 1px solid #ccc;
                background-color: #f1f1f1;
                margin-bottom: 5px;
            }

            .tab button {
                background-color: inherit;
                float: left;
                border: none;
                outline: none;
                cursor: pointer;
                padding: 14px 16px;
                transition: 0.3s;
            }

            .tab button:hover {
                background-color: #ddd;
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
                    <br><br>

                    <div class="tab">
                        <button id="bt1" class="tablinks" onclick="openTab(1)">Giáo vụ</button>
                        <button id="bt2" class="tablinks" onclick="openTab(2)">Giảng viên</button>
                        <button id="bt3" class="tablinks" onclick="openTab(3)">Sinh viên</button>
                    </div>

                    <c:if test="${TABSELECTED == 1}">
                        <iframe src="views/table/employeeTable.jsp" width="100%" height="550px" frameborder="0"></iframe>
                    </c:if>

                    <c:if test="${TABSELECTED == 2}">
                        <iframe src="views/table/lecturerTable.jsp" width="100%" height="550px" frameborder="0"></iframe>
                    </c:if>

                    <c:if test="${TABSELECTED == 3}">
                        <iframe src="views/table/studentTable.jsp" width="100%" height="550px" frameborder="0"></iframe>
                    </c:if>    
                </div>
            </div>
        </div>           
        <script>
            function openTab(roleId) {
                if (roleId != ${TABSELECTED}) {
                    window.location.href = '<c:url value="giaovu-quanlynguoidung?tab=" />' + roleId;
                }
            }
        </script> 

        <script>
            window.onload = function () {
                if (${not empty TABSELECTED}) {
                    $("#bt" +${TABSELECTED}).click();
                    $("#bt" +${TABSELECTED}).css("background", "#ccc");
                }
                
                $(".alert").fadeOut(2000);
            };
        </script>
    </body>
</html>
