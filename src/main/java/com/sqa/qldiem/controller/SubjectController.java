/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sqa.qldiem.controller;

import com.sqa.qldiem.model.SubjectModel;
import com.sqa.qldiem.service.ISubjectService;
import com.sqa.qldiem.service.impl.SubjectService;
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
public class SubjectController extends HttpServlet {

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
        String action = request.getParameter("action");
        String message = "";
        if (action != null && action.equals("update")) {
            SubjectModel subject = FormUtil.toSubjectModel(request);
            subjectService.updateSubject(subject);
            message = "Sửa thành công";
            SessionUtil.getInstance().putValue(request, "message_success", message);
            response.sendRedirect(request.getContextPath() + "/giaovu-cauhinh");
        } else if (action != null && action.equals("add")) {
            SubjectModel subject = FormUtil.toSubjectModel(request);
            if (subjectService.findSubjectByName(subject.getName()) != null) {
                message = "Thêm không thành công! Môn học đã tồn tại";
                SessionUtil.getInstance().putValue(request, "message_error", message);
                response.sendRedirect(request.getContextPath() + "/giaovu-cauhinh");
            } else {
                subjectService.addSubject(subject);
                message = "Thêm thành công";
                SessionUtil.getInstance().putValue(request, "message_success", message);
                response.sendRedirect(request.getContextPath() + "/giaovu-cauhinh");
            }
        } else if (action != null && action.equals("delete")) {
            String name = request.getParameter("name");
            subjectService.deleteSubject(name);
            message = "Xoá thành công";
            SessionUtil.getInstance().putValue(request, "message_success", message);
            response.sendRedirect(request.getContextPath() + "/giaovu-cauhinh");
        }
    }
    
    public SubjectService getService() {
        subjectService = new SubjectService();
        return (SubjectService) subjectService;
    }
}
