package com.sqa.qldiem.mapper;

import com.sqa.qldiem.model.PointModel;
import com.sqa.qldiem.model.SubclassroomModel;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.sqa.qldiem.model.UserModel;

public class PointMapper implements RowMapper<PointModel> {

    @Override
    public PointModel mapRow(ResultSet resultSet) {
        try {
            PointModel point = new PointModel();
            point.setSemester(resultSet.getString("semester"));
            point.setPoint1(resultSet.getDouble("p.point1"));
            point.setPoint2(resultSet.getDouble("p.point2"));
            point.setPoint3(resultSet.getDouble("p.point3"));
            point.setPoint4(resultSet.getDouble("p.point4"));
            try {
                UserModel user = new UserModel();
                user.setUserName(resultSet.getString("username"));
                user.setFullName(resultSet.getString("fullname"));
                user.setFaculty(resultSet.getString("faculty"));
                user.setClassroom(resultSet.getString("classroom"));
                user.setDateOfBirth(resultSet.getDate("dateOfBirth"));
                user.setGender(resultSet.getInt("gender"));
                point.setUser(user);
                
                SubclassroomModel subclass = new SubclassroomMapper().mapRow(resultSet);
                point.setSubclass(subclass);
            } catch (SQLException e) {
                return null;
            }
            return point;
        } catch (SQLException e) {
            return null;
        }
    }
}
