/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sqa.qldiem.model;

import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author Administrator
 */
public class PointStat implements Serializable {
    private String userName;
    private String fullName;
    private int gender;
    private String faculty;
    private String classroom;
    private Date dateOfBirth;
    private double point1;
    private double point2;
    private double point3;
    private double point4;
    private int pPoint1;
    private int pPoint2;
    private int pPoint3;
    private int pPoint4;
    private double avgPoint;
    private String wordPoint;

    public int getPPoint1() {
        return pPoint1;
    }

    public void setPPoint1(int pPoint1) {
        this.pPoint1 = pPoint1;
    }

    public int getPPoint2() {
        return pPoint2;
    }

    public void setPPoint2(int pPoint2) {
        this.pPoint2 = pPoint2;
    }

    public int getPPoint3() {
        return pPoint3;
    }

    public void setPPoint3(int pPoint3) {
        this.pPoint3 = pPoint3;
    }

    public int getPPoint4() {
        return pPoint4;
    }

    public void setPPoint4(int pPoint4) {
        this.pPoint4 = pPoint4;
    }
    
    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public double getPoint1() {
        return point1;
    }

    public void setPoint1(double point1) {
        this.point1 = point1;
    }

    public double getPoint2() {
        return point2;
    }

    public void setPoint2(double point2) {
        this.point2 = point2;
    }

    public double getPoint3() {
        return point3;
    }

    public void setPoint3(double point3) {
        this.point3 = point3;
    }

    public double getPoint4() {
        return point4;
    }

    public void setPoint4(double point4) {
        this.point4 = point4;
    }

    public double getAvgPoint() {
        return avgPoint;
    }

    public void setAvgPoint(double avgPoint) {
        this.avgPoint = avgPoint;
    }

    public String getWordPoint() {
        return wordPoint;
    }

    public void setWordPoint(String wordPoint) {
        this.wordPoint = wordPoint;
    }
    
    
}
