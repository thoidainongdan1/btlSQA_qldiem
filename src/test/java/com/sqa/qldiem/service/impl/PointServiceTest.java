/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sqa.qldiem.service.impl;

import com.sqa.qldiem.model.PointModel;
import com.sqa.qldiem.model.SubclassroomModel;
import com.sqa.qldiem.model.SubjectModel;
import com.sqa.qldiem.model.UserModel;
import java.io.File;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

/**
 *
 * @author Administrator
 */

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PointServiceTest {

    static File file;
    PointService pointService;

    public PointServiceTest() {
        pointService = new PointService();
        pointService.setDAO();
    }
    
    @AfterClass
    public static void removeFile() {
        file.delete();
    }
    
    @Test
    public void test1_FindBySemesterAndFacultyAndSubjectClassroom_success_fileNotExists() {
        List<PointModel> points = pointService.findBySemesterAndFacultyAndSubjectClassroom("Kì 1 năm 2020-2021", "CNTT", "JAVA_02");

        List<PointModel> eo = new ArrayList<>();
        UserModel user = new UserModel();
        user.setUserName("sv7");
        user.setFullName("pp");
        user.setFaculty("CNTT");
        user.setClassroom("D17CNPM1");
        user.setDateOfBirth(Date.valueOf("2021-04-14"));
        user.setGender(1);
        SubclassroomModel subclass = new SubclassroomModel(new SubjectModel("Java", 3, 10, 10, 20, 60), "JAVA_02"); 
        
        PointModel pm = new PointModel(user, subclass, "Kì 1 năm 2020-2021", 7.0, 7.0, 7.0, 7.0);
        pm.setAvgPointAndResult();
        
        eo.add(pm);

        assertEquals(eo, points);
    }

    @Test
    public void test2_FindBySemesterAndFacultyAndSubjectClassroom_success_fileExists() {
        List<PointModel> points = pointService.findBySemesterAndFacultyAndSubjectClassroom("Kì 1 năm 2020-2021", "CNTT", "JAVA_02");

        List<PointModel> eo = new ArrayList<>();
        UserModel user = new UserModel();
        user.setUserName("sv7");
        user.setFullName("pp");
        user.setFaculty("CNTT");
        user.setClassroom("D17CNPM1");
        user.setDateOfBirth(Date.valueOf("2021-04-14"));
        user.setGender(1);
        SubclassroomModel subclass = new SubclassroomModel(new SubjectModel(null, 0, 10, 10, 20, 60), null); 
        
        PointModel pm = new PointModel(user, subclass, null, 7.0, 7.0, 7.0, 7.0);
        pm.setAvgPointAndResult();
        
        eo.add(pm);
        file = new File("stored/12020_CNTT_JAVA_02");
        
        assertEquals(eo, points);
    }
    
    @Test
    public void test3_FindBySemesterAndFacultyAndSubjectClassroom_fail_wrongClass() {
        List<PointModel> points = pointService.findBySemesterAndFacultyAndSubjectClassroom("Kì 1 năm 2020-2021", "CNTT", "PYTHON_01");

        List<PointModel> eo = new ArrayList<>();

        assertEquals(eo, points);
    }
    
    @Test
    public void test4_FindBySemesterAndFacultyAndSubjectClassroom_fail_wrongFaculty() {
        List<PointModel> points = pointService.findBySemesterAndFacultyAndSubjectClassroom("Kì 1 năm 2020-2021", "ATTT", "JAVA_01");

        List<PointModel> eo = new ArrayList<>();

        assertEquals(eo, points);
    }
    
    @Test
    public void test5_FindBySemesterAndFacultyAndSubjectClassroom_fail_wrongSemester() {
        List<PointModel> points = pointService.findBySemesterAndFacultyAndSubjectClassroom("Kì 1 năm 2021-2022", "CNTT", "JAVA_01");

        List<PointModel> eo = new ArrayList<>();

        assertEquals(eo, points);
    }
}
