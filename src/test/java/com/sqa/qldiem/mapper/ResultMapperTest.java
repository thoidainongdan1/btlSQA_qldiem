/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sqa.qldiem.mapper;

import com.sqa.qldiem.model.ResultModel;
import com.sqa.qldiem.model.UserModel;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;

/**
 *
 * @author Administrator
 */
public class ResultMapperTest {
    
    @Mock
    ResultSet resultSet;
    
    ResultMapper ResultMapper;
    
    public ResultMapperTest() {
        ResultMapper = new ResultMapper();
    }
    
    @Before
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testMapRow() throws SQLException {
        when(resultSet.getString("semester")).thenReturn("Kì 1 năm 2020-2021");
        when(resultSet.getDouble("point")).thenReturn(3.5);
        when(resultSet.getString("username")).thenReturn("sv7");
        when(resultSet.getString("fullname")).thenReturn("pp");
        when(resultSet.getString("faculty")).thenReturn("CNTT");
        when(resultSet.getDate("dateOfBirth")).thenReturn(Date.valueOf("2021-04-14"));
        when(resultSet.getInt("gender")).thenReturn(1);
        when(resultSet.getString("classroom")).thenReturn("D17CNPM1");
        
        UserModel user = new UserModel();
        user.setUserName("sv7");
        user.setFullName("pp");
        user.setFaculty("CNTT");
        user.setClassroom("D17CNPM1");
        user.setDateOfBirth(Date.valueOf("2021-04-14"));
        user.setGender(1);
        
        ResultModel eo = new ResultModel(user, "Kì 1 năm 2020-2021", 3.5);
        ResultModel Result = ResultMapper.mapRow(resultSet);
        
        assertEquals(eo, Result);
    }
    
}
