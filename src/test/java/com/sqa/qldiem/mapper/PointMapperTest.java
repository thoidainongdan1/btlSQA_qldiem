/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sqa.qldiem.mapper;

import com.sqa.qldiem.model.PointModel;
import com.sqa.qldiem.model.SubclassroomModel;
import com.sqa.qldiem.model.SubjectModel;
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
public class PointMapperTest {
    
    @Mock
    ResultSet resultSet;
    
    PointMapper pointMapper;
    
    public PointMapperTest() {
        pointMapper = new PointMapper();
    }
    
    @Before
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testMapRow() throws SQLException {
        when(resultSet.getString("semester")).thenReturn("Kì 1 năm 2020-2021");
        when(resultSet.getDouble("p.point1")).thenReturn(7.0);
        when(resultSet.getDouble("p.point2")).thenReturn(7.0);
        when(resultSet.getDouble("p.point3")).thenReturn(7.0);
        when(resultSet.getDouble("p.point4")).thenReturn(7.0);
        when(resultSet.getString("username")).thenReturn("sv7");
        when(resultSet.getString("fullname")).thenReturn("pp");
        when(resultSet.getString("faculty")).thenReturn("CNTT");
        when(resultSet.getDate("dateOfBirth")).thenReturn(Date.valueOf("2021-04-14"));
        when(resultSet.getInt("gender")).thenReturn(1);
        when(resultSet.getString("classroom")).thenReturn("D17CNPM1");
        when(resultSet.getString("cname")).thenReturn("JAVA_02");
        when(resultSet.getString("st.name")).thenReturn("Java");
        when(resultSet.getInt("st.quantity")).thenReturn(3);
        when(resultSet.getInt("st.point1")).thenReturn(10);
        when(resultSet.getInt("st.point2")).thenReturn(10);
        when(resultSet.getInt("st.point3")).thenReturn(20);
        when(resultSet.getInt("st.point4")).thenReturn(60);
        
        UserModel user = new UserModel();
        user.setUserName("sv7");
        user.setFullName("pp");
        user.setFaculty("CNTT");
        user.setClassroom("D17CNPM1");
        user.setDateOfBirth(Date.valueOf("2021-04-14"));
        user.setGender(1);
        SubclassroomModel subclass = new SubclassroomModel(new SubjectModel("Java", 3, 10, 10, 20, 60), "JAVA_02");
        
        PointModel eo = new PointModel(user, subclass, "Kì 1 năm 2020-2021", 7.0, 7.0, 7.0, 7.0);
        PointModel point = pointMapper.mapRow(resultSet);
        
        assertEquals(eo, point);
    }
    
}
