/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sqa.qldiem.controller;

import com.sqa.qldiem.model.SubjectModel;
import com.sqa.qldiem.service.impl.SubjectService;
import com.sqa.qldiem.utils.BackupDatabase;
import java.io.IOException;
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
public class SubjectControllerTest {
    
    @Mock
    HttpServletRequest request;

    @Mock
    HttpServletResponse response;
    
    @Mock
    RequestDispatcher rd;
    
    @Mock
    HttpSession session;
    
    SubjectController subjectController;
    SubjectService subjectService;
    
    public SubjectControllerTest() {
        subjectController = new SubjectController();
        subjectService = subjectController.getService();
        subjectService.setDAO();
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
    public void testDoGet() throws ServletException, IOException {
        when(request.getSession()).thenReturn(session);
        when(request.getRequestDispatcher(anyString())).thenReturn(rd);
        
        subjectController.doGet(request, response);
        
        List<SubjectModel> eo = subjectService.getAllSubject();
        
        verify(session).setAttribute("LISTSUBJECT", eo);
        verify(request).getRequestDispatcher("/views/subjectConfig.jsp");
    }
    
    @Test
    public void testDoPost_ActionEqualUpdate() throws ServletException, IOException {
        when(request.getParameter("action")).thenReturn("update");
        when(request.getParameter("name")).thenReturn("C++");
        when(request.getParameter("quantity")).thenReturn("3");
        when(request.getParameter("point1")).thenReturn("10");
        when(request.getParameter("point2")).thenReturn("10");
        when(request.getParameter("point3")).thenReturn("20");
        when(request.getParameter("point4")).thenReturn("60");
        when(request.getSession()).thenReturn(session);
        
        subjectController.doPost(request, response);
        
        SubjectModel eo = new SubjectModel("C++", 3, 10, 10, 20, 60);
        SubjectModel subject = subjectService.findSubjectByName("C++");
        
        verify(session).setAttribute("message_success", "Sửa thành công");
        verify(response).sendRedirect(request.getContextPath() + "/giaovu-cauhinh");
        assertEquals(eo, subject);
    }
    
    @Test
    public void testDoPost_ActionEqualDelete() throws ServletException, IOException {
        when(request.getParameter("action")).thenReturn("delete");
        when(request.getParameter("name")).thenReturn("Java");
        when(request.getSession()).thenReturn(session);
        
        subjectController.doPost(request, response);
        
        SubjectModel subject = subjectService.findSubjectByName("Java");
        
        verify(session).setAttribute("message_success", "Xoá thành công");
        verify(response).sendRedirect(request.getContextPath() + "/giaovu-cauhinh");
        assertEquals(null, subject);
    }
    
    @Test
    public void testDoPost_ActionEqualAdd_Success() throws ServletException, IOException {
        when(request.getParameter("action")).thenReturn("add");
        when(request.getParameter("name")).thenReturn("Python");
        when(request.getParameter("quantity")).thenReturn("3");
        when(request.getParameter("point1")).thenReturn("10");
        when(request.getParameter("point2")).thenReturn("10");
        when(request.getParameter("point3")).thenReturn("20");
        when(request.getParameter("point4")).thenReturn("60");
        when(request.getSession()).thenReturn(session);
        
        subjectController.doPost(request, response);
        
        SubjectModel eo = new SubjectModel("Python", 3, 10, 10, 20, 60);
        SubjectModel subject = subjectService.findSubjectByName("Python");
        
        verify(session).setAttribute("message_success", "Thêm thành công");
        verify(response).sendRedirect(request.getContextPath() + "/giaovu-cauhinh");
        assertEquals(eo, subject);
    }
    
    @Test
    public void testDoPost_ActionEqualAdd_Fail() throws ServletException, IOException {
        when(request.getParameter("action")).thenReturn("add");
        when(request.getParameter("name")).thenReturn("C++");
        when(request.getParameter("quantity")).thenReturn("3");
        when(request.getParameter("point1")).thenReturn("10");
        when(request.getParameter("point2")).thenReturn("20");
        when(request.getParameter("point3")).thenReturn("30");
        when(request.getParameter("point4")).thenReturn("40");
        when(request.getSession()).thenReturn(session);
        
        subjectController.doPost(request, response);
        
        SubjectModel eo = new SubjectModel("C++", 3, 10, 20, 30, 40);
        SubjectModel subject = subjectService.findSubjectByName("C++");
        
        verify(session).setAttribute("message_error", "Thêm không thành công! Môn học đã tồn tại");
        verify(response).sendRedirect(request.getContextPath() + "/giaovu-cauhinh");
        assertNotEquals(eo, subject);
    }
}
