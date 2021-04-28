package com.sqa.qldiem.model;

import java.sql.Date;

public class UserModel {

    private String userName;
    private String fullName;
    private String password;
    private int status;
    private RoleModel role = new RoleModel();
    private Long roleId;
    private int gender;
    private String address;
    private String phone;
    private String faculty;
    private Date dateOfBirth;
    private String classroom;

    public String getClassroom() {
        if(classroom != null) {
            return classroom;
        }
        return "";
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getAddress() {
        if(address != null) {
            return address;
        }
        return "";
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        if(phone != null) {
            return phone;
        }
        return "";
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFaculty() {
        if(faculty != null) {
            return faculty;
        }
        return "";
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public RoleModel getRole() {
        return role;
    }

    public void setRole(RoleModel role) {
        this.role = role;
    }
}
