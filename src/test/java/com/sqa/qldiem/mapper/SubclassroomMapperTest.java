/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sqa.qldiem.mapper;

import com.sqa.qldiem.model.SubclassroomModel;
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
public class SubclassroomMapperTest {
    
    @Mock
    ResultSet resultSet;
    
    SubclassroomMapper subclassroomMapper;
    
    @Before
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
    }
    
    public SubclassroomMapperTest() {
        subclassroomMapper = new SubclassroomMapper();
    }

    @Test
    public void testMapRow() throws SQLException {
        when(resultSet.getString("cname")).thenReturn("JAVA_02");
        when(resultSet.getString("st.name")).thenReturn("Java");
        when(resultSet.getInt("st.quantity")).thenReturn(3);
        when(resultSet.getInt("st.point1")).thenReturn(10);
        when(resultSet.getInt("st.point2")).thenReturn(10);
        when(resultSet.getInt("st.point3")).thenReturn(20);
        when(resultSet.getInt("st.point4")).thenReturn(60);
        
        SubclassroomModel eo = new SubclassroomModel(new SubjectModel("Java",3,10,10,20,60), "JAVA_02");
        SubclassroomModel subclassroom = subclassroomMapper.mapRow(resultSet);
        
        assertEquals(eo, subclassroom);
        
    }
    
}
