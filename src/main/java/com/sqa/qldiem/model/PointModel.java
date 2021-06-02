package com.sqa.qldiem.model;

import java.util.Objects;

public class PointModel implements Comparable<PointModel> {

    private UserModel user = new UserModel();
    private SubclassroomModel subclass = new SubclassroomModel();
    private String semester;
    private double point1, point2, point3, point4;
    private double avgPoint;
    private String result;

    public PointModel() {
    }

    public PointModel(UserModel user, SubclassroomModel subclass, String semester, 
            double point1, double point2, double point3, double point4) {
        this.user = user;
        this.subclass = subclass;
        this.semester = semester;
        this.point1 = point1;
        this.point2 = point2;
        this.point3 = point3;
        this.point4 = point4;
    }
    
    public void setAvgPointAndResult() {
        SubjectModel subject = subclass.getSubject();
        double avgP = calAvgPoint(point1, point2, point3, point4, subject.getPoint1(), 
                subject.getPoint2(), subject.getPoint3(), subject.getPoint4());
        String res = calResult(avgP);
        
        setAvgPoint(avgP);
        setResult(res);
    }
    
    public double calAvgPoint(double p1, double p2, double p3, double p4, 
            int _p1, int _p2, int _p3, int _p4) {
        double temp = p1*_p1 + p2*_p2 + p3*_p3 + p4*_p4;
        temp = (double) temp/100;
        temp = (double) Math.round(temp*10)/10;
        
        return temp;
    }
    
    public String calResult(double avgP) {
        String res = "";
        if(avgP < 0) {
            res = "";
        } else if(avgP < 4) {
            res = "F";
        } else if(avgP >= 4 && avgP < 5) {
            res = "D";
        } else if(avgP >= 5 && avgP < 5.5) {
            res = "D+";
        } else if(avgP >= 5.5 && avgP < 6.5) {
            res = "C";
        } else if(avgP >= 6.5 && avgP < 7) {
            res = "C+";
        } else if(avgP >= 7 && avgP < 8) {
            res = "B";
        } else if(avgP >= 8 && avgP < 8.5) {
            res = "B+";
        } else if(avgP >= 8.5 && avgP < 9) {
            res = "A";
        } else if(avgP <= 10) {
            res = "A+";
        }
        return res;
    }

    public double getAvgPoint() {
        return avgPoint;
    }
    
    public void setAvgPoint(double avgPoint) {
        this.avgPoint = avgPoint;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }
    
    public SubclassroomModel getSubclass() {
        return subclass;
    }

    public void setSubclass(SubclassroomModel subclass) {
        this.subclass = subclass;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
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

    @Override
    public int compareTo(PointModel o) {
        if(this.avgPoint < o.avgPoint) {
            return 1;
        }
        return -1;
    }  

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.user);
        hash = 17 * hash + Objects.hashCode(this.subclass);
        hash = 17 * hash + Objects.hashCode(this.semester);
        hash = 17 * hash + (int) (Double.doubleToLongBits(this.point1) ^ (Double.doubleToLongBits(this.point1) >>> 32));
        hash = 17 * hash + (int) (Double.doubleToLongBits(this.point2) ^ (Double.doubleToLongBits(this.point2) >>> 32));
        hash = 17 * hash + (int) (Double.doubleToLongBits(this.point3) ^ (Double.doubleToLongBits(this.point3) >>> 32));
        hash = 17 * hash + (int) (Double.doubleToLongBits(this.point4) ^ (Double.doubleToLongBits(this.point4) >>> 32));
        hash = 17 * hash + (int) (Double.doubleToLongBits(this.avgPoint) ^ (Double.doubleToLongBits(this.avgPoint) >>> 32));
        hash = 17 * hash + Objects.hashCode(this.result);
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
        final PointModel other = (PointModel) obj;
        if (Double.doubleToLongBits(this.point1) != Double.doubleToLongBits(other.point1)) {
            return false;
        }
        if (Double.doubleToLongBits(this.point2) != Double.doubleToLongBits(other.point2)) {
            return false;
        }
        if (Double.doubleToLongBits(this.point3) != Double.doubleToLongBits(other.point3)) {
            return false;
        }
        if (Double.doubleToLongBits(this.point4) != Double.doubleToLongBits(other.point4)) {
            return false;
        }
        if (Double.doubleToLongBits(this.avgPoint) != Double.doubleToLongBits(other.avgPoint)) {
            return false;
        }
        if (!Objects.equals(this.semester, other.semester)) {
            return false;
        }
        if (!Objects.equals(this.result, other.result)) {
            return false;
        }
        if (!Objects.equals(this.user, other.user)) {
            return false;
        }
        if (!Objects.equals(this.subclass, other.subclass)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "PointModel{" + "user=" + user + ", subclass=" + subclass + ", semester=" + semester + ", point1=" + point1 + ", point2=" + point2 + ", point3=" + point3 + ", point4=" + point4 + ", avgPoint=" + avgPoint + ", result=" + result + '}';
    }

    
}
