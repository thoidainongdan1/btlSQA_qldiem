package com.sqa.qldiem.model;

public class PointModel implements Comparable<PointModel> {

    private UserModel user = new UserModel();
    private SubclassroomModel subclass = new SubclassroomModel();
    private String semester;
    private double point1, point2, point3, point4;
    private double avgPoint;
    private String result;

    public void calculate() {
        SubjectModel subject = subclass.getSubject();
        double temp = point1*subject.getPoint1()+point2*subject.getPoint2()+point3*subject.getPoint3()+point4*subject.getPoint4();
        temp = (double) temp/100;
        temp = (double) Math.round(temp*10)/10;
        setAvgPoint(temp);
        
        String res = "";
        if(temp < 4) {
            res = "F";
        } else if(temp >= 4 && temp < 5) {
            res = "D";
        } else if(temp >= 5 && temp < 5.5) {
            res = "D+";
        } else if(temp >= 5.5 && temp < 6.5) {
            res = "C";
        } else if(temp >= 6.5 && temp < 7) {
            res = "C+";
        } else if(temp >= 7 && temp < 8) {
            res = "B";
        } else if(temp >= 8 && temp < 8.5) {
            res = "B+";
        } else if(temp >= 8.5 && temp < 9) {
            res = "A";
        } else {
            res = "A+";
        }
        setResult(res);
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
}
