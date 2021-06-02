/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sqa.qldiem.service.impl;

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
public class UserServiceTest {
    UserService userService;
    
    public UserServiceTest() {
        userService = new UserService();
        userService.setDAO();
    }
    
    @AfterClass
    public static void backupDatabase() throws IOException {
        BackupDatabase.restore();
    }

    @Test
    public void test1_FindByUserNameAndPasswordAndStatus_returnObject() {
        UserModel user = userService.findByUserNameAndPasswordAndStatus("admin", "123456", 1);
        UserModel eo = new UserModel("admin", "admin", "123456", 1, (long)1, 0, "Hanoi", 
                "0123456789", "", Date.valueOf("2021-04-14"), "");

        assertEquals(eo, user);
    }
    
    @Test
    public void test1_FindByUserNameAndPasswordAndStatus_returnNull() {
        UserModel user = userService.findByUserNameAndPasswordAndStatus("admin123", "123456", 1);
        UserModel eo = null;

        assertEquals(eo, user);
    }

    @Test
    public void test2_FindByUserName_returnObject() {
        UserModel user = userService.findByUserName("admin");
        UserModel eo = new UserModel("admin", "admin", "123456", 1, (long)1, 0, "Hanoi", 
                "0123456789", "", Date.valueOf("2021-04-14"), "");

        assertEquals(eo, user);
    }
    
    @Test
    public void test2_FindByUserName_returnNull() {
        UserModel user = userService.findByUserName("admin123");
        UserModel eo = null;

        assertEquals(eo, user);
    }
    
    @Test
    public void test3_GetUsersByRole_returnObjects() {
        List<UserModel> list = userService.getUsersByRole(1);
        List<UserModel> eo = new ArrayList<>();
        eo.add(userService.findByUserName("admin"));
        eo.add(userService.findByUserName("admin2"));
        eo.add(userService.findByUserName("admin3"));
        eo.add(userService.findByUserName("PTITGV01"));

        assertEquals(eo, list);
    }
    
    @Test
    public void test3_GetUsersByRole_returnEmpty() {
        List<UserModel> list = userService.getUsersByRole(0);
        List<UserModel> eo = new ArrayList<>();

        assertEquals(eo, list);
    }
    
    @Test
    public void test4_AddUser_success() {
        UserModel eo = new UserModel("gv_test", "gv_test", "123456", 1, (long)2, 0, "Hanoi", 
                "0323456789", "CNTT", Date.valueOf("2021-04-14"), "");
        
        userService.addUser(eo);
        UserModel user = userService.findByUserName("gv_test");
        
        assertEquals(eo, user);
    }
    
    @Test
    public void test5_updateUser_success() {
        UserModel eo = new UserModel("gv_test", "gv_test", "123456", 1, (long)2, 0, "Đà Nẵng", 
                "0323456789", "CNTT", Date.valueOf("2021-04-14"), "");
        
        userService.updateUser(eo);
        UserModel user = userService.findByUserName("gv_test");
        
        assertEquals(eo, user);
    }
    
    @Test
    public void test5_updateUser_fail() {
        UserModel user = new UserModel();
        user.setUserName("unknown");
        
        userService.updateUser(user);
        user = userService.findByUserName("unknown");
        
        assertEquals(null, user);
    }
    
    @Test
    public void test6_removeUser_success() {
        userService.removeUser("gv_test");
        UserModel user = userService.findByUserName("gv_test");
        
        assertEquals(null, user);
    }
}
