/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sqa.qldiem.service;

import com.sqa.qldiem.model.SubjectModel;
import java.util.List;

/**
 *
 * @author Administrator
 */
public interface ISubjectService {
    List<SubjectModel> getAllSubject();
    Long addSubject(SubjectModel subject);
    void updateSubject(SubjectModel subject);
    void deleteSubject(String name);
    SubjectModel findSubjectByName(String name);
}
