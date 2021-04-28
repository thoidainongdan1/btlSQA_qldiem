/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sqa.qldiem.model;

/**
 *
 * @author Administrator
 */
public class ResultModel {
    private UserModel user = new UserModel();
    private String semester;
    private double point;
    private String scholarship;
    
    public void fillScholarship() {
        String t = "";
        if(point >= 3.6) {
            t = "Xuất sắc";
        } else if(point >= 3.2) {
            t = "Giỏi";
        } else {
            t = "Khá";
        }
        setScholarship(t);
    }

    public String getScholarship() {
        return scholarship;
    }

    public void setScholarship(String scholarship) {
        this.scholarship = scholarship;
    }

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public double getPoint() {
        return point;
    }

    public void setPoint(double point) {
        this.point = point;
    }
    
    
}
