package com.sqa.qldiem.model;

public class SubjectModel {

    private String name;
    private int quantity, point1, point2, point3, point4;
    private String semester;

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPoint1() {
        return point1;
    }

    public void setPoint1(int point1) {
        this.point1 = point1;
    }

    public int getPoint2() {
        return point2;
    }

    public void setPoint2(int point2) {
        this.point2 = point2;
    }

    public int getPoint3() {
        return point3;
    }

    public void setPoint3(int point3) {
        this.point3 = point3;
    }

    public int getPoint4() {
        return point4;
    }

    public void setPoint4(int point4) {
        this.point4 = point4;
    }

}
