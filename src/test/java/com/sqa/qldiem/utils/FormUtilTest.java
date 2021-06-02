/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sqa.qldiem.utils;

import com.sqa.qldiem.model.SubjectModel;
import com.sqa.qldiem.model.UserModel;
import java.sql.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;

/**
 *
 * @author Administrator
 */
public class FormUtilTest {

    @Mock
    HttpServletRequest request;

    @Mock
    HttpServletResponse response;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testToUserModel() {
        when(request.getParameter("fullName")).thenReturn("Minh Quang");
        when(request.getParameter("dateOfBirth")).thenReturn("1999-03-16");
        when(request.getParameter("gender")).thenReturn("1");
        when(request.getParameter("address")).thenReturn("Hà Nội");
        when(request.getParameter("phone")).thenReturn("0123456789");
        when(request.getParameter("roleId")).thenReturn("3");
        when(request.getParameter("faculty")).thenReturn("CNTT");
        when(request.getParameter("classroom")).thenReturn("D17CNPM3");
        when(request.getParameter("userName")).thenReturn("B17DCCN510");
        when(request.getParameter("password")).thenReturn("123456");
        
        UserModel user = FormUtil.toUserModel(request);
        
        UserModel eo = new UserModel("B17DCCN510", "Minh Quang", "123456", 1,
                (long) 3, 1, "Hà Nội", "0123456789", "CNTT", Date.valueOf("1999-03-16"), "D17CNPM3");
        
        assertEquals(eo, user);
    }
    
    @Test
    public void testToSubjectModel() {
        when(request.getParameter("name")).thenReturn("Python");
        when(request.getParameter("quantity")).thenReturn("3");
        when(request.getParameter("point1")).thenReturn("10");
        when(request.getParameter("point2")).thenReturn("10");
        when(request.getParameter("point3")).thenReturn("20");
        when(request.getParameter("point4")).thenReturn("60");
        
        SubjectModel subject = FormUtil.toSubjectModel(request);
        
        SubjectModel eo = new SubjectModel("Python", 3, 10, 10, 20, 60);
        
        assertEquals(eo, subject);
    }

}
