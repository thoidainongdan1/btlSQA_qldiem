/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sqa.qldiem.controller;

import com.sqa.qldiem.model.UserModel;
import com.sqa.qldiem.service.IUserService;
import com.sqa.qldiem.utils.FormUtil;
import com.sqa.qldiem.utils.SessionUtil;
import java.io.IOException;
import java.util.List;
import java.util.ResourceBundle;
import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Administrator
 */
@WebServlet(urlPatterns = {"/giaovu-quanlynguoidung", "/giaovu-capnhatnguoidung"})
public class UserController extends HttpServlet {
    
    ResourceBundle resourceBundle = ResourceBundle.getBundle("message");

    @Inject
    IUserService userService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action != null && action.equals("addUserForm")) {
            String username = request.getParameter("username");
            String message = request.getParameter("message");
            if(username != null) {
                UserModel userupdate = userService.findByUserName(username);
                SessionUtil.getInstance().putValue(request, "USERUPDATE", userupdate);
                SessionUtil.getInstance().putValue(request, "username", username);
            }
            if(message != null) {
                SessionUtil.getInstance().putValue(request, "message", resourceBundle.getString(message));
            }
            RequestDispatcher rd = request.getRequestDispatcher("/views/updateUser.jsp");
            rd.forward(request, response);
        } else {
            List<UserModel> listEmployee = userService.getUsersByRole(1);
            List<UserModel> listLecturer = userService.getUsersByRole(2);
            List<UserModel> listStudent = userService.getUsersByRole(3);
            SessionUtil.getInstance().putValue(request, "LISTEMPLOYEE", listEmployee);
            SessionUtil.getInstance().putValue(request, "LISTLECTURER", listLecturer);
            SessionUtil.getInstance().putValue(request, "LISTSTUDENT", listStudent);
            RequestDispatcher rd = request.getRequestDispatcher("/views/userManagement.jsp");
            rd.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action != null && action.equals("addUser")) {
            UserModel user = FormUtil.toModel(UserModel.class, request);
            UserModel userDB = userService.findByUserName(user.getUserName());
            if(userDB == null) {
                userService.addUser(user);
                String message = "Thêm thành công";
                SessionUtil.getInstance().putValue(request, "message", message);
                response.sendRedirect(request.getContextPath() + "/giaovu-quanlynguoidung");
            } else {
                SessionUtil.getInstance().putValue(request, "USER", user);
                response.sendRedirect(request.getContextPath() + "/giaovu-capnhatnguoidung?action=addUserForm&message=username_exsist");
            }
        } else if(action != null && action.equals("updateUser")) {
            UserModel user = FormUtil.toModel(UserModel.class, request);
            user.setUserName((String) SessionUtil.getInstance().getValue(request, "username"));
            SessionUtil.getInstance().removeValue(request, "username");
            userService.updateUser(user);
            String message = "Sửa thành công";
            SessionUtil.getInstance().putValue(request, "message", message);
            response.sendRedirect(request.getContextPath() + "/giaovu-quanlynguoidung");
        } else if(action != null && action.equals("removeUser")) {
            String username = request.getParameter("username");
            userService.removeUser(username);
            List<UserModel> listUser = userService.getAllUser();
            SessionUtil.getInstance().putValue(request, "LISTUSER", listUser);
            RequestDispatcher rd = request.getRequestDispatcher("/views/table/userTable.jsp");
            rd.forward(request, response);
        }
    }
}
