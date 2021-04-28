/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sqa.qldiem.utils;

import java.sql.Date;
import java.text.SimpleDateFormat;

/**
 *
 * @author Administrator
 */
public class DateFormatUtil {
    public static String format(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.format(date);
    }
}
