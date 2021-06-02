/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sqa.qldiem.dao.impl;

import com.sqa.qldiem.model.PointModel;
import com.sqa.qldiem.model.SubclassroomModel;
import com.sqa.qldiem.model.SubjectModel;
import com.sqa.qldiem.model.UserModel;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Administrator
 */
public class PointDAOTest {

    PointDAO pointDAO;

    public PointDAOTest() {
        pointDAO = new PointDAO();
    }

    @Test
    public void testFindBySemesterAndFacultyAndSubjectClassroom_success() {
        List<PointModel> points = pointDAO.findBySemesterAndFacultyAndSubjectClassroom("Kì 1 năm 2020-2021", "CNTT", "JAVA_02");

        List<PointModel> eo = new ArrayList<>();
        UserModel user = new UserModel();
        user.setUserName("sv7");
        user.setFullName("pp");
        user.setFaculty("CNTT");
        user.setClassroom("D17CNPM1");
        user.setDateOfBirth(Date.valueOf("2021-04-14"));
        user.setGender(1);
        SubclassroomModel subclass = new SubclassroomModel(new SubjectModel("Java", 3, 10, 10, 20, 60), "JAVA_02");
        eo.add(new PointModel(user, subclass, "Kì 1 năm 2020-2021", 7.0, 7.0, 7.0, 7.0));

        assertEquals(eo, points);
    }
    
    @Test
    public void testFindBySemesterAndFacultyAndSubjectClassroom_fail_wrongClass() {
        List<PointModel> points = pointDAO.findBySemesterAndFacultyAndSubjectClassroom("Kì 1 năm 2020-2021", "CNTT", "PYTHON_01");

        List<PointModel> eo = new ArrayList<>();

        assertEquals(eo, points);
    }
    
    @Test
    public void testFindBySemesterAndFacultyAndSubjectClassroom_fail_wrongFaculty() {
        List<PointModel> points = pointDAO.findBySemesterAndFacultyAndSubjectClassroom("Kì 1 năm 2020-2021", "ATTT", "JAVA_01");

        List<PointModel> eo = new ArrayList<>();

        assertEquals(eo, points);
    }
    
    @Test
    public void testFindBySemesterAndFacultyAndSubjectClassroom_fail_wrongSemester() {
        List<PointModel> points = pointDAO.findBySemesterAndFacultyAndSubjectClassroom("Kì 1 năm 2021-2022", "CNTT", "JAVA_01");

        List<PointModel> eo = new ArrayList<>();

        assertEquals(eo, points);
    }
}
