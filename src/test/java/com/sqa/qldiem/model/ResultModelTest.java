/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sqa.qldiem.model;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Administrator
 */
public class ResultModelTest {
    private ResultModel result;
    
    public ResultModelTest() {
        result = new ResultModel();
    }
    
    @Test
    public void testCalScholarship_bigger() {
        String res = result.calScholarship(4.01);
        String eo = "";
        
        assertEquals(eo, res);
    }

    @Test
    public void testCalScholarship_XX1() {
        String res = result.calScholarship(3.6);
        String eo = "Xuất sắc";
        
        assertEquals(eo, res);
    }
    
    @Test
    public void testCalScholarship_XX2() {
        String res = result.calScholarship(3.8);
        String eo = "Xuất sắc";
        
        assertEquals(eo, res);
    }
    
    @Test
    public void testCalScholarship_XX3() {
        String res = result.calScholarship(4);
        String eo = "Xuất sắc";
        
        assertEquals(eo, res);
    }
    
    @Test
    public void testCalScholarship_G1() {
        String res = result.calScholarship(3.2);
        String eo = "Giỏi";
        
        assertEquals(eo, res);
    }
    
    @Test
    public void testCalScholarship_G2() {
        String res = result.calScholarship(3.35);
        String eo = "Giỏi";
        
        assertEquals(eo, res);
    }
    
    @Test
    public void testCalScholarship_G3() {
        String res = result.calScholarship(3.59);
        String eo = "Giỏi";
        
        assertEquals(eo, res);
    }
    
    @Test
    public void testCalScholarship_K1() {
        String res = result.calScholarship(2.5);
        String eo = "Khá";
        
        assertEquals(eo, res);
    }
    
    @Test
    public void testCalScholarship_K2() {
        String res = result.calScholarship(2.8);
        String eo = "Khá";
        
        assertEquals(eo, res);
    }
    
    @Test
    public void testCalScholarship_K3() {
        String res = result.calScholarship(3.19);
        String eo = "Khá";
        
        assertEquals(eo, res);
    }
    
    @Test
    public void testCalScholarship_smaller() {
        String res = result.calScholarship(2.49);
        String eo = "";
        
        assertEquals(eo, res);
    }
}
