/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sqa.qldiem.mapper;

import com.sqa.qldiem.model.RoleModel;
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
public class UserMapperTest {
    
    @Mock
    ResultSet resultSet;
    
    UserMapper userMapper;
    
    @Before
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
    }
    
    public UserMapperTest() {
        userMapper = new UserMapper();
    }

    @Test
    public void testMapRow() throws SQLException {
        when(resultSet.getString("username")).thenReturn("admin");
        when(resultSet.getString("fullname")).thenReturn("admin");
        when(resultSet.getString("password")).thenReturn("123456");
        when(resultSet.getString("address")).thenReturn("Hanoi");
        when(resultSet.getString("faculty")).thenReturn("");
        when(resultSet.getString("phone")).thenReturn("0345678911");
        when(resultSet.getLong("roleid")).thenReturn((long)1);
        when(resultSet.getDate("dateOfBirth")).thenReturn(Date.valueOf("2021-04-14"));
        when(resultSet.getInt("gender")).thenReturn(0);
        when(resultSet.getString("classroom")).thenReturn("");
        when(resultSet.getInt("status")).thenReturn(1);
        when(resultSet.getString("code")).thenReturn("GIAOVU");
        when(resultSet.getString("name")).thenReturn("Giáo vụ");
        
        UserModel eo = new UserModel("admin", "admin", "123456", 1, (long)1, 0, "Hanoi", 
                "0345678911", "", Date.valueOf("2021-04-14"), "");
        eo.setRole(new RoleModel("GIAOVU", "Giáo vụ"));
        
        UserModel user = userMapper.mapRow(resultSet);
        
        assertEquals(eo, user);
    }
    
}
