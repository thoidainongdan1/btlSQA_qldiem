/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sqa.qldiem.controller;

import com.sqa.qldiem.model.UserModel;
import java.io.IOException;
import java.sql.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.ArgumentMatchers.anyString;
import org.mockito.Mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;

/**
 *
 * @author Administrator
 */

public class HomeControllerTest {
    
    @Mock
    HttpServletRequest request;

    @Mock
    HttpServletResponse response;
    
    @Mock
    RequestDispatcher rd;
    
    @Mock
    HttpSession session;
    
    HomeController homeController;

    public HomeControllerTest() {
        homeController = new HomeController();
        homeController.getService().setDAO();
    }
    
    @Before
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
    }
    
    @Test
    public void testDoGet_ActionEqualLogin_MessageNull() throws ServletException, IOException {
        when(request.getParameter("action")).thenReturn("login");
        when(request.getRequestDispatcher(anyString())).thenReturn(rd);
        
        homeController.doGet(request, response);
        
        verify(request).getRequestDispatcher("/views/login.jsp");
    }

    @Test
    public void testDoGet_ActionEqualLogin_MessageNotNull() throws ServletException, IOException {
        when(request.getParameter("action")).thenReturn("login");
        when(request.getParameter("message")).thenReturn("username_password_invalid");
        when(request.getRequestDispatcher(anyString())).thenReturn(rd);
        
        homeController.doGet(request, response);
        
        verify(request).setAttribute("message", "Tài khoản hoặc mật khẩu không đúng");
        verify(request).getRequestDispatcher("/views/login.jsp");
    }
    
    @Test
    public void testDoGet_ActionEqualLogout() throws ServletException, IOException {
        when(request.getParameter("action")).thenReturn("logout");
        when(request.getSession()).thenReturn(session);
        
        homeController.doGet(request, response);
        
        verify(session).removeAttribute("USERMODEL");
        verify(session).removeAttribute("TABSELECTED");
        verify(response).sendRedirect(request.getContextPath() + "/trang-chu");
    }
    
    @Test
    public void testDoGet_ActionNull() throws ServletException, IOException {
        when(request.getRequestDispatcher(anyString())).thenReturn(rd);
        
        homeController.doGet(request, response);
        
        verify(request).getRequestDispatcher("/views/home.jsp");
    }
    
    @Test
    public void testDoPost_ActionEqualLogin_UserNotNull() throws ServletException, IOException {
        when(request.getParameter("action")).thenReturn("login");
        when(request.getParameter("userName")).thenReturn("admin");
        when(request.getParameter("password")).thenReturn("123456");
        when(request.getSession()).thenReturn(session);
        
        UserModel eo = new UserModel("admin", "admin", "123456", 1, (long)1, 0, "Hanoi", 
                "0123456789", "", Date.valueOf("2021-04-14"), "");

        homeController.doPost(request, response);
        
        verify(session).setAttribute("USERMODEL", eo);
        verify(response).sendRedirect(request.getContextPath() + "/trang-chu");
    }
    
    @Test
    public void testDoPost_ActionEqualLogin_UserNull() throws ServletException, IOException {
        when(request.getParameter("action")).thenReturn("login");
        when(request.getParameter("userName")).thenReturn("admin123");
        when(request.getParameter("password")).thenReturn("123456");
        when(request.getSession()).thenReturn(session);

        homeController.doPost(request, response);
        
        verify(response).sendRedirect(request.getContextPath() + 
                "/dang-nhap?action=login&message=username_password_invalid&alert=danger");
    }
}
