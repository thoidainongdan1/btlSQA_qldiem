<%@page import="com.sqa.qldiem.utils.SessionUtil"%>
<%@page import="java.util.List"%>
<%@page import="com.sqa.qldiem.model.UserModel"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/common/lib.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
        <title>Thống kê</title>

        <link rel="stylesheet" href="css/user.css"> 
        <style>
            select {
                width: 100px;
            }

            .btn-primary {
                float: right;
            }

            .center {
                display: flex;
                justify-content: center;
                margin-bottom: 15px;
                margin-top: 10px;
            }
        </style>
    </head>
    <body>
        <%@include file="/common/header.jsp"%>
        <div class="container-fluid" style="text-align: center">
            <div class="panel panel-primary">
                <div class="panel-heading">
                    <h1 class="title">Thống kê điểm</h1>
                    <br>
                    <form method="get" action='<c:url value="/giaovu-thongke"/>'>
                        <div class="row">

                            <c:if test="${empty SEMESTER}">
                                <div class="form-group col-md-4">
                                    <select class="form-control" name="semester" required>
                                        <option value="" disabled selected>Chọn kì học</option>
                                        <option>Kì 1 năm 2020-2021</option>
                                        <option>Kì 2 năm 2020-2021</option>
                                    </select>
                                </div>
                                <div class="form-group col-md-4">
                                    <select class="form-control" name="faculty" required>
                                        <option value="" disabled selected>Chọn khoa</option>
                                        <option>CNTT</option>
                                        <option>HTTT</option>
                                    </select>
                                </div>
                                <div class="form-group col-md-3">
                                    <input class="form-control" type="text" name="quantity" placeholder="Nhập số lượng..." required />
                                </div>
                            </c:if>

                            <c:if test="${not empty SEMESTER}">
                                <%
                                    String semester = (String) session.getAttribute("SEMESTER");
                                    String faculty = (String) session.getAttribute("FACULTY");
                                    int quantity = (Integer) session.getAttribute("QUANTITY");
                                    SessionUtil.getInstance().removeValue(request, "SEMESTER");
                                    SessionUtil.getInstance().removeValue(request, "FACULTY");
                                    SessionUtil.getInstance().removeValue(request, "QUANTITY");
                                %>
                                <div class="form-group col-md-4">
                                    <select class="form-control" name="semester">
                                        <%
                                            String semesterList[] = {"Kì 1 năm 2020-2021", "Kì 2 năm 2020-2021"};
                                            for (int i = 0; i < 2; i++) {
                                                if (semester.equals(semesterList[i])) {
                                        %>
                                        <option selected><%= semester%></option>
                                        <%
                                        } else {
                                        %>
                                        <option><%= semesterList[i]%></option>
                                        <%
                                                }
                                            }
                                        %>
                                    </select>
                                </div>

                                <div class="form-group col-md-4">
                                    <select class="form-control" name="faculty">
                                        <%
                                            String facultyList[] = {"CNTT", "HTTT"};
                                            for (int i = 0; i < 2; i++) {
                                                if (faculty.equals(facultyList[i])) {
                                        %>
                                        <option selected><%= faculty%></option>
                                        <%
                                        } else {
                                        %>
                                        <option><%= facultyList[i]%></option>
                                        <%
                                                }
                                            }
                                        %>
                                    </select>
                                </div>
                                    
                                <div class="form-group col-md-3">
                                    <input class="form-control" type="text" name="quantity" placeholder="Nhập số lượng..." value="<%=quantity%>" required />
                                </div>
                            </c:if>

                            <input type="hidden" name="action" value="stat">
                            <div class="col-md-1"><input type="submit" class="btn btn-primary" value="Tìm kiếm"></div>
                        </div>
                    </form>
                </div>
                <br>
                <div class="panel-body">
                    <iframe src="views/table/statTable.jsp" width="100%" height="550px" name="the-iFrame" frameborder="0"></iframe>
                </div>
            </div>
            <button class="btn btn-danger center">Xuất file excel</button>
        </div>

    </body>
</html>
