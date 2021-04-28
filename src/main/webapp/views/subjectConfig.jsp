<%@page import="com.sqa.qldiem.model.SubjectModel"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/common/lib.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
        <title>Cấu hình môn học</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="css/user.css">

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
            $(document).ready(function () {
                $('.td_btn').click(function () {
                    var $row = $(this).closest('tr');
                    var name = $row.find('.td_name').text();
                    var quantity = $row.find('.td_quantity').text();
                    var point1 = $row.find('.td_point1').text();
                    var point2 = $row.find('.td_point2').text();
                    var point3 = $row.find('.td_point3').text();
                    var point4 = $row.find('.td_point4').text();
                    $('#frm_name').val(name);
                    $('#name').val(name);
                    $('#frm_quantity').val(quantity);
                    $('#frm_point1').val(point1);
                    $('#frm_point2').val(point2);
                    $('#frm_point3').val(point3);
                    $('#frm_point4').val(point4);
                    $('#myModal').modal('show');
                });
            });

            function myFunction() {
                var input, filter, table, tr, td, i, txtValue;
                input = document.getElementById("myInput");
                filter = input.value.toUpperCase();
                table = document.getElementById("myTable");
                tr = table.getElementsByTagName("tr");
                for (i = 0; i < tr.length; i++) {
                    td = tr[i].getElementsByTagName("td")[1];
                    if (td) {
                        txtValue = td.textContent || td.innerText;
                        if (txtValue.toUpperCase().indexOf(filter) > -1) {
                            tr[i].style.display = "";
                        } else {
                            tr[i].style.display = "none";
                        }
                    }
                }
            }

            function submitForm() {
                var point1 = parseInt($('#frm_point1').val());
                var point2 = parseInt($('#frm_point2').val());
                var point3 = parseInt($('#frm_point3').val());
                var point4 = parseInt($('#frm_point4').val());
                if (point1 + point2 + point3 + point4 !== 100) {
                    alert("Lỗi: Tổng % 4 đầu điểm phải là 100%!!!")
                } else {
                    document.updateForm.submit();
                    alert("Sửa thành công");
                }
            }
        </script>
    </head>
    <body>
        <%@include file="/common/header.jsp"%>
        <div class="container-fluid" style="text-align: center">
            <div class="panel panel-primary">
                <div class="panel-heading">
                    <h1 class="title">Cấu hình môn học</h1>
                    <br>
                </div>
                <br>
                <div class="panel-body">
                    <input type="text" class="form-control" id="myInput" onkeyup="myFunction()" placeholder="Tìm kiếm theo tên môn học...">
                    <table id="myTable">
                        <tr class="header">
                            <th style="width: 20px">STT</th>
                            <th>Tên môn học</th>
                            <th>Số tín chỉ</th>
                            <th>Điểm CC (%)</th>
                            <th>Điểm BT (%)</th>
                            <th>Điểm TH (%)</th>
                            <th>Điểm KTHP (%)</th>
                            <th width="60px"></th>
                        </tr>
                        <c:if test="${not empty LISTSUBJECT}">
                            <%
                                List<SubjectModel> listSubject = (List<SubjectModel>) session.getAttribute("LISTSUBJECT");
                                int index = 0;

                                for (SubjectModel subject : listSubject) {
                            %>
                            <tr>
                                <td class="td_id"><%= ++index%></td>
                                <td class="td_name"><%= subject.getName()%></td>
                                <td class="td_quantity"><%= subject.getQuantity()%></td>
                                <td class="td_point1"><%= subject.getPoint1()%></td>
                                <td class="td_point2"><%= subject.getPoint2()%></td>
                                <td class="td_point3"><%= subject.getPoint3()%></td>
                                <td class="td_point4"><%= subject.getPoint4()%></td>
                                <td>
                                    <button class="td_btn btn btn-primary"><i class="fa fa-edit"></i></button>
                                </td>
                            </tr>
                            <%
                                }
                            %>
                        </c:if>
                    </table>
                </div>
            </div>
        </div>
    </body>

    <div class="modal fade" id="myModal"  tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                </div>
                <div class="modal-body">

                    <form name="updateForm" action='<c:url value="/giaovu-cauhinh"/>' method="post" class="form">
                        <div class="form-group">
                            <label for="name">Tên môn học</label>
                            <input type="text" class="form-control" id="frm_name" disabled>
                        </div>
                        <div class="form-group">
                            <label for="quantity">Số tín chỉ</label>
                            <input type="text" class="form-control" name="quantity" id="frm_quantity">
                        </div>
                        <div class="form-group">
                            <label for="point1">Điểm CC (%)</label>
                            <input type="text" class="form-control" name="point1" id="frm_point1">
                        </div>
                        <div class="form-group">
                            <label for="point2">Điểm BT (%)</label>
                            <input type="text" class="form-control" name="point2" id="frm_point2">
                        </div>
                        <div class="form-group">
                            <label for="point3">Điểm TH (%)</label>
                            <input type="text" class="form-control" name="point3" id="frm_point3">
                        </div>
                        <div class="form-group">
                            <label for="point4">Điểm KTHP (%)</label>
                            <input type="text" class="form-control" name="point4" id="frm_point4">
                        </div>
                        <input type="hidden" name="name" id="name">
                        <button type="button" class="btn btn-primary" onclick="submitForm()">Lưu thay đổi</button>
                    </form>

                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                </div>
            </div>
        </div>
    </div>
</html>

