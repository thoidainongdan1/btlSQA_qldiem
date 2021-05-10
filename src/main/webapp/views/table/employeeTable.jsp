<%@page import="com.sqa.qldiem.utils.DateFormatUtil"%>
<%@page import="com.sqa.qldiem.utils.SessionUtil"%>
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
            function update(action, username, user) {
                window.top.location.href = '<c:url value="/giaovu-capnhatnguoidung" />' + '?action=' + action + "&username=" + username;
            }

            function findByName() {
                var input, filter, table, tr, td1, td2, i, txtValue1, txtValue2;
                input = document.getElementById("name");
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
        <input type="text" class="form-control" id="name" onkeyup="findByName()" placeholder="Tìm kiếm theo tên hoặc mã..." style="margin-top: 5px; margin-bottom: 10px;">
        <table id="myTable">
            <tr class="header">
                <th style="width: 20px">STT</th>
                <th>Mã</th>
                <th>Họ tên</th>
                <th>Ngày sinh</th>
                <th>Giới tính</th>
                <th>Địa chỉ</th>
                <th>Số điện thoại</th>
                <th>Chức vụ</th>
                <th width="60px"></th>
                <th width="60px"></th>
            </tr>
            <c:if test="${not empty LISTEMPLOYEE}">
                <%
                    List<UserModel> listUser = (List<UserModel>) session.getAttribute("LISTEMPLOYEE");
                    int index = 0;

                    for (UserModel user : listUser) {
                        String gender = user.getGender() == 1 ? "Nam" : "Nữ";
                %>
                <tr>
                    <td><%= ++index%></td>
                    <td><%= user.getUserName()%></td>
                    <td><%= user.getFullName()%></td>
                    <td><%= DateFormatUtil.format(user.getDateOfBirth()) %></td>
                    <td><%= gender%></td>
                    <td><%= user.getAddress()%></td>
                    <td><%= user.getPhone()%></td>
                    <td>Giáo vụ</td>
                    <td>
                        <button type="submit" class="btn btn-primary" onclick="update('addUserForm', '<%= user.getUserName()%>')"><i class="fa fa-edit"></i></button>
                    </td>
                    <td>
                        <form action='<c:url value="/giaovu-capnhatnguoidung"/>' method="post" id="deleteForm">
                            <input type="hidden" name="username" value="<%= user.getUserName()%>" />
                            <input type="hidden" name="action" value="removeUser" />
                            <button type="submit" onclick="return confirm('Bạn có chắc chắn muốn xoá?') && alert('Xoá thành công')" class="btn btn-danger"><i class="fa fa-trash"></i></button>
                        </form>
                    </td>
                </tr>
                <%
                    }
                %>
            </c:if>
        </table>
    </body>
</html>
