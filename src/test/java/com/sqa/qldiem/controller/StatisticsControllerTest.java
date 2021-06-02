/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sqa.qldiem.controller;

import com.sqa.qldiem.model.ResultModel;
import com.sqa.qldiem.service.impl.ResultService;
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
public class StatisticsControllerTest {
    
    @Mock
    HttpServletRequest request;

    @Mock
    HttpServletResponse response;
    
    @Mock
    RequestDispatcher rd;
    
    @Mock
    HttpSession session;
    
    StatisticsController statController;
    ResultService resultService;
    
    @Before
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
    }
    
    public StatisticsControllerTest() {
        statController = new StatisticsController();
        resultService = statController.getService();
        resultService.setDAO();
    }

    @Test
    public void testDoGet_ActionNull() throws ServletException, IOException {
        when(request.getRequestDispatcher(anyString())).thenReturn(rd);
        
        statController.doGet(request, response);
        
        verify(request).getRequestDispatcher("/views/statisticPoint.jsp");
    }
    
    @Test
    public void testDoGet_ActionEqualStat() throws ServletException, IOException {
        when(request.getParameter("action")).thenReturn("stat");
        when(request.getParameter("semester")).thenReturn("Kì 1 năm 2020-2021");
        when(request.getParameter("faculty")).thenReturn("CNTT");
        when(request.getParameter("quantity")).thenReturn("5");
        when(request.getSession()).thenReturn(session);
        when(request.getRequestDispatcher(anyString())).thenReturn(rd);
        
        statController.doGet(request, response);
        
        List<ResultModel> eo = resultService.findBySemesterAndFacultyAndQuantity("Kì 1 năm 2020-2021", "CNTT", 5);
        
        verify(session).setAttribute("LISTRESULT", eo);
        verify(session).setAttribute("SEMESTER", "Kì 1 năm 2020-2021");
        verify(session).setAttribute("FACULTY", "CNTT");
        verify(session).setAttribute("QUANTITY", 5);
        verify(request).getRequestDispatcher("/views/statisticPoint.jsp");
    }
    
}
