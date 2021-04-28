<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Quản lí điểm sinh viên PTIT</title>

        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script> 
        <link rel="stylesheet" href="css/style.css">

    </head>
    <body>
        <div class="navbar navbar-expand-lg navbar-light bg-light top">
            <a class="navbar-brand" href="<c:url value='/trang-chu' />"><img src="image/ptit.png" width="100px" height="100px"></a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarResponsive">
                <ul class="navbar-nav ml-auto">
                    <c:if test="${not empty USERMODEL}">
                        <li class="nav-item">
                            <a class="nav-link" href='#'>Xin chào, ${USERMODEL.fullName}</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href='<c:url value="/thoat?action=logout"/>'>Thoát <i class="fa fa-sign-out"></i></a>
                        </li>
                    </c:if>
                    <c:if test="${empty USERMODEL}">
                        <li class="nav-item">
                            <a class="nav-link" href='<c:url value="/dang-nhap?action=login"/>'>Đăng nhập</a>
                        </li>
                    </c:if>
                </ul>
            </div>
        </div> 

        <div class="navbar bg-danger fix-nav">
            <a class="nav-link" href='<c:url value="/giaovu-quanlynguoidung"/>'>Quản lý người dùng</a>
            <a class="nav-link" href='<c:url value="/giaovu-theodoidiem"/>'>Theo dõi điểm</a>
            <a class="nav-link" href='<c:url value="/giaovu-thongke"/>'>Thống kê</a>
            <a class="nav-link" href='<c:url value="/giaovu-cauhinh"/>'>Cấu hình</a>
        </div>
    </body>
</html>

