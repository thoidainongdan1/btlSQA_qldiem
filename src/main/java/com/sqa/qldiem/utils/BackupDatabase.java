/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sqa.qldiem.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author Administrator
 */
public class BackupDatabase {

    private static void createBat() throws IOException, InterruptedException {
        String dir = "cd C:\\Program Files\\MySQL\\MySQL Workbench 8.0 CE";
        String cmd = dir + "\nmysql.exe --host=localhost --port=3306 --user=root "
                + "--password=phongquang9599 --database=qldiem < C:\\Users\\Administrator\\Desktop\\backup.sql "
                + "\n exit";
        File f = new File("restore.bat");
        FileOutputStream fos = new FileOutputStream(f);
        fos.write(cmd.getBytes());
        fos.close();
    }
    
    public static void restore() throws IOException {
        Runtime.getRuntime().exec("cmd /C start restore.bat");
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        createBat();
    }
}
