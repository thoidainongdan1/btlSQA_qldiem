/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sqa.qldiem.dao;

import com.sqa.qldiem.model.SubjectModel;
import java.util.List;

/**
 *
 * @author Administrator
 */
public interface ISubjectDAO {
    List<SubjectModel> getAllSubject();
    Long addSubject(SubjectModel subject);
    void updateSubject(SubjectModel subject);
    void deleteSubject(String name);
    SubjectModel findSubjectByName(String name);
}
