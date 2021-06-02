/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sqa.qldiem.filter;

import com.sqa.qldiem.model.RoleModel;
import com.sqa.qldiem.model.UserModel;
import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.junit.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 *
 * @author Administrator
 */
public class LoginRequiredFilterTest {

    public LoginRequiredFilterTest() {
    }

    @Test
    public void testDoFilter_NotLogin() throws IOException, ServletException {
        HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
        HttpServletResponse httpServletResponse = mock(HttpServletResponse.class);
        FilterChain filterChain = mock(FilterChain.class);
        HttpSession session = mock(HttpSession.class);
              
        when(httpServletRequest.getRequestURI()).thenReturn("/qldiem/giaovu-cauhinh");
        when(httpServletRequest.getSession()).thenReturn(session);

        LoginRequiredFilter filter = new LoginRequiredFilter();
        filter.doFilter(httpServletRequest, httpServletResponse,filterChain);

        verify(httpServletResponse).sendRedirect(httpServletRequest.getContextPath()+
                "/dang-nhap?action=login&message=not_login&alert=danger");
    }
    
    @Test
    public void testDoFilter_LoginWithRoleStudent() throws IOException, ServletException {
        HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
        HttpServletResponse httpServletResponse = mock(HttpServletResponse.class);
        FilterChain filterChain = mock(FilterChain.class);
        HttpSession session = mock(HttpSession.class);

        UserModel user = new UserModel();
        user.setRole(new RoleModel("SINHVIEN","Sinh viên"));
              
        when(httpServletRequest.getRequestURI()).thenReturn("/qldiem/giaovu-cauhinh");
        when(httpServletRequest.getSession()).thenReturn(session);
        when(session.getAttribute("USERMODEL")).thenReturn(user);

        LoginRequiredFilter filter = new LoginRequiredFilter();
        filter.doFilter(httpServletRequest, httpServletResponse,filterChain);

        verify(httpServletResponse).sendRedirect(httpServletRequest.getContextPath()+
                "/dang-nhap?action=login&message=not_permission&alert=danger");
    }
    
    @Test
    public void testDoFilter_LoginWithRoleLecturer() throws IOException, ServletException {
        HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
        HttpServletResponse httpServletResponse = mock(HttpServletResponse.class);
        FilterChain filterChain = mock(FilterChain.class);
        HttpSession session = mock(HttpSession.class);

        UserModel user = new UserModel();
        user.setRole(new RoleModel("GIANGVIEN","Giảng viên"));
              
        when(httpServletRequest.getRequestURI()).thenReturn("/qldiem/giaovu-cauhinh");
        when(httpServletRequest.getSession()).thenReturn(session);
        when(session.getAttribute("USERMODEL")).thenReturn(user);

        LoginRequiredFilter filter = new LoginRequiredFilter();
        filter.doFilter(httpServletRequest, httpServletResponse,filterChain);

        verify(httpServletResponse).sendRedirect(httpServletRequest.getContextPath()+
                "/dang-nhap?action=login&message=not_permission&alert=danger");
    }
    
    @Test
    public void testDoFilter_LoginWithRoleAdmin() throws IOException, ServletException {
        HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
        HttpServletResponse httpServletResponse = mock(HttpServletResponse.class);
        FilterChain filterChain = mock(FilterChain.class);
        HttpSession session = mock(HttpSession.class);

        UserModel user = new UserModel();
        user.setRole(new RoleModel("GIAOVU","Giáo vụ"));
              
        when(httpServletRequest.getRequestURI()).thenReturn("/qldiem/giaovu-cauhinh");
        when(httpServletRequest.getSession()).thenReturn(session);
        when(session.getAttribute("USERMODEL")).thenReturn(user);

        LoginRequiredFilter filter = new LoginRequiredFilter();
        filter.doFilter(httpServletRequest, httpServletResponse,filterChain);

        verify(filterChain).doFilter(httpServletRequest, httpServletResponse);
    }
    
    @Test
    public void testDoFilter_NotFilter() throws IOException, ServletException {
        HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
        HttpServletResponse httpServletResponse = mock(HttpServletResponse.class);
        FilterChain filterChain = mock(FilterChain.class);
        HttpSession session = mock(HttpSession.class);
              
        when(httpServletRequest.getRequestURI()).thenReturn("/qldiem/trangchu");
        when(httpServletRequest.getSession()).thenReturn(session);

        LoginRequiredFilter filter = new LoginRequiredFilter();
        filter.doFilter(httpServletRequest, httpServletResponse,filterChain);

        verify(filterChain).doFilter(httpServletRequest, httpServletResponse);
    }
}
