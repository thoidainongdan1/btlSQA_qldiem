/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sqa.qldiem.filter;

import com.sqa.qldiem.model.UserModel;
import com.sqa.qldiem.utils.SessionUtil;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Administrator
 */
public class LoginRequiredFilter implements Filter {
    
    private ServletContext context;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.context = filterConfig.getServletContext();
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        String url = req.getRequestURI(); // get URL already request
        if(url.startsWith("/qldiem/giaovu-")) {
            UserModel userModel = (UserModel) SessionUtil.getInstance().getValue(req, "USERMODEL");
            if(userModel != null) {
                if(userModel.getRole().getCode().equals("GIAOVU")) {
                    chain.doFilter(request, response);
                } else {
                    res.sendRedirect(req.getContextPath() + "/dang-nhap?action=login&message=not_permission&alert=danger");
                }
            } else {
                res.sendRedirect(req.getContextPath() + "/dang-nhap?action=login&message=not_login&alert=danger");
            }
        } else {
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
