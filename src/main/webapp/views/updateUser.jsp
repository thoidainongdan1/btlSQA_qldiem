<%@page import="com.sqa.qldiem.utils.SessionUtil"%>
<%@page import="com.sqa.qldiem.model.UserModel"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/common/lib.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <c:if test="${not empty USERUPDATE}">
            <title>Sửa người dùng</title>
        </c:if>
        <c:if test="${empty USERUPDATE}">
            <title>Thêm người dùng</title>
        </c:if>

        <link rel="stylesheet" href="css/user.css">
        <style>
            .btn-toolbar {
                margin-bottom: 15px;
            }
            
            .btn-success {
                width: 100px;
                margin-right: 15px;
            }
            
            .btn-dark {
                width: 100px;
            }
            
            form .error {
                color: #ff0000;
            }
        </style>

        <script>
            function back() {
                window.top.location.href = '<c:url value="/giaovu-quanlynguoidung" />';
            }
        </script>
    </head>
    <body>
        <%@include file="/common/header.jsp" %>
        <div class="container">
            <div class="panel panel-primary">
                <div class="panel-heading">
                    <c:if test="${not empty USERUPDATE}">
                        <h2 class="text-center title">Sửa người dùng</h2>
                    </c:if>
                    <c:if test="${empty USERUPDATE}">
                        <h2 class="text-center title">Thêm người dùng</h2>
                    </c:if>
                    <br>
                </div>
                <div class="panel-body">
                    <form action='<c:url value="/giaovu-capnhatnguoidung"/>' name="userForm" method="post" accept-charset="utf-8">
                        <c:if test="${not empty USERUPDATE}">
                            <%
                                UserModel user = (UserModel) session.getAttribute("USERUPDATE");
                                session.setAttribute("GENDER", user.getGender());
                            %>
                            <div class="form-group row">
                                <label class="col-md-2">Họ tên: <span>*</span></label>
                                <input type="text" class="form-control col-md-10" name="fullName" value="<%= user.getFullName()%>" required>
                            </div>
                            <br>
                            <div class="form-group row">
                                <label class="col-md-2">Ngày sinh: <span>*</span></label>
                                <input type="date" class="form-control col-md-10" name="dateOfBirth" value="<%= user.getDateOfBirth()%>" required>
                            </div>
                            <br>
                            <div class="form-group row">
                                <label class="col-md-2">Giới tính: <span>*</span></label>
                                <div class="col-md-10">
                                    <c:if test="${GENDER == 1}">
                                        <input type="radio" name="gender" value="1" checked>
                                        <label for="male">Nam</label>
                                        <input type="radio" name="gender" value="0" style="margin-left: 20px">
                                        <label for="female">Nữ</label>
                                    </c:if>
                                    <c:if test="${GENDER == 0}">
                                        <input type="radio" name="gender" value="1">
                                        <label for="male">Nam</label>
                                        <input type="radio" name="gender" value="0" style="margin-left: 20px" checked>
                                        <label for="female">Nữ</label>
                                    </c:if>
                                </div>
                            </div>
                            <br>
                            <div class="form-group row">
                                <label class="col-md-2">Địa chỉ: <span>*</span></label>
                                <input type="text" class="form-control col-md-10" name="address" value="<%= user.getAddress()%>" required>
                            </div>
                            <br>
                            <div class="form-group row">
                                <label class="col-md-2">Số điện thoại: <span>*</span></label>
                                <input type="text" class="form-control col-md-10" name="phone" value="<%= user.getPhone()%>" required>
                            </div>
                            <br>
                            <div class="form-group row">
                                <label class="col-md-2">Chức vụ: <span>*</span></label>
                                <select class="form-control col-md-10" name="roleId">
                                    <%
                                        String roleList[] = {"Giáo vụ", "Giảng viên", "Sinh viên"};
                                        for (int i = 1; i <= 3; i++) {
                                            if (i == user.getRoleId()) {
                                    %>
                                    <option value="<%= i%>" selected><%= roleList[i - 1]%></option>
                                    <%
                                    } else {
                                    %>
                                    <option value="<%= i%>"><%= roleList[i - 1]%></option>
                                    <%
                                            }
                                        }
                                    %>
                                </select>
                            </div>
                            <br>
                            <div class="form-group row">
                                <label class="col-md-2">Khoa:</label>
                                <%
                                    if(user.getFaculty().equals("")) {
                                %>
                                <select class="form-control col-md-10" name="faculty" disabled>
                                <%
                                    } else {
                                %>
                                <select class="form-control col-md-10" name="faculty">
                                <%
                                    }
                                %>
                                    <%
                                        if (!user.getFaculty().equals("")) {
                                    %>
                                    <option disabled value="">Chọn khoa</option>
                                    <%
                                            String facultyList[] = {"HTTT", "CNTT"};
                                            for (String t : facultyList) {
                                                if (t.equals(user.getFaculty())) {
                                    %>
                                    <option selected><%= t%></option>
                                    <%
                                    } else {
                                    %>
                                    <option><%= t%></option>
                                    <%
                                            }
                                        }
                                    } else {
                                    %>
                                    <option disabled value="" selected>Chọn khoa</option>
                                    <option>CNTT</option>
                                    <option>HTTT</option>
                                    <%
                                        }
                                    %>
                                </select>
                            </div>
                            <br>
                            <div class="form-group row">
                                <label class="col-md-2">Lớp:</label>
                                <input type="text" class="form-control col-md-10" disabled name="classroom" value="<%= user.getClassroom() %>">
                            </div>
                            <br>
                            <div class="form-group row">
                                <label class="col-md-2">Mã: <span>*</span></label>
                                <input type="text" class="form-control col-md-10" name="userName" value="<%= user.getUserName()%>" required disabled>
                            </div>
                            <br>
                            <div class="form-group row">
                                <label class="col-md-2">Mật khẩu: <span>*</span></label>
                                <input type="password" class="form-control col-md-10" name="password" value="<%= user.getPassword()%>" required>
                            </div>
                            <br>
                            <input type="hidden" name="action" value="updateUser">
                            <div class="btn-toolbar">
                                <input type="submit" class="btn btn-success" value="Lưu">
                            </c:if>

                            <c:if test="${empty USERUPDATE}">
                                <c:if test="${empty USER}">
                                    <div class="form-group row">
                                        <label class="col-md-2">Họ tên: <span>*</span></label>
                                        <input type="text" class="form-control col-md-10" name="fullName" required>
                                    </div>
                                    <br>
                                    <div class="form-group row">
                                        <label class="col-md-2">Ngày sinh: <span>*</span></label>
                                        <input type="date" class="form-control col-md-10" name="dateOfBirth" required>
                                    </div>
                                    <br>
                                    <div class="form-group row">
                                        <label class="col-md-2">Giới tính: <span>*</span></label>
                                        <div class="col-md-10">
                                            <input type="radio" name="gender" value="1" required>
                                            <label for="male">Nam</label>
                                            <input type="radio" name="gender" value="0" style="margin-left: 20px">
                                            <label for="female">Nữ</label>
                                        </div>
                                    </div>
                                    <br>
                                    <div class="form-group row">
                                        <label class="col-md-2">Địa chỉ: <span>*</span></label>
                                        <input type="text" class="form-control col-md-10" name="address" required>
                                    </div>
                                    <br>
                                    <div class="form-group row">
                                        <label class="col-md-2">Số điện thoại: <span>*</span></label>
                                        <input type="text" class="form-control col-md-10" name="phone" required>
                                    </div>
                                    <br>
                                    <div class="form-group row">
                                        <label class="col-md-2">Chức vụ: <span>*</span></label>
                                        <select class="form-control col-md-10" name="roleId" required>
                                            <option disabled value="" selected>Chọn chức vụ</option>
                                            <option value="3">Sinh viên</option>
                                            <option value="2">Giảng viên</option>
                                            <option value="1">Giáo vụ</option>
                                        </select>
                                    </div>
                                    <br>
                                    <div class="form-group row">
                                        <label class="col-md-2">Khoa:</label>
                                        <select class="form-control col-md-10" name="faculty" disabled>
                                            <option disabled value="" selected>Chọn khoa</option>
                                            <option>CNTT</option>
                                            <option>HTTT</option>
                                        </select>
                                    </div>
                                    <br>
                                    <div class="form-group row">
                                        <label class="col-md-2">Lớp:</label>
                                        <input type="text" class="form-control col-md-10" disabled name="classroom">
                                    </div>
                                    <br>
                                    <div class="form-group row">
                                        <label class="col-md-2">Mã: <span>*</span></label>
                                        <input type="text" class="form-control col-md-10" name="userName" required>
                                    </div>
                                    <br>
                                    <div class="form-group row">
                                        <label class="col-md-2">Mật khẩu: <span>*</span></label>
                                        <input type="password" class="form-control col-md-10" name="password" required>
                                    </div>
                                    <br>
                                    <input type="hidden" name="action" value="addUser">
                                    <div class="btn-toolbar">
                                        <input type="submit" class="btn btn-success" value="Lưu">
                                    </c:if>

                                    <c:if test="${not empty USER}">
                                        <%
                                            UserModel userAddFail = (UserModel) session.getAttribute("USER");
                                            session.setAttribute("GENDER", userAddFail.getGender());
                                        %>
                                        <div class="form-group row">
                                            <label class="col-md-2">Họ tên: <span>*</span></label>
                                            <input type="text" class="form-control col-md-10" name="fullName" value="<%= userAddFail.getFullName()%>" required>
                                        </div>
                                        <br>
                                        <div class="form-group row">
                                            <label class="col-md-2">Ngày sinh: <span>*</span></label>
                                            <input type="date" class="form-control col-md-10" name="dateOfBirth" value="<%= userAddFail.getDateOfBirth()%>" required>
                                        </div>
                                        <br>
                                        <div class="form-group row">
                                            <label class="col-md-2">Giới tính: <span>*</span></label>
                                            <div class="col-md-10">
                                                <c:if test="${GENDER == 1}">
                                                    <input type="radio" name="gender" value="1" checked>
                                                    <label for="male">Nam</label>
                                                    <input type="radio" name="gender" value="0" style="margin-left: 20px">
                                                    <label for="female">Nữ</label>
                                                </c:if>
                                                <c:if test="${GENDER == 0}">
                                                    <input type="radio" name="gender" value="1">
                                                    <label for="male">Nam</label>
                                                    <input type="radio" name="gender" value="0" style="margin-left: 20px" checked>
                                                    <label for="female">Nữ</label>
                                                </c:if>
                                            </div>
                                        </div>
                                        <br>
                                        <div class="form-group row">
                                            <label class="col-md-2">Địa chỉ: <span>*</span></label>
                                            <input type="text" class="form-control col-md-10" name="address" value="<%= userAddFail.getAddress()%>" required>
                                        </div>
                                        <br>
                                        <div class="form-group row">
                                            <label class="col-md-2">Số điện thoại: <span>*</span></label>
                                            <input type="text" class="form-control col-md-10" name="phone" value="<%= userAddFail.getPhone()%>" required>
                                        </div>
                                        <br>
                                        <div class="form-group row">
                                            <label class="col-md-2">Chức vụ: <span>*</span></label>
                                            <select class="form-control col-md-10" name="roleId">
                                                <%
                                                    String roleLists[] = {"Giáo vụ", "Giảng viên", "Sinh viên"};
                                                    for (int i = 1; i <= 3; i++) {
                                                        if (i == userAddFail.getRoleId()) {
                                                %>
                                                <option value="<%= i%>" selected><%= roleLists[i - 1]%></option>
                                                <%
                                                } else {
                                                %>
                                                <option value="<%= i%>"><%= roleLists[i - 1]%></option>
                                                <%
                                                        }
                                                    }
                                                %>
                                            </select>
                                        </div>
                                        <br>
                                        <div class="form-group row">
                                            <label class="col-md-2">Khoa:</label>
                                            <select class="form-control col-md-10" name="faculty" disabled>
                                                <%
                                                    if (!userAddFail.getFaculty().equals("")) {
                                                %>
                                                <option disabled value="">Chọn khoa</option>
                                                <%
                                                        String facultyLists[] = {"HTTT", "CNTT"};
                                                        for (String t : facultyLists) {
                                                            if (t.equals(userAddFail.getFaculty())) {
                                                %>
                                                <option selected><%= t%></option>
                                                <%
                                                } else {
                                                %>
                                                <option><%= t%></option>
                                                <%
                                                        }
                                                    }
                                                } else {
                                                %>
                                                <option disabled value="" selected>Chọn khoa</option>
                                                <option>CNTT</option>
                                                <option>HTTT</option>
                                                <%
                                                    }
                                                %>
                                            </select>
                                        </div>
                                        <br>
                                        <div class="form-group row">
                                            <label class="col-md-2">Lớp:</label>
                                            <input type="text" class="form-control col-md-10" name="classroom" disabled value="<%= userAddFail.getClassroom() %>">
                                        </div>
                                        <br>
                                        <div class="form-group row">
                                            <label class="col-md-2">Mã: <span>*</span></label>
                                            <input type="text" class="form-control col-md-10" name="userName" required autofocus>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-2"></div>
                                            <c:if test="${not empty message}">
                                                <div class="col-md-10" style="color: red; margin-top: 5px;">${message}</div>
                                                <%
                                                    SessionUtil.getInstance().removeValue(request, "message");
                                                %>
                                            </c:if>
                                        </div>
                                        <br>
                                        <div class="form-group row">
                                            <label class="col-md-2">Mật khẩu: <span>*</span></label>
                                            <input type="password" class="form-control col-md-10" name="password" value="<%= userAddFail.getPassword()%>" required>
                                        </div>
                                        <br>
                                        <input type="hidden" name="action" value="addUser">
                                        <div class="btn-toolbar">
                                            <input type="submit" class="btn btn-success" value="Lưu">
                                        </c:if>
                                    </c:if>
                                    <button type="button" class="btn btn-dark" onclick="back()">Trở lại</button>
                                </div>
                                <%
                                    SessionUtil.getInstance().removeValue(request, "USERUPDATE");
                                    SessionUtil.getInstance().removeValue(request, "USER");
                                %>
                                </form>
                            </div>
                        </div>
                </div>
        
        <script>      
            $(document).ready(function () {
                $('select[name="roleId"]').on('change', function() {
                    if(this.value == 1) {
                        $('select[name="faculty"]').prop("disabled", true);
                        $('select[name="faculty"]').val("");
                        $('input[name="classroom"]').prop("disabled", true);
                        $('input[name="classroom"]').val("");
                    } else if(this.value == 2) {
                        $('select[name="faculty"]').prop("disabled", false);
                        $('input[name="classroom"]').prop("disabled", true);
                        $('input[name="classroom"]').val("");
                    } else {
                        $('select[name="faculty"]').prop("disabled", false);
                        $('input[name="classroom"]').prop("disabled", false);
                    }
                });
                
                //validate form
                jQuery.validator.addMethod("noSpace", function (value, element) {
                    return value.indexOf(" ") < 0;
                });
                
                jQuery.validator.addMethod("checkPhone", function (value, element) {
                    var format = /^03[0-9]{8}$/;
                    
                    return value.match(format);
                });

                $("form[name=userForm]").validate({
                    rules: {
                        fullName: {
                            required: true
                        },
                        
                        dateOfBirth: {
                            required: true
                        },
                        
                        gender: {
                            required: true
                        },
                        
                        address: {
                            required: true
                        },
                        
                        phone: {
                            required: true,
                            checkPhone: true
                        },
                        
                        roleId: {
                            required: true
                        },
                        
                        userName: {
                            required: true,
                            noSpace: true
                        },
                        
                        password: {
                            required: true,
                            noSpace: true
                        }
                    },

                    messages: {
                        fullName: {
                            required: "Yêu cầu không bỏ trống họ tên!"
                        },
                        
                        dateOfBirth: {
                            required: "Yêu cầu không bỏ trống ngày sinh!"
                        },
                        
                        gender: {
                            required: "Yêu cầu không bỏ trống giới tính!"
                        },
                        
                        address: {
                            required: "Yêu cầu không bỏ trống địa chỉ!"
                        },
                        
                        phone: {
                            required: "Yêu cầu không bỏ trống số điện thoại!",
                            checkPhone: "Yêu cầu nhập đúng số điện thoại (bắt đầu bằng 03 và có 10 số)"
                        },
                        
                        roleId: {
                            required: "Yêu cầu không bỏ trống chức vụ!"
                        },
                        
                        userName: {
                            required: "Yêu cầu không bỏ trống mã!",
                            noSpace: "Yêu cầu mã không chứa khoảng trắng!"
                        },
                        
                        password: {
                            required: "Yêu cầu không bỏ trống mật khẩu!",
                            noSpace: "Yêu cầu mật khẩu không chứa khoảng trắng!"
                        }
                    },

                    invalidHandler: function(form, validator) {
                        var errors = validator.numberOfInvalids();
                        if (errors) {
                            validator.errorList[0].element.focus();
                        }
                    },

                    submitHandler: function (form) {
                        form.submit();
                    }
                });
            });
            
            window.onload = function () {
                if ($('select[name="roleId"]').children("option:selected").val() == 3) {
                    $('select[name="faculty"]').prop("disabled", false);
                    $('input[name="classroom"]').prop("disabled", false);
                } else if ($('select[name="roleId"]').children("option:selected").val() == 2) {
                    $('select[name="faculty"]').prop("disabled", false);
                } 
            };
        </script>
    </body>
</html>
