/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sqa.qldiem.dao.impl;

import com.sqa.qldiem.dao.IPointDAO;
import com.sqa.qldiem.mapper.PointMapper;
import com.sqa.qldiem.model.PointModel;
import java.util.List;

/**
 *
 * @author Administrator
 */
public class PointDAO extends AbstractDAO<PointModel> implements IPointDAO {

    @Override
    public List<PointModel> findBySemesterAndFacultyAndSubjectClassroom(String semester, String faculty, String subjectClass) {
        String sql = "SELECT * FROM point as p "
                + "INNER JOIN user AS u ON p.userid = u.id "
                + "INNER JOIN subclassroom AS s ON p.subclassroomid = s.id "
                + "INNER JOIN subject AS st ON s.subjectid = st.id "
                + "WHERE roleid = 3 AND semester = ? AND faculty = ? AND cname = ?";
        List<PointModel> points = query(sql, new PointMapper(), semester, faculty, subjectClass);
        return points;
    }

}
