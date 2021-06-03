<%@page import="com.sqa.qldiem.utils.DateFormatUtil"%>
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

        <script>
            function myFunction() {
                var input, filter, table, tr, td1, td2, i, txtValue1, txtValue2;
                input = document.getElementById("myInput");
                filter = input.value.toUpperCase();
                table = document.getElementById("myTable");
                tr = table.getElementsByTagName("tr");
                for (i = 0; i < tr.length; i++) {
                    td1 = tr[i].getElementsByTagName("td")[1];
                    td2 = tr[i].getElementsByTagName("td")[2];
                    if (td1 || td2) {
                        txtValue1 = td1.textContent || td1.innerText;
                        txtValue2 = td2.textContent || td2.innerText;
                        if (txtValue1.toUpperCase().indexOf(filter) > -1 || txtValue2.toUpperCase().indexOf(filter) > -1) {
                            tr[i].style.display = "";
                        } else {
                            tr[i].style.display = "none";
                        }
                    }
                }
            }
        </script>
    </head>
    <body>
        <c:if test="${not empty LISTPOINT}">
            <%
                List<PointModel> listPoint = (List<PointModel>) session.getAttribute("LISTPOINT");
                SessionUtil.getInstance().removeValue(request, "LISTPOINT");
                SubjectModel subject = listPoint.get(0).getSubclass().getSubject();
            %>
            <input type="text" class="form-control" id="myInput" onkeyup="myFunction()" placeholder="Tìm kiếm theo tên hoặc mã...">
            <table id="myTable">
                <tr class="header">
                    <th style="width: 20px">STT</th>
                    <th>Mã</th>
                    <th>Họ tên</th>
                    <th>Ngày sinh</th>
                    <th>Giới tính</th>
                    <th>Khoa</th>
                    <th>Lớp</th>
                    <th id="p1">Điểm CC (<%= subject.getPoint1()%>%)</th>
                    <th id="p2">Điểm BT (<%= subject.getPoint2()%>%)</th>
                    <th id="p3">Điểm TH (<%= subject.getPoint3()%>%)</th>
                    <th id="p4">Điểm KTHP (<%= subject.getPoint4()%>%)</th>
                    <th>Tổng kết</th>
                    <th>Điểm chữ</th>
                </tr>

                <%
                    int index = 0;
                    for (PointModel point : listPoint) {
                        UserModel user = point.getUser();
                %>
                <tr>
                    <td><%= ++index%></td>
                    <td><%= user.getUserName()%></td>
                    <td><%= user.getFullName()%></td>
                    <td><%= DateFormatUtil.format(user.getDateOfBirth())%></td>
                    <td><%= user.getGender() == 1 ? "Nam" : "Nữ"%></td>
                    <td><%= user.getFaculty()%></td>
                    <td><%= user.getClassroom()%></td>
                    <td><%= point.getPoint1()%></td>
                    <td><%= point.getPoint2()%></td>
                    <td><%= point.getPoint3()%></td>
                    <td><%= point.getPoint4()%></td>
                    <td><%= point.getAvgPoint()%></td>
                    <td><%= point.getResult()%></td>
                </tr>
                <%
                    }
                %>
            </table>
        </c:if>
    </body>
</html>
