/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sqa.qldiem.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 *
 * @author Administrator
 */
public class SessionUtilTest {

    @Test
    public void testPutValue() {
        HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
        HttpSession session = mock(HttpSession.class);
        when(httpServletRequest.getSession()).thenReturn(session);
        SessionUtil.getInstance().putValue(httpServletRequest, "TEST", "test");
        
        verify(session).setAttribute("TEST", "test");
    }

    @Test
    public void testGetValue() {
        HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
        HttpSession session = mock(HttpSession.class);
        when(httpServletRequest.getSession()).thenReturn(session);
        when(session.getAttribute("TEST")).thenReturn("test");
        
        String value = (String) SessionUtil.getInstance().getValue(httpServletRequest, "TEST");
        
        assertEquals("test", value);
    }

    @Test
    public void testRemoveValue() {
        HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
        HttpSession session = mock(HttpSession.class);
        when(httpServletRequest.getSession()).thenReturn(session);
        
        SessionUtil.getInstance().removeValue(httpServletRequest, "TEST");
        
        verify(session).removeAttribute("TEST");
    }
}
