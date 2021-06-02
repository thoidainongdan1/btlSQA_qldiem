<%@page import="com.sqa.qldiem.utils.DateFormatUtil"%>
<%@page import="com.sqa.qldiem.model.ResultModel"%>
<%@page import="com.sqa.qldiem.utils.SessionUtil"%>
<%@page import="com.sqa.qldiem.model.SubjectModel"%>
<%@page import="com.sqa.qldiem.model.PointModel"%>
<%@page import="java.util.List"%>
<%@page import="com.sqa.qldiem.model.UserModel"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/common/lib.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script> 

        <style>
            table {
                border-collapse: collapse;
                border-spacing: 0;
                width: 100%;
                border: 1px solid #ddd;
            }

            th, td {
                text-align: center;
                padding: 16px;
            }

            #myInput {
                margin-bottom: 12px;
            }

            #myTable tr {
                border-bottom: 1px solid #ddd;
            }

            #myTable tr.header, #myTable tr:hover {
                background-color: #ffe6e6;
            }
        </style>
    </head>
    <body>
        <c:if test="${not empty LISTRESULT}">
            <%
                List<ResultModel> listResult = (List<ResultModel>) session.getAttribute("LISTRESULT");
                SessionUtil.getInstance().removeValue(request, "LISTRESULT");
            %>
            <table id="myTable">
                <tr class="header">
                    <th style="width: 20px">STT</th>
                    <th>Mã</th>
                    <th>Họ tên</th>
                    <th>Ngày sinh</th>
                    <th>Giới tính</th>
                    <th>Khoa</th>
                    <th>Lớp</th>
                    <th>Điểm trung bình</th>
                    <th>Xếp loại</th>
                </tr>

                <%
                    int index = 0;
                    for (ResultModel result : listResult) {
                        UserModel user = result.getUser();
                %>
                <tr>
                    <td><%= ++index%></td>
                    <td><%= user.getUserName()%></td>
                    <td><%= user.getFullName()%></td>
                    <td><%= DateFormatUtil.format(user.getDateOfBirth())%></td>
                    <td><%= user.getGender() == 1 ? "Nam" : "Nữ"%></td>
                    <td><%= user.getFaculty()%></td>
                    <td><%= user.getClassroom()%></td>
                    <td><%= result.getPoint()%></td>
                    <td><%= result.getScholarship()%></td>
                </tr>
                <%
                    }
                %>
            </table>
        </c:if>
    </body>
</html>
