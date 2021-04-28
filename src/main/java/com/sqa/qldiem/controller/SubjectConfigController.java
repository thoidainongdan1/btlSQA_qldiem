/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sqa.qldiem.controller;

import com.sqa.qldiem.model.SubjectModel;
import com.sqa.qldiem.service.ISubjectService;
import com.sqa.qldiem.utils.FormUtil;
import com.sqa.qldiem.utils.SessionUtil;
import java.io.IOException;
import java.util.List;
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
@WebServlet(urlPatterns = {"/giaovu-cauhinh"})
public class SubjectConfigController extends HttpServlet {

    @Inject
    private ISubjectService subjectService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<SubjectModel> list = subjectService.getAllSubject();
        SessionUtil.getInstance().putValue(request, "LISTSUBJECT", list);
        RequestDispatcher rd = request.getRequestDispatcher("/views/subjectConfig.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        SubjectModel subject = FormUtil.toModel(SubjectModel.class, request);
        subjectService.updateSubject(subject);
        response.sendRedirect(request.getContextPath() + "/giaovu-cauhinh");
    }
}
