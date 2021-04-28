/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sqa.qldiem.controller;

import com.sqa.qldiem.model.PointModel;
import com.sqa.qldiem.service.IPointService;
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
@WebServlet(urlPatterns = {"/giaovu-theodoidiem"})
public class TrackPointController extends HttpServlet {
    
    @Inject
    private IPointService pointService;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action != null && action.equals("trackPoint")) {
            String semester = request.getParameter("semester");
            String faculty = request.getParameter("faculty");
            String subject = request.getParameter("subject");
            String subjectClass = request.getParameter("subclassroom");
            List<PointModel> listPoint = pointService.findBySemesterAndFacultyAndSubjectClassroom(semester, faculty, subjectClass);
            SessionUtil.getInstance().putValue(request, "LISTPOINT", listPoint);
            SessionUtil.getInstance().putValue(request, "SEMESTER", semester);
            SessionUtil.getInstance().putValue(request, "FACULTY", faculty);
            SessionUtil.getInstance().putValue(request, "SUBJECT", subject);
            SessionUtil.getInstance().putValue(request, "SUBJECTCLASS", subjectClass);
            RequestDispatcher rd = request.getRequestDispatcher("/views/pointTracking.jsp");
            rd.forward(request, response);
        } else {
            RequestDispatcher rd = request.getRequestDispatcher("/views/pointTracking.jsp");
            rd.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
}
