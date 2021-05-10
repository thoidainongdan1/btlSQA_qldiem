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

            .tab {
                overflow: hidden;
                border: 1px solid #ccc;
                background-color: #f1f1f1;
            }

            .tab button {
                background-color: inherit;
                float: left;
                border: none;
                outline: none;
                cursor: pointer;
                padding: 14px 16px;
                transition: 0.3s;
                font-size: 17px;
            }

            .tab button:hover {
                background-color: #ddd;
            }

            .tab button.active {
                background-color: #ccc;
            }

            .tabcontent {
                display: none;
                padding: 6px 12px;
                border: 1px solid #ccc;
                border-top: none;
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

                            <div class="tab">
                                <button class="tablinks" onclick="openTab(event, 1)">Giáo vụ</button>
                                <button class="tablinks" onclick="openTab(event, 2)">Giảng viên</button>
                                <button class="tablinks" onclick="openTab(event, 3)">Sinh viên</button>
                            </div>
                            <div id="1" class="tabcontent">
                                <iframe src="views/table/employeeTable.jsp" width="100%" height="550px" name="the-iFrame" frameborder="0"></iframe>
                            </div>
                            <div id="2" class="tabcontent">
                                <iframe src="views/table/lecturerTable.jsp" width="100%" height="550px" name="the-iFrame" frameborder="0"></iframe>
                            </div>
                            <div id="3" class="tabcontent">
                                <iframe src="views/table/studentTable.jsp" width="100%" height="550px" name="the-iFrame" frameborder="0"></iframe>
                            </div>
                        </div>
                    </div>
                </div>           
                <script>
                    function openTab(evt, roleId) {
                        var i, tabcontent, tablinks;
                        tabcontent = document.getElementsByClassName("tabcontent");
                        for (i = 0; i < tabcontent.length; i++) {
                            tabcontent[i].style.display = "none";
                        }
                        tablinks = document.getElementsByClassName("tablinks");
                        for (i = 0; i < tablinks.length; i++) {
                            tablinks[i].className = tablinks[i].className.replace(" active", "");
                        }
                        document.getElementById(roleId).style.display = "block";
                        evt.currentTarget.className += " active";
                    }
                </script> 
            </body>
        </html>
