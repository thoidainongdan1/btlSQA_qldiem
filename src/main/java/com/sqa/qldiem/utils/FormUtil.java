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

/**
 *
 * @author Administrator
 */
public class FormUtil {

    public static UserModel toUserModel(HttpServletRequest request) {
        String fullName = request.getParameter("fullName");
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        int status = 1;
        Long roleId = Long.parseLong(request.getParameter("roleId"));
        int gender = Integer.parseInt(request.getParameter("gender"));
        String address = request.getParameter("address");
        String phone = request.getParameter("phone");
        String faculty = request.getParameter("faculty");
        Date dateOfBirth = Date.valueOf(request.getParameter("dateOfBirth"));
        String classroom = request.getParameter("classroom");

        return new UserModel(userName, fullName, password, status, roleId,
                gender, address, phone, faculty, dateOfBirth, classroom);
    }

    public static SubjectModel toSubjectModel(HttpServletRequest request) {
        String name = request.getParameter("name");
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        int point1 = Integer.parseInt(request.getParameter("point1"));
        int point2 = Integer.parseInt(request.getParameter("point2"));
        int point3 = Integer.parseInt(request.getParameter("point3"));
        int point4 = Integer.parseInt(request.getParameter("point4"));
        
        return new SubjectModel(name, quantity, point1, point2, point3, point4);
    }
}
