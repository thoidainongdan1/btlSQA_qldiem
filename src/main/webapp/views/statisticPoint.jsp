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
        <script>
            function writeExcel() {

            }
        </script>
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
                    <iframe id="frame" src="views/table/statTable.jsp" width="100%" height="550px" name="the-iFrame" frameborder="0"></iframe>
                </div>
            </div>
            <button class="btn btn-danger center" onclick="ExportToExcel()" <c:if test="${empty LISTRESULT}">disabled</c:if>>Xuất file excel</button>
        </div>

        <script>
            function ExportToExcel() {
                var iframe = document.getElementById("frame");
                var tab = iframe.contentWindow.document.getElementsByTagName("table")[0];
                var tab_text = "<table border='2px'>";
                var textRange;
                var j = 0;

                for (j = 0; j < tab.rows.length; j++)
                {
                    tab_text = tab_text + tab.rows[j].innerHTML + "</tr>";
                    //tab_text=tab_text+"</tr>";
                }

                tab_text = tab_text + "</table>";
                tab_text = tab_text.replace(/<A[^>]*>|<\/A>/g, "");//remove if u want links in your table
                tab_text = tab_text.replace(/<img[^>]*>/gi, ""); // remove if u want images in your table
                tab_text = tab_text.replace(/<input[^>]*>|<\/input>/gi, ""); // reomves input params

                var ua = window.navigator.userAgent;
                var msie = ua.indexOf("MSIE ");

                if (msie > 0 || !!navigator.userAgent.match(/Trident.*rv\:11\./))      // If Internet Explorer
                {
                    txtArea1.document.open("txt/html", "replace");
                    txtArea1.document.write(tab_text);
                    txtArea1.document.close();
                    txtArea1.focus();
                    sa = txtArea1.document.execCommand("SaveAs", true, "table.xls");
                } else                 //other browser not tested on IE 11
                    sa = window.open('data:application/vnd.ms-excel,' + encodeURIComponent(tab_text));

                return (sa);
            }
        </script>
    </body>
</html>
