/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sqa.qldiem.controller;

import com.sqa.qldiem.model.PointModel;
import com.sqa.qldiem.service.impl.PointService;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
public class PointControllerTest {
    
    @Mock
    HttpServletRequest request;

    @Mock
    HttpServletResponse response;
    
    @Mock
    RequestDispatcher rd;
    
    @Mock
    HttpSession session;
    
    PointController pointController;
    PointService pointService;
    
    @Before
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
    }
    
    public PointControllerTest() {
        pointController = new PointController();
        pointService = pointController.getService();
        pointService.setDAO();
    }

    @Test
    public void testDoGet_ActionNull() throws ServletException, IOException {
        when(request.getRequestDispatcher(anyString())).thenReturn(rd);
        
        pointController.doGet(request, response);
        
        verify(request).getRequestDispatcher("/views/pointTracking.jsp");
    }
    
    @Test
    public void testDoGet_ActionEqualTrackPoint() throws ServletException, IOException {
        when(request.getParameter("action")).thenReturn("trackPoint");
        when(request.getParameter("semester")).thenReturn("Kì 1 năm 2020-2021");
        when(request.getParameter("faculty")).thenReturn("CNTT");
        when(request.getParameter("subject")).thenReturn("Java");
        when(request.getParameter("subclassroom")).thenReturn("JAVA_01");
        when(request.getSession()).thenReturn(session);
        when(request.getRequestDispatcher(anyString())).thenReturn(rd);
        
        pointController.doGet(request, response);
        
        List<PointModel> eo = pointService.findBySemesterAndFacultyAndSubjectClassroom
        ("Kì 1 năm 2020-2021", "CNTT", "JAVA_01");
        
        verify(session).setAttribute("LISTPOINT", eo);
        verify(session).setAttribute("SEMESTER", "Kì 1 năm 2020-2021");
        verify(session).setAttribute("FACULTY", "CNTT");
        verify(session).setAttribute("SUBJECT", "Java");
        verify(session).setAttribute("SUBJECTCLASS", "JAVA_01");
        verify(request).getRequestDispatcher("/views/pointTracking.jsp");
    }
    
}
