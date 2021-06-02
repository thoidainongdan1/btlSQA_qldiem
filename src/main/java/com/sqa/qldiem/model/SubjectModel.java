package com.sqa.qldiem.model;

import java.util.Objects;

public class SubjectModel {

    private String name;
    private int quantity, point1, point2, point3, point4;

    public SubjectModel() {
    }

    public SubjectModel(String name, int quantity, int point1, int point2, int point3, int point4) {
        this.name = name;
        this.quantity = quantity;
        this.point1 = point1;
        this.point2 = point2;
        this.point3 = point3;
        this.point4 = point4;
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.name);
        hash = 97 * hash + this.quantity;
        hash = 97 * hash + this.point1;
        hash = 97 * hash + this.point2;
        hash = 97 * hash + this.point3;
        hash = 97 * hash + this.point4;
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
        final SubjectModel other = (SubjectModel) obj;
        if (this.quantity != other.quantity) {
            return false;
        }
        if (this.point1 != other.point1) {
            return false;
        }
        if (this.point2 != other.point2) {
            return false;
        }
        if (this.point3 != other.point3) {
            return false;
        }
        if (this.point4 != other.point4) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "SubjectModel{" + "name=" + name + ", quantity=" + quantity + ", point1=" + point1 + ", point2=" + point2 + ", point3=" + point3 + ", point4=" + point4 + '}';
    }

    
}
