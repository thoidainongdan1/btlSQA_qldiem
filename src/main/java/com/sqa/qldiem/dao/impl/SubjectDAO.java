/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sqa.qldiem.dao.impl;

import com.sqa.qldiem.dao.ISubjectDAO;
import com.sqa.qldiem.mapper.SubjectMapper;
import com.sqa.qldiem.model.SubjectModel;
import java.util.List;

/**
 *
 * @author Administrator
 */
public class SubjectDAO extends AbstractDAO<SubjectModel> implements ISubjectDAO {

    @Override
    public List<SubjectModel> getAllSubject() {
        String sql = "SELECT * from subject";
        List<SubjectModel> list = query(sql, new SubjectMapper());
        return list;
    }

    @Override
    public void updateSubject(SubjectModel subject) {
        String sql = "UPDATE subject SET quantity = ?, point1 = ?, point2 = ?, "
                + "point3 = ?, point4 = ? WHERE name = ?";
        update(sql, subject.getQuantity(), subject.getPoint1(), subject.getPoint2(), 
                subject.getPoint3(), subject.getPoint4(), subject.getName());
    }
    
}
