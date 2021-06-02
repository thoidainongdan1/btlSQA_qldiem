/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sqa.qldiem.dao.impl;

import com.sqa.qldiem.model.ResultModel;
import com.sqa.qldiem.model.UserModel;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Administrator
 */
public class ResultDAOTest {
    ResultDAO resultDAO;
    
    public ResultDAOTest() {
        resultDAO = new ResultDAO();
    }

    @Test
    public void testFindBySemesterAndFacultyAndQuantity_success() {
        List<ResultModel> results = resultDAO.findBySemesterAndFacultyAndQuantity
        ("Kì 1 năm 2020-2021", "CNTT", 1);
        
        List<ResultModel> eo = new ArrayList<>();
        UserModel user = new UserModel();
        user.setUserName("sv7");
        user.setFullName("pp");
        user.setFaculty("CNTT");
        user.setClassroom("D17CNPM1");
        user.setDateOfBirth(Date.valueOf("2021-04-14"));
        user.setGender(1);
        
        eo.add(new ResultModel(user, "Kì 1 năm 2020-2021", 3.5));
        
        assertEquals(eo, results);
    }
    
    @Test
    public void testFindBySemesterAndFacultyAndQuantity_fail_wrongSemester() {
        List<ResultModel> results = resultDAO.findBySemesterAndFacultyAndQuantity
        ("Kì 1 năm 2021-2022", "CNTT", 1);
        
        List<ResultModel> eo = new ArrayList<>();
        
        assertEquals(eo, results);
    }
    
    @Test
    public void testFindBySemesterAndFacultyAndQuantity_fail_wrongFaculty() {
        List<ResultModel> results = resultDAO.findBySemesterAndFacultyAndQuantity
        ("Kì 1 năm 2020-2021", "ATTT", 1);
        
        List<ResultModel> eo = new ArrayList<>();
        
        assertEquals(eo, results);
    }
    
    @Test
    public void testFindBySemesterAndFacultyAndQuantity_fail_QuantityEqual0() {
        List<ResultModel> results = resultDAO.findBySemesterAndFacultyAndQuantity
        ("Kì 1 năm 2020-2021", "CNTT", 0);
        
        List<ResultModel> eo = new ArrayList<>();
        
        assertEquals(eo, results);
    }
}
