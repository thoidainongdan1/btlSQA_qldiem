/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sqa.qldiem.controller;

import com.sqa.qldiem.model.ResultModel;
import com.sqa.qldiem.service.IResultService;
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
@WebServlet(urlPatterns = {"/giaovu-thongke"})
public class StatisticsController extends HttpServlet {
    
    @Inject
    private IResultService resultService;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action != null && action.equals("stat")) {
            String semester = request.getParameter("semester");
            String faculty = request.getParameter("faculty");
            int quantity = Integer.parseInt(request.getParameter("quantity"));
            List<ResultModel> list = resultService.findBySemesterAndFacultyAndQuantity(semester, faculty, quantity);
            SessionUtil.getInstance().putValue(request, "LISTRESULT", list);
            SessionUtil.getInstance().putValue(request, "SEMESTER", semester);
            SessionUtil.getInstance().putValue(request, "FACULTY", faculty);
            SessionUtil.getInstance().putValue(request, "QUANTITY", quantity);
            RequestDispatcher rd = request.getRequestDispatcher("/views/statisticPoint.jsp");
            rd.forward(request, response);
        } else {
            RequestDispatcher rd = request.getRequestDispatcher("/views/statisticPoint.jsp");
            rd.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
}
