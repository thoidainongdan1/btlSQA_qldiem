/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sqa.qldiem.controller;

import com.sqa.qldiem.model.UserModel;
import com.sqa.qldiem.service.IUserService;
import com.sqa.qldiem.service.impl.UserService;
import com.sqa.qldiem.utils.SessionUtil;
import java.io.IOException;
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
@WebServlet(urlPatterns = {"/trang-chu", "/dang-nhap", "/thoat"})
public class HomeController extends HttpServlet {

    ResourceBundle resourceBundle = ResourceBundle.getBundle("message");

    @Inject
    IUserService userService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action != null && action.equals("login")) {
            String message = request.getParameter("message");
            if (message != null) {
                request.setAttribute("message", resourceBundle.getString(message));
            }
            RequestDispatcher rd = request.getRequestDispatcher("/views/login.jsp");
            rd.forward(request, response);
        } else if (action != null && action.equals("logout")) {
            SessionUtil.getInstance().removeValue(request, "USERMODEL");
            SessionUtil.getInstance().removeValue(request, "TABSELECTED");
            response.sendRedirect(request.getContextPath() + "/trang-chu");
        } else {
            RequestDispatcher rd = request.getRequestDispatcher("/views/home.jsp");
            rd.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action != null && action.equals("login")) {
            UserModel user = new UserModel();
            user.setUserName(request.getParameter("userName"));
            user.setPassword(request.getParameter("password"));
            user = userService.findByUserNameAndPasswordAndStatus(user.getUserName(), user.getPassword(), 1);
            if (user != null) {
                SessionUtil.getInstance().putValue(request, "USERMODEL", user);
                response.sendRedirect(request.getContextPath() + "/trang-chu");
            } else {
                response.sendRedirect(request.getContextPath() + "/dang-nhap?action=login&message=username_password_invalid&alert=danger");
            }
        }
    }
    
    public UserService getService() {
        userService = new UserService();
        return (UserService) userService;
    }
}
