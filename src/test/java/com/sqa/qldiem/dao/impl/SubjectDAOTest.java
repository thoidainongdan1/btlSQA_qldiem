/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sqa.qldiem.dao.impl;

import com.sqa.qldiem.model.SubjectModel;
import com.sqa.qldiem.utils.BackupDatabase;
import java.io.IOException;
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
public class SubjectDAOTest {
    SubjectDAO subjectDAO;
    
    public SubjectDAOTest() {
        subjectDAO = new SubjectDAO();
    }
    
    @AfterClass
    public static void backupDatabase() throws IOException {
        BackupDatabase.restore();
    }

    @Test
    public void test1_GetAllSubject_success() {
        List<SubjectModel> list = subjectDAO.getAllSubject();
        List<SubjectModel> eo = new ArrayList<>();
        eo.add(new SubjectModel("Java",3,10,10,20,60));
        eo.add(new SubjectModel("C++",2,10,10,10,70));
        
        assertEquals(eo, list);
    }
    
    @Test
    public void test2_FindSubjectByName_returnObject() {
        SubjectModel subject = subjectDAO.findSubjectByName("Java");
        SubjectModel eo = new SubjectModel("Java",3,10,10,20,60);

        assertEquals(eo, subject);
    }
    
    @Test
    public void test2_FindSubjectByName_returnNull() {
        SubjectModel subject = subjectDAO.findSubjectByName("C#");

        assertEquals(null, subject);
    }
    
    @Test
    public void test3_AddSubject_success() {
        SubjectModel eo = new SubjectModel("Python",3,10,10,20,60);
        subjectDAO.addSubject(eo);
        SubjectModel subject = subjectDAO.findSubjectByName("Python");

        assertEquals(eo, subject);
    }

    @Test
    public void test4_UpdateSubject_success() {
        SubjectModel eo = new SubjectModel("Python",3,10,20,20,50);
        subjectDAO.updateSubject(eo);
        SubjectModel subject = subjectDAO.findSubjectByName("Python");

        assertEquals(eo, subject);
    }
    
    @Test
    public void test4_UpdateSubject_fail() {
        SubjectModel subject = new SubjectModel();
        subject.setName("C#");
        
        subjectDAO.updateSubject(subject);
        subject = subjectDAO.findSubjectByName("C#");

        assertEquals(null, subject);
    }
    
    @Test
    public void test5_DeleteSubject_success() {
        subjectDAO.deleteSubject("Python");
        SubjectModel sm = subjectDAO.findSubjectByName("Python");
        
        assertEquals(null, sm);
    }
}
