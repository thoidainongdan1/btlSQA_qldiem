package com.sqa.qldiem.mapper;

import com.sqa.qldiem.model.SubjectModel;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SubjectMapper implements RowMapper<SubjectModel> {

    @Override
    public SubjectModel mapRow(ResultSet resultSet) {
        try {
            SubjectModel subject = new SubjectModel();
            subject.setName(resultSet.getString("name"));
            subject.setQuantity(resultSet.getInt("quantity"));
            subject.setPoint1(resultSet.getInt("point1"));
            subject.setPoint2(resultSet.getInt("point2"));
            subject.setPoint3(resultSet.getInt("point3"));
            subject.setPoint4(resultSet.getInt("point4"));
            return subject;
        } catch (SQLException e) {
            return null;
        }
    }
}
