/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sqa.qldiem.utils;

import com.sqa.qldiem.model.PointModel;
import com.sqa.qldiem.model.SubclassroomModel;
import com.sqa.qldiem.model.SubjectModel;
import com.sqa.qldiem.model.UserModel;
import java.io.File;
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
public class FileUtilTest {
    static File file;
    
    public FileUtilTest() {
    }
    
    @AfterClass
    public static void removeFile() {
        file.delete();
    }

    @Test
    public void test1_WriteFile() {
        List<PointModel> points = new ArrayList<>();
        UserModel user = new UserModel();
        user.setUserName("sv7");
        user.setFullName("pp");
        user.setFaculty("CNTT");
        user.setClassroom("D17CNPM1");
        user.setDateOfBirth(Date.valueOf("2021-04-14"));
        user.setGender(1);
        SubclassroomModel subclass = new SubclassroomModel(new SubjectModel("Java", 3, 10, 10, 20, 60), "JAVA_02");
        points.add(new PointModel(user, subclass, "Kì 1 năm 2020-2021", 7.0, 7.0, 7.0, 7.0));
        
        file = new File("test");
        FileUtil.writeFile(file, points);
        
        assertTrue(file.exists());
    }

    @Test
    public void test2_ReadFile() {
        List<PointModel> points = FileUtil.readFile(file);
        
        List<PointModel> eo = new ArrayList<>();
        UserModel user = new UserModel();
        user.setUserName("sv7");
        user.setFullName("pp");
        user.setFaculty("CNTT");
        user.setClassroom("D17CNPM1");
        user.setDateOfBirth(Date.valueOf("2021-04-14"));
        user.setGender(1);
        SubclassroomModel subclass = new SubclassroomModel(new SubjectModel(null, 0, 10, 10, 20, 60), null);
        eo.add(new PointModel(user, subclass, null, 7.0, 7.0, 7.0, 7.0));
        
        assertEquals(eo, points);
    }
    
}
