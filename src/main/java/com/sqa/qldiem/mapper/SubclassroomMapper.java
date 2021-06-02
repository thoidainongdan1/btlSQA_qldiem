/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sqa.qldiem.mapper;

import com.sqa.qldiem.model.SubclassroomModel;
import com.sqa.qldiem.model.SubjectModel;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Administrator
 */
public class SubclassroomMapper implements RowMapper<SubclassroomModel> {

    @Override
    public SubclassroomModel mapRow(ResultSet rs) {
        try {
            SubclassroomModel subclass = new SubclassroomModel();
            subclass.setCname(rs.getString("cname"));
            try {
                SubjectModel subject = new SubjectModel();
                subject.setName(rs.getString("st.name"));
                subject.setQuantity(rs.getInt("st.quantity"));
                subject.setPoint1(rs.getInt("st.point1"));
                subject.setPoint2(rs.getInt("st.point2"));
                subject.setPoint3(rs.getInt("st.point3"));
                subject.setPoint4(rs.getInt("st.point4"));
                subclass.setSubject(subject);
            } catch (SQLException e) {
                return null;
            }
            return subclass;
        } catch (SQLException e) {
            return null;
        }

    }

}
