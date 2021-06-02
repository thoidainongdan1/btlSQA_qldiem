/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sqa.qldiem.service.impl;

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
public class SubjectServiceTest {
    SubjectService subjectService;
    
    public SubjectServiceTest() {
        subjectService = new SubjectService();
        subjectService.setDAO();
    }
    
    @AfterClass
    public static void backupDatabase() throws IOException {
        BackupDatabase.restore();
    }

    @Test
    public void test1_GetAllSubject_success() {
        List<SubjectModel> list = subjectService.getAllSubject();
        List<SubjectModel> eo = new ArrayList<>();
        eo.add(new SubjectModel("Java",3,10,10,20,60));
        eo.add(new SubjectModel("C++",2,10,10,10,70));
        
        assertEquals(eo, list);
    }
    
    @Test
    public void test2_FindSubjectByName_returnObject() {
        SubjectModel subject = subjectService.findSubjectByName("Java");
        SubjectModel eo = new SubjectModel("Java",3,10,10,20,60);

        assertEquals(eo, subject);
    }
    
    @Test
    public void test2_FindSubjectByName_returnNull() {
        SubjectModel subject = subjectService.findSubjectByName("C#");

        assertEquals(null, subject);
    }
    
    @Test
    public void test3_AddSubject_success() {
        SubjectModel eo = new SubjectModel("Python",3,10,10,20,60);
        subjectService.addSubject(eo);
        SubjectModel subject = subjectService.findSubjectByName("Python");

        assertEquals(eo, subject);
    }

    @Test
    public void test4_UpdateSubject_success() {
        SubjectModel eo = new SubjectModel("Python",3,10,20,20,50);
        subjectService.updateSubject(eo);
        SubjectModel subject = subjectService.findSubjectByName("Python");

        assertEquals(eo, subject);
    }
    
    @Test
    public void test4_UpdateSubject_fail() {
        SubjectModel subject = new SubjectModel();
        subject.setName("C#");
        
        subjectService.updateSubject(subject);
        subject = subjectService.findSubjectByName("C#");

        assertEquals(null, subject);
    }
    
    @Test
    public void test5_DeleteSubject_success() {
        subjectService.deleteSubject("Python");
        SubjectModel sm = subjectService.findSubjectByName("Python");
        
        assertEquals(null, sm);
    }
}
