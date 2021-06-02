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
public class SubclassroomModel {
    private SubjectModel subject = new SubjectModel();
    private String cname;

    public SubclassroomModel() {
    }
    
    public SubclassroomModel(SubjectModel subject, String cname) {
        this.subject = subject;
        this.cname = cname;
    }

    public SubjectModel getSubject() {
        return subject;
    }

    public void setSubject(SubjectModel subject) {
        this.subject = subject;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.subject);
        hash = 89 * hash + Objects.hashCode(this.cname);
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
        final SubclassroomModel other = (SubclassroomModel) obj;
        if (!Objects.equals(this.cname, other.cname)) {
            return false;
        }
        if (!Objects.equals(this.subject, other.subject)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "SubclassroomModel{" + "subject=" + subject + ", cname=" + cname + '}';
    }

    
}
