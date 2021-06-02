/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sqa.qldiem.utils;

import java.sql.Date;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Administrator
 */
public class DateFormatUtilTest {
    
    public DateFormatUtilTest() {
    }

    @Test
    public void testFormat() {
        String date = DateFormatUtil.format(Date.valueOf("1999-03-16"));
        String eo = "16/03/1999";
        
        assertEquals(eo, date);
    }
    
}
