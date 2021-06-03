<%@page import="com.sqa.qldiem.utils.SessionUtil"%>
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
            
            .btn-success {
                width: 100px;
                float : right;
            }
        </style>

        <script>
            $(document).ready(function () {
                $('.btn_add').click(function () {
                    $('#frm_name').val('');
                    $('#name').val('');
                    $('#frm_quantity').val('');
                    $('#frm_point1').val('');
                    $('#frm_point2').val('');
                    $('#frm_point3').val('');
                    $('#frm_point4').val('');
                    $('#frm_name').prop("disabled", false);
                    $('#frm_name').prop("required", true);
                    document.getElementById('frm_title').innerHTML = "Thêm môn học";
                    $('#action').val("add");
                    $('#myModal').modal('show');
                });
                
                $('.td_btn_edit').click(function () {
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
                    $('#frm_name').prop("disabled", true);
                    document.getElementById('frm_title').innerHTML = "Sửa môn học";
                    $('#action').val("update");
                    $('#myModal').modal('show');
                });

                $("form[name=updateForm]").submit(function (event) {
                    var quantity = parseInt($('#frm_quantity').val());
                    var point1 = parseInt($('#frm_point1').val());
                    var point2 = parseInt($('#frm_point2').val());
                    var point3 = parseInt($('#frm_point3').val());
                    var point4 = parseInt($('#frm_point4').val());
                    
                    $('#frm_quantity').val(quantity);
                    $('#frm_point1').val(point1);
                    $('#frm_point2').val(point2);
                    $('#frm_point3').val(point3);
                    $('#frm_point4').val(point4);

                    if (point1 + point2 + point3 + point4 !== 100) {
                        alert("Lỗi: Tổng % 4 đầu điểm phải bằng 100%!");
                        return false;
                    }
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

        </script>
    </head>
    <body>
        <%@include file="/common/header.jsp"%>
        <div class="container-fluid" style="text-align: center; margin-bottom: 50px;">
            <div class="panel panel-primary">
                <div class="panel-heading">
                    <h1 class="title">Cấu hình môn học</h1>
                    <br>
                </div>
                <br>
                <div class="panel-body">
                    <button class="btn_add btn btn-success">Thêm</button>
                    <br><br> 
                    <c:if test="${not empty message_success}">
                        <div class="alert alert-success" style="text-align: center">${message_success}</div>
                        <%
                            SessionUtil.getInstance().removeValue(request, "message_success");
                        %>
                    </c:if>
                    <c:if test="${not empty message_error}">
                        <div class="alert alert-danger" style="text-align: center">${message_error}</div>
                        <%
                            SessionUtil.getInstance().removeValue(request, "message_error");
                        %>
                    </c:if>
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
                            <th width="60px"></th>
                        </tr>
                        <c:if test="${not empty LISTSUBJECT}">
                            <%
                                List<SubjectModel> listSubject = (List<SubjectModel>) session.getAttribute("LISTSUBJECT");
                                int index = 0;

                                for (SubjectModel subject : listSubject) {
                            %>
                            <tr class="body">
                                <td class="td_id"><%= ++index%></td>
                                <td class="td_name"><%= subject.getName()%></td>
                                <td class="td_quantity"><%= subject.getQuantity()%></td>
                                <td class="td_point1"><%= subject.getPoint1()%></td>
                                <td class="td_point2"><%= subject.getPoint2()%></td>
                                <td class="td_point3"><%= subject.getPoint3()%></td>
                                <td class="td_point4"><%= subject.getPoint4()%></td>
                                <td>
                                    <button class="td_btn_edit btn btn-primary"><i class="fa fa-edit"></i></button>
                                </td>
                                <td>
                                    <form action='<c:url value="/giaovu-cauhinh"/>' method="post" id="deleteForm">
                                        <input type="hidden" name="name" value="<%= subject.getName()%>" />
                                        <input type="hidden" name="action" value="delete" />
                                        <button type="submit" onclick="return confirm('Bạn có chắc chắn muốn xoá?')" class="btn btn-danger"><i class="fa fa-trash"></i></button>
                                    </form>
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
                    <h3 style="text-align: center" id="frm_title">Thông tin môn học</h3>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                </div>
                <div class="modal-body">

                    <form name="updateForm" action='<c:url value="/giaovu-cauhinh"/>' method="post" class="form">
                        <div class="form-group">
                            <label for="name">Tên môn học</label>
                            <input type="text" class="form-control" name="name" id="frm_name">
                        </div>
                        <div class="form-group">
                            <label for="quantity">Số tín chỉ</label>
                            <input type="number" class="form-control" name="quantity" id="frm_quantity" min="1" required>
                        </div>
                        <div class="form-group">
                            <label for="point1">Điểm CC (%)</label>
                            <input type="number" class="form-control" name="point1" id="frm_point1" min="0" max="100" required>
                        </div>
                        <div class="form-group">
                            <label for="point2">Điểm BT (%)</label>
                            <input type="number" class="form-control" name="point2" id="frm_point2" min="0" max="100" required>
                        </div>
                        <div class="form-group">
                            <label for="point3">Điểm TH (%)</label>
                            <input type="number" class="form-control" name="point3" id="frm_point3" min="0" max="100" required>
                        </div>
                        <div class="form-group">
                            <label for="point4">Điểm KTHP (%)</label>
                            <input type="number" class="form-control" name="point4" id="frm_point4" min="0" max="100" required>
                        </div>
                        <input type="hidden" name="name" id="name">
                        <input type="hidden" name="action" id="action">
                        <input type="submit" class="btn btn-success btn_save" value="Lưu" onclick="submitForm()">
                    </form>
                </div>
            </div>
        </div>
    </div>
</html>

