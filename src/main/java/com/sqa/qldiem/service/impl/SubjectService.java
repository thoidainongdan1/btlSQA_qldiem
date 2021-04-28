/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sqa.qldiem.service.impl;

import com.sqa.qldiem.dao.ISubjectDAO;
import com.sqa.qldiem.model.SubjectModel;
import com.sqa.qldiem.service.ISubjectService;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author Administrator
 */
public class SubjectService implements ISubjectService {
    
    @Inject
    ISubjectDAO subjectDAO;

    @Override
    public List<SubjectModel> getAllSubject() {
        return subjectDAO.getAllSubject();
    }

    @Override
    public void updateSubject(SubjectModel subject) {
        subjectDAO.updateSubject(subject);
    }
    
}
