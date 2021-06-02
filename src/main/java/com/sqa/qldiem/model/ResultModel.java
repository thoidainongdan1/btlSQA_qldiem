/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sqa.qldiem.model;

import java.util.Objects;

/**
 *
 * @author Administrator
 */
public class ResultModel {

    private UserModel user = new UserModel();
    private String semester;
    private double point;
    private String scholarship;

    public ResultModel() {
    }

    public ResultModel(UserModel user, String semester, double point) {
        this.user = user;
        this.semester = semester;
        this.point = point;
    }

    public void fillScholarship() {
        setScholarship(calScholarship(point));
    }

    public String calScholarship(double p) {
        String t = "";
        if (p > 4) {
            t = "";
        } else if (p >= 3.6) {
            t = "Xuất sắc";
        } else if (p >= 3.2) {
            t = "Giỏi";
        } else if (p >= 2.5) {
            t = "Khá";
        }
        return t;
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

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + Objects.hashCode(this.user);
        hash = 83 * hash + Objects.hashCode(this.semester);
        hash = 83 * hash + (int) (Double.doubleToLongBits(this.point) ^ (Double.doubleToLongBits(this.point) >>> 32));
        hash = 83 * hash + Objects.hashCode(this.scholarship);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ResultModel other = (ResultModel) obj;
        if (Double.doubleToLongBits(this.point) != Double.doubleToLongBits(other.point)) {
            return false;
        }
        if (!Objects.equals(this.semester, other.semester)) {
            return false;
        }
        if (!Objects.equals(this.scholarship, other.scholarship)) {
            return false;
        }
        if (!Objects.equals(this.user, other.user)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ResultModel{" + "user=" + user + ", semester=" + semester + ", point=" + point + ", scholarship=" + scholarship + '}';
    }

}
