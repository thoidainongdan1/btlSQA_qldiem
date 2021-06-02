/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sqa.qldiem.mapper;

import com.sqa.qldiem.model.SubjectModel;
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
public class SubjectMapperTest {
    
    @Mock
    ResultSet resultSet;
    
    SubjectMapper subjectMapper;
    
    @Before
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
    }
    
    public SubjectMapperTest() {
        subjectMapper = new SubjectMapper();
    }

    @Test
    public void testMapRow() throws SQLException {
        when(resultSet.getString("name")).thenReturn("Java");
        when(resultSet.getInt("quantity")).thenReturn(3);
        when(resultSet.getInt("point1")).thenReturn(10);
        when(resultSet.getInt("point2")).thenReturn(10);
        when(resultSet.getInt("point3")).thenReturn(20);
        when(resultSet.getInt("point4")).thenReturn(60);
        
        SubjectModel eo = new SubjectModel("Java",3,10,10,20,60);
        SubjectModel subject = subjectMapper.mapRow(resultSet);
        
        assertEquals(eo, subject);
        
    }
    
}
