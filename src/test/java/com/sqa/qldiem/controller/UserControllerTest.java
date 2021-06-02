/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sqa.qldiem.controller;

import com.sqa.qldiem.model.UserModel;
import com.sqa.qldiem.service.impl.UserService;
import com.sqa.qldiem.utils.BackupDatabase;
import java.io.IOException;
import java.sql.Date;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import static org.mockito.ArgumentMatchers.anyString;
import org.mockito.Mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;

/**
 *
 * @author Administrator
 */
public class UserControllerTest {
    
    @Mock
    HttpServletRequest request;

    @Mock
    HttpServletResponse response;
    
    @Mock
    RequestDispatcher rd;
    
    @Mock
    HttpSession session;
    
    UserController userController;
    UserService userService;

    public UserControllerTest() {
        userController = new UserController();
        userService = userController.getService();
        userService.setDAO();
    }
    
    @Before
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
    }
    
    @AfterClass
    public static void backupDatabase() throws IOException {
        BackupDatabase.restore();
    }

    @Test
    public void testDoGet_ActionEqualAddUserForm_UserNameNull_MessageNull() 
            throws ServletException, IOException {
        when(request.getParameter("action")).thenReturn("addUserForm");
        when(request.getRequestDispatcher(anyString())).thenReturn(rd);
        
        userController.doGet(request, response);
        
        verify(request).getRequestDispatcher("/views/updateUser.jsp");
    }
    
    @Test
    public void testDoGet_ActionEqualAddUserForm_UserNameNotNull_MessageNull() 
            throws ServletException, IOException {
        when(request.getParameter("action")).thenReturn("addUserForm");
        when(request.getParameter("username")).thenReturn("admin");
        when(request.getSession()).thenReturn(session);
        when(request.getRequestDispatcher(anyString())).thenReturn(rd);
        
        UserModel eo = new UserModel("admin", "admin", "123456", 1, (long)1, 0, "Hanoi", 
                "0123456789", "", Date.valueOf("2021-04-14"), "");
        
        userController.doGet(request, response);
        
        verify(session).setAttribute("USERUPDATE", eo);
        verify(session).setAttribute("username", "admin");
        verify(request).getRequestDispatcher("/views/updateUser.jsp");
    }
    
    @Test
    public void testDoGet_ActionEqualAddUserForm_UserNameNull_MessageNotNull() 
            throws ServletException, IOException {
        when(request.getParameter("action")).thenReturn("addUserForm");
        when(request.getParameter("message")).thenReturn("username_exsist");
        when(request.getSession()).thenReturn(session);
        when(request.getRequestDispatcher(anyString())).thenReturn(rd);
        
        userController.doGet(request, response);
        
        verify(session).setAttribute("message", "Mã người dùng đã tồn tại");
        verify(request).getRequestDispatcher("/views/updateUser.jsp");
    }
    
    @Test
    public void testDoGet_ActionEqualAddUserForm_UserNameNotNull_MessageNotNull() 
            throws ServletException, IOException {
        when(request.getParameter("action")).thenReturn("addUserForm");
        when(request.getParameter("username")).thenReturn("admin");
        when(request.getParameter("message")).thenReturn("username_exsist");
        when(request.getSession()).thenReturn(session);
        when(request.getRequestDispatcher(anyString())).thenReturn(rd);
        
        UserModel eo = new UserModel("admin", "admin", "123456", 1, (long)1, 0, "Hanoi", 
                "0123456789", "", Date.valueOf("2021-04-14"), "");
        
        userController.doGet(request, response);
        
        verify(session).setAttribute("USERUPDATE", eo);
        verify(session).setAttribute("username", "admin");
        verify(session).setAttribute("message", "Mã người dùng đã tồn tại");
        verify(request).getRequestDispatcher("/views/updateUser.jsp");
    }
    
    @Test
    public void testDoGet_ActionNull_TabEqual1() 
            throws ServletException, IOException {
        when(request.getParameter("tab")).thenReturn("1");
        when(request.getSession()).thenReturn(session);
        when(request.getRequestDispatcher(anyString())).thenReturn(rd);
        
        userController.doGet(request, response);
        
        List<UserModel> eo = userService.getUsersByRole(1);
        
        verify(session).setAttribute("LISTEMPLOYEE", eo);
        verify(session).setAttribute("TABSELECTED", "1");
        verify(request).getRequestDispatcher("/views/userManagement.jsp");
    }
    
    @Test
    public void testDoGet_ActionNull_TabEqual2() 
            throws ServletException, IOException {
        when(request.getParameter("tab")).thenReturn("2");
        when(request.getSession()).thenReturn(session);
        when(request.getRequestDispatcher(anyString())).thenReturn(rd);
        
        userController.doGet(request, response);
        
        List<UserModel> eo = userService.getUsersByRole(2);
        
        verify(session).setAttribute("LISTLECTURER", eo);
        verify(session).setAttribute("TABSELECTED", "2");
        verify(request).getRequestDispatcher("/views/userManagement.jsp");
    }
    
    @Test
    public void testDoGet_ActionNull_TabEqual3() 
            throws ServletException, IOException {
        when(request.getParameter("tab")).thenReturn("3");
        when(request.getSession()).thenReturn(session);
        when(request.getRequestDispatcher(anyString())).thenReturn(rd);
        
        userController.doGet(request, response);
        
        List<UserModel> eo = userService.getUsersByRole(3);
        
        verify(session).setAttribute("LISTSTUDENT", eo);
        verify(session).setAttribute("TABSELECTED", "3");
        verify(request).getRequestDispatcher("/views/userManagement.jsp");
    }
    
    @Test
    public void testDoGet_ActionNull_TabNull_TabSelectedNotNull() 
            throws ServletException, IOException {
        when(request.getSession()).thenReturn(session);
        when(session.getAttribute("TABSELECTED")).thenReturn("2");
        
        userController.doGet(request, response);
        
        verify(response).sendRedirect(request.getContextPath() + "/giaovu-quanlynguoidung?tab=2");
    }
    
    @Test
    public void testDoGet_ActionNull_TabNull_TabSelectedNull() 
            throws ServletException, IOException {
        when(request.getSession()).thenReturn(session);
        
        userController.doGet(request, response);
        
        verify(response).sendRedirect(request.getContextPath() + "/giaovu-quanlynguoidung?tab=1");
    }
    
    @Test
    public void testDoPost_ActionEqualAddUser_UserExists() 
            throws ServletException, IOException {
        when(request.getParameter("action")).thenReturn("addUser");
        when(request.getParameter("fullName")).thenReturn("Minh Quang");
        when(request.getParameter("dateOfBirth")).thenReturn("1999-03-16");
        when(request.getParameter("gender")).thenReturn("1");
        when(request.getParameter("address")).thenReturn("Hà Nội");
        when(request.getParameter("phone")).thenReturn("0123456789");
        when(request.getParameter("roleId")).thenReturn("3");
        when(request.getParameter("faculty")).thenReturn("CNTT");
        when(request.getParameter("classroom")).thenReturn("D17CNPM3");
        when(request.getParameter("userName")).thenReturn("admin");
        when(request.getParameter("password")).thenReturn("123456");
        when(request.getSession()).thenReturn(session);
        
        UserModel eo = new UserModel("admin", "Minh Quang", "123456", 1,
                (long) 3, 1, "Hà Nội", "0123456789", "CNTT", Date.valueOf("1999-03-16"), "D17CNPM3");
        
        userController.doPost(request, response);
        
        verify(session).setAttribute("USER", eo);
        verify(response).sendRedirect(request.getContextPath() + 
                "/giaovu-capnhatnguoidung?action=addUserForm&message=username_exsist");
    }  
    
    @Test
    public void testDoPost_ActionEqualAddUser_UserNotExists() 
            throws ServletException, IOException {
        when(request.getParameter("action")).thenReturn("addUser");
        when(request.getParameter("fullName")).thenReturn("Minh Quang");
        when(request.getParameter("dateOfBirth")).thenReturn("1999-03-16");
        when(request.getParameter("gender")).thenReturn("1");
        when(request.getParameter("address")).thenReturn("Hà Nội");
        when(request.getParameter("phone")).thenReturn("0123456789");
        when(request.getParameter("roleId")).thenReturn("3");
        when(request.getParameter("faculty")).thenReturn("CNTT");
        when(request.getParameter("classroom")).thenReturn("D17CNPM3");
        when(request.getParameter("userName")).thenReturn("B17CN510");
        when(request.getParameter("password")).thenReturn("123456");
        when(request.getSession()).thenReturn(session);
        
        userController.doPost(request, response);
        
        UserModel eo = new UserModel("B17CN510", "Minh Quang", "123456", 1,
                (long) 3, 1, "Hà Nội", "0123456789", "CNTT", Date.valueOf("1999-03-16"), "D17CNPM3");
        UserModel user = userService.findByUserName("B17CN510");
        
        verify(session).setAttribute("message", "Thêm thành công");
        verify(response).sendRedirect(request.getContextPath() + "/giaovu-quanlynguoidung");
        assertEquals(eo, user);
    } 
    
    @Test
    public void testDoPost_ActionEqualUpdateUser() 
            throws ServletException, IOException {
        when(request.getParameter("action")).thenReturn("updateUser");
        when(request.getParameter("fullName")).thenReturn("Nguyễn Minh Quang");
        when(request.getParameter("dateOfBirth")).thenReturn("1999-03-16");
        when(request.getParameter("gender")).thenReturn("1");
        when(request.getParameter("address")).thenReturn("Hà Nội");
        when(request.getParameter("phone")).thenReturn("0123456789");
        when(request.getParameter("roleId")).thenReturn("3");
        when(request.getParameter("faculty")).thenReturn("CNTT");
        when(request.getParameter("classroom")).thenReturn("D17CNPM3");
        when(request.getParameter("userName")).thenReturn("sv1");
        when(request.getParameter("password")).thenReturn("123456");
        when(request.getSession()).thenReturn(session);
        when(session.getAttribute("username")).thenReturn("sv1");
        
        userController.doPost(request, response);
        
        UserModel eo = new UserModel("sv1", "Nguyễn Minh Quang", "123456", 1,
                (long) 3, 1, "Hà Nội", "0123456789", "CNTT", Date.valueOf("1999-03-16"), "D17CNPM3");
        UserModel user = userService.findByUserName("sv1");
        
        verify(session).removeAttribute("username");
        verify(session).setAttribute("message", "Sửa thành công");
        verify(response).sendRedirect(request.getContextPath() + "/giaovu-quanlynguoidung");
        assertEquals(eo, user);
    }
    
    @Test
    public void testDoPost_ActionEqualRemoveStudent() 
            throws ServletException, IOException {
        when(request.getParameter("action")).thenReturn("removeUser");
        when(request.getParameter("username")).thenReturn("B17CN510");
        when(request.getParameter("table")).thenReturn("studentTable");
        when(request.getSession()).thenReturn(session);
        when(request.getRequestDispatcher(anyString())).thenReturn(rd);
        
        userController.doPost(request, response);
        
        UserModel user = userService.findByUserName("B17CN510");
        List<UserModel> list = userService.getUsersByRole(3);
        
        verify(session).setAttribute("LISTSTUDENT", list);
        verify(session).setAttribute("message", "Xoá thành công");
        verify(request).getRequestDispatcher("/views/table/studentTable.jsp");
        assertEquals(null, user);
    }
    
    @Test
    public void testDoPost_ActionEqualRemoveLecturer() 
            throws ServletException, IOException {
        when(request.getParameter("action")).thenReturn("removeUser");
        when(request.getParameter("username")).thenReturn("gv3");
        when(request.getParameter("table")).thenReturn("lecturerTable");
        when(request.getSession()).thenReturn(session);
        when(request.getRequestDispatcher(anyString())).thenReturn(rd);
        
        userController.doPost(request, response);
        
        UserModel user = userService.findByUserName("gv3");
        List<UserModel> list = userService.getUsersByRole(2);
        
        verify(session).setAttribute("LISTLECTURER", list);
        verify(session).setAttribute("message", "Xoá thành công");
        verify(request).getRequestDispatcher("/views/table/lecturerTable.jsp");
        assertEquals(null, user);
    }
    
    @Test
    public void testDoPost_ActionEqualRemoveEmployee() 
            throws ServletException, IOException {
        when(request.getParameter("action")).thenReturn("removeUser");
        when(request.getParameter("username")).thenReturn("admin2");
        when(request.getParameter("table")).thenReturn("employeeTable");
        when(request.getSession()).thenReturn(session);
        when(request.getRequestDispatcher(anyString())).thenReturn(rd);
        
        userController.doPost(request, response);
        
        UserModel user = userService.findByUserName("admin2");
        List<UserModel> list = userService.getUsersByRole(1);
        
        verify(session).setAttribute("LISTEMPLOYEE", list);
        verify(session).setAttribute("message", "Xoá thành công");
        verify(request).getRequestDispatcher("/views/table/employeeTable.jsp");
        assertEquals(null, user);
    }
}
