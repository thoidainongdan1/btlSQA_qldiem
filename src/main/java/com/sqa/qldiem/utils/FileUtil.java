/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sqa.qldiem.utils;

import com.sqa.qldiem.model.PointModel;
import com.sqa.qldiem.model.PointStat;
import com.sqa.qldiem.model.SubclassroomModel;
import com.sqa.qldiem.model.SubjectModel;
import com.sqa.qldiem.model.UserModel;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Administrator
 */
public class FileUtil {

    public static void writeFile(File file, List<PointModel> objects) {
        FileOutputStream fileOutputStream = null;
        ObjectOutputStream outputStream = null;
        List<PointStat> list = new ArrayList<>();
        for(PointModel o : objects) {
            PointStat t = new PointStat();
            t.setUserName(o.getUser().getUserName());
            t.setGender(o.getUser().getGender());
            t.setFaculty(o.getUser().getFaculty());
            t.setFullName(o.getUser().getFullName());
            t.setDateOfBirth(o.getUser().getDateOfBirth());
            t.setClassroom(o.getUser().getClassroom());
            t.setPoint1(o.getPoint1());
            t.setPoint2(o.getPoint2());
            t.setPoint3(o.getPoint3());
            t.setPoint4(o.getPoint4());
            t.setPPoint1(o.getSubclass().getSubject().getPoint1());
            t.setPPoint2(o.getSubclass().getSubject().getPoint2());
            t.setPPoint3(o.getSubclass().getSubject().getPoint3());
            t.setPPoint4(o.getSubclass().getSubject().getPoint4());
            t.setAvgPoint(o.getAvgPoint());
            t.setWordPoint(o.getResult());
            
            list.add(t);
        }
        try {
            fileOutputStream = new FileOutputStream(file);
            outputStream = new ObjectOutputStream(fileOutputStream);
            outputStream.writeObject(list);
        } catch (IOException e) {
        } finally {
            try {
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                if (outputStream != null) {
                    outputStream.close();
                }
            } catch (IOException e) {
            }
        }
    }

    public static List<PointModel> readFile(File file) {
        FileInputStream fileInputStream = null;
        ObjectInputStream objectInputStream = null;
        List<PointModel> list = new ArrayList<>();
        try {
            fileInputStream = new FileInputStream(file);
            objectInputStream = new ObjectInputStream(fileInputStream);

            ArrayList<PointStat> ps = (ArrayList<PointStat>) objectInputStream.readObject();
            for(PointStat p : ps) {
                PointModel pm = new PointModel();
                pm.setPoint1(p.getPoint1());
                pm.setPoint2(p.getPoint2());
                pm.setPoint3(p.getPoint3());
                pm.setPoint4(p.getPoint4());
                pm.setAvgPoint(p.getAvgPoint());
                pm.setResult(p.getWordPoint());
                
                UserModel user = new UserModel();
                user.setUserName(p.getUserName());
                user.setFullName(p.getFullName());
                user.setGender(p.getGender());
                user.setClassroom(p.getClassroom());
                user.setFaculty(p.getFaculty());
                user.setDateOfBirth(p.getDateOfBirth());
                pm.setUser(user);
                
                SubclassroomModel subClass = new SubclassroomModel();
                SubjectModel subject = new SubjectModel();
                subject.setPoint1(p.getPPoint1());
                subject.setPoint2(p.getPPoint2());
                subject.setPoint3(p.getPPoint3());
                subject.setPoint4(p.getPPoint4());
                subClass.setSubject(subject);
                pm.setSubclass(subClass);  
                
                list.add(pm);
            }
        } catch (IOException | ClassNotFoundException e) {
        } finally {
            try {
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                if (objectInputStream != null) {
                    objectInputStream.close();
                }
            } catch (IOException e) {
            }
        }
        return list;
    }
}
