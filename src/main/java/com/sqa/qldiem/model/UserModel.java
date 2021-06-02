package com.sqa.qldiem.model;

import java.sql.Date;
import java.util.Objects;

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

    public UserModel() {
    }

    public UserModel(String userName, String fullName, String password, int status, 
            Long roleId, int gender, String address, String phone, String faculty, Date dateOfBirth, String classroom) {
        this.userName = userName;
        this.fullName = fullName;
        this.password = password;
        this.status = status;
        this.roleId = roleId;
        this.gender = gender;
        this.address = address;
        this.phone = phone;
        this.faculty = faculty;
        this.dateOfBirth = dateOfBirth;
        this.classroom = classroom;
    }

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

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.userName);
        hash = 29 * hash + Objects.hashCode(this.fullName);
        hash = 29 * hash + Objects.hashCode(this.password);
        hash = 29 * hash + this.status;
        hash = 29 * hash + Objects.hashCode(this.roleId);
        hash = 29 * hash + this.gender;
        hash = 29 * hash + Objects.hashCode(this.address);
        hash = 29 * hash + Objects.hashCode(this.phone);
        hash = 29 * hash + Objects.hashCode(this.faculty);
        hash = 29 * hash + Objects.hashCode(this.dateOfBirth);
        hash = 29 * hash + Objects.hashCode(this.classroom);
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
        final UserModel other = (UserModel) obj;
        if (this.status != other.status) {
            return false;
        }
        if (this.gender != other.gender) {
            return false;
        }
        if (!Objects.equals(this.userName, other.userName)) {
            return false;
        }
        if (!Objects.equals(this.fullName, other.fullName)) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        if (!Objects.equals(this.address, other.address)) {
            return false;
        }
        if (!Objects.equals(this.phone, other.phone)) {
            return false;
        }
        if (!Objects.equals(this.faculty, other.faculty)) {
            return false;
        }
        if (!Objects.equals(this.classroom, other.classroom)) {
            return false;
        }
        if (!Objects.equals(this.roleId, other.roleId)) {
            return false;
        }
        if (!Objects.equals(this.dateOfBirth, other.dateOfBirth)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "UserModel{" + "userName=" + userName + ", fullName=" + fullName + ", password=" + password + ", status=" + status + ", roleId=" + roleId + ", gender=" + gender + ", address=" + address + ", phone=" + phone + ", faculty=" + faculty + ", dateOfBirth=" + dateOfBirth + ", classroom=" + classroom + '}';
    }

    
}
