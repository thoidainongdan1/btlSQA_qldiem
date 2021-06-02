/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sqa.qldiem.dao.impl;

import com.sqa.qldiem.model.UserModel;
import com.sqa.qldiem.utils.BackupDatabase;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
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
public class UserDAOTest {
    UserDAO userDAO;
    
    public UserDAOTest() {
        userDAO = new UserDAO();
    }
    
    @AfterClass
    public static void backupDatabase() throws IOException {
        BackupDatabase.restore();
    }

    @Test
    public void test1_FindByUserNameAndPasswordAndStatus_returnObject() {
        UserModel user = userDAO.findByUserNameAndPasswordAndStatus("admin", "123456", 1);
        UserModel eo = new UserModel("admin", "admin", "123456", 1, (long)1, 0, "Hanoi", 
                "0123456789", "", Date.valueOf("2021-04-14"), "");

        assertEquals(eo, user);
    }
    
    @Test
    public void test1_FindByUserNameAndPasswordAndStatus_returnNull() {
        UserModel user = userDAO.findByUserNameAndPasswordAndStatus("admin123", "123456", 1);
        UserModel eo = null;

        assertEquals(eo, user);
    }

    @Test
    public void test2_FindByUserName_returnObject() {
        UserModel user = userDAO.findByUserName("admin");
        UserModel eo = new UserModel("admin", "admin", "123456", 1, (long)1, 0, "Hanoi", 
                "0123456789", "", Date.valueOf("2021-04-14"), "");

        assertEquals(eo, user);
    }
    
    @Test
    public void test2_FindByUserName_returnNull() {
        UserModel user = userDAO.findByUserName("admin123");
        UserModel eo = null;

        assertEquals(eo, user);
    }
    
    @Test
    public void test3_GetUsersByRole_returnObjects() {
        List<UserModel> list = userDAO.getUsersByRole(1);
        List<UserModel> eo = new ArrayList<>();
        eo.add(userDAO.findByUserName("admin"));
        eo.add(userDAO.findByUserName("admin2"));
        eo.add(userDAO.findByUserName("admin3"));
        eo.add(userDAO.findByUserName("PTITGV01"));

        assertEquals(eo, list);
    }
    
    @Test
    public void test3_GetUsersByRole_returnEmpty() {
        List<UserModel> list = userDAO.getUsersByRole(0);
        List<UserModel> eo = new ArrayList<>();

        assertEquals(eo, list);
    }
    
    @Test
    public void test4_AddUser_success() {
        UserModel eo = new UserModel("gv_test", "gv_test", "123456", 1, (long)2, 0, "Hanoi", 
                "0323456789", "CNTT", Date.valueOf("2021-04-14"), "");
        
        userDAO.addUser(eo);
        UserModel user = userDAO.findByUserName("gv_test");
        
        assertEquals(eo, user);
    }
    
    @Test
    public void test5_updateUser_success() {
        UserModel eo = new UserModel("gv_test", "gv_test", "123456", 1, (long)2, 0, 
                "Đà Nẵng","0323456789", "CNTT", Date.valueOf("2021-04-14"), "");
        
        userDAO.updateUser(eo);
        UserModel user = userDAO.findByUserName("gv_test");
        
        assertEquals(eo, user);
    }
    
    @Test
    public void test5_updateUser_fail() {
        UserModel user = new UserModel();
        user.setUserName("unknown");
        
        userDAO.updateUser(user);
        user = userDAO.findByUserName("unknown");
        
        assertEquals(null, user);
    }
    
    @Test
    public void test6_removeUser_success() {
        userDAO.removeUser("gv_test");
        UserModel user = userDAO.findByUserName("gv_test");
        
        assertEquals(null, user);
    }
}
