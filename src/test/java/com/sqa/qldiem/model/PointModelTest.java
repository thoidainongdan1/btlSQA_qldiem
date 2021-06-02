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
public class PointModelTest {
    private PointModel pm;
    
    public PointModelTest() {
        pm = new PointModel();
    }

    @Test
    public void testCalAvgPoint() {
        double avg = pm.calAvgPoint(6, 7, 8, 9, 10, 10, 20, 60);
        double eo = 8.3;
        
        assertEquals(eo, avg, 0);
    }
    
    @Test
    public void testCalAvgPoint_checkRound() {
        double avg = pm.calAvgPoint(6, 7, 8, 9, 10, 10, 15, 65);
        double eo = 8.4;
        
        assertEquals(eo, avg, 0);
    }
    
    @Test
    public void testCalResult_smallerThanZero() {
        String res = pm.calResult(-0.1);
        String eo = "";
        
        assertEquals(eo, res);
    }
    
    // _1 : test biên dưới
    // _2 : test trong khoảng
    // _3 : test biên trên
    @Test
    public void testCalResult_F_1() {
        String res = pm.calResult(0);
        String eo = "F";
        
        assertEquals(eo, res);
    }
    
    @Test
    public void testCalResult_F_2() {
        String res = pm.calResult(2);
        String eo = "F";
        
        assertEquals(eo, res);
    }
    
    @Test
    public void testCalResult_F_3() {
        String res = pm.calResult(3.9);
        String eo = "F";
        
        assertEquals(eo, res);
    }
    
    @Test
    public void testCalResult_D_1() {
        String res = pm.calResult(4);
        String eo = "D";
        
        assertEquals(eo, res);
    }
    
    @Test
    public void testCalResult_D_2() {
        String res = pm.calResult(4.5);
        String eo = "D";
        
        assertEquals(eo, res);
    }
    
    @Test
    public void testCalResult_D_3() {
        String res = pm.calResult(4.9);
        String eo = "D";
        
        assertEquals(eo, res);
    }
    
    @Test
    public void testCalResult_Dplus_1() {
        String res = pm.calResult(5);
        String eo = "D+";
        
        assertEquals(eo, res);
    }
    
    @Test
    public void testCalResult_Dplus_2() {
        String res = pm.calResult(5.2);
        String eo = "D+";
        
        assertEquals(eo, res);
    }
    
    @Test
    public void testCalResult_Dplus_3() {
        String res = pm.calResult(5.4);
        String eo = "D+";
        
        assertEquals(eo, res);
    }
    
    @Test
    public void testCalResult_C_1() {
        String res = pm.calResult(5.5);
        String eo = "C";
        
        assertEquals(eo, res);
    }
    
    @Test
    public void testCalResult_C_2() {
        String res = pm.calResult(6);
        String eo = "C";
        
        assertEquals(eo, res);
    }
    
    @Test
    public void testCalResult_C_3() {
        String res = pm.calResult(6.4);
        String eo = "C";
        
        assertEquals(eo, res);
    }
    
    @Test
    public void testCalResult_Cplus_1() {
        String res = pm.calResult(6.5);
        String eo = "C+";
        
        assertEquals(eo, res);
    }
    
    @Test
    public void testCalResult_Cplus_2() {
        String res = pm.calResult(6.7);
        String eo = "C+";
        
        assertEquals(eo, res);
    }
    
    @Test
    public void testCalResult_Cplus_3() {
        String res = pm.calResult(6.9);
        String eo = "C+";
        
        assertEquals(eo, res);
    }
    
    @Test
    public void testCalResult_B_1() {
        String res = pm.calResult(7);
        String eo = "B";
        
        assertEquals(eo, res);
    }
    
    @Test
    public void testCalResult_B_2() {
        String res = pm.calResult(7.5);
        String eo = "B";
        
        assertEquals(eo, res);
    }
    
    @Test
    public void testCalResult_B_3() {
        String res = pm.calResult(7.9);
        String eo = "B";
        
        assertEquals(eo, res);
    }
    
    @Test
    public void testCalResult_Bplus_1() {
        String res = pm.calResult(8);
        String eo = "B+";
        
        assertEquals(eo, res);
    }
    
    @Test
    public void testCalResult_Bplus_2() {
        String res = pm.calResult(8.2);
        String eo = "B+";
        
        assertEquals(eo, res);
    }
    
    @Test
    public void testCalResult_Bplus_3() {
        String res = pm.calResult(8.4);
        String eo = "B+";
        
        assertEquals(eo, res);
    }
    
    @Test
    public void testCalResult_A_1() {
        String res = pm.calResult(8.5);
        String eo = "A";
        
        assertEquals(eo, res);
    }
    
    @Test
    public void testCalResult_A_2() {
        String res = pm.calResult(8.7);
        String eo = "A";
        
        assertEquals(eo, res);
    }
    
    @Test
    public void testCalResult_A_3() {
        String res = pm.calResult(8.9);
        String eo = "A";
        
        assertEquals(eo, res);
    }
    
    @Test
    public void testCalResult_Aplus_1() {
        String res = pm.calResult(9);
        String eo = "A+";
        
        assertEquals(eo, res);
    }
    
    @Test
    public void testCalResult_Aplus_2() {
        String res = pm.calResult(9.5);
        String eo = "A+";
        
        assertEquals(eo, res);
    }
    
    @Test
    public void testCalResult_Aplus_3() {
        String res = pm.calResult(10);
        String eo = "A+";
        
        assertEquals(eo, res);
    }
    
    @Test
    public void testCalResult_biggerThanTen(){
        String res = pm.calResult(10.1);
        String eo = "";
        
        assertEquals(eo, res);
    }
}
