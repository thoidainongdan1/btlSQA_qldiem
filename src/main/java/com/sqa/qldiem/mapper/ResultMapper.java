package com.sqa.qldiem.mapper;

import com.sqa.qldiem.model.ResultModel;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.sqa.qldiem.model.UserModel;

public class ResultMapper implements RowMapper<ResultModel> {

    @Override
    public ResultModel mapRow(ResultSet resultSet) {
        try {
            ResultModel result = new ResultModel();
            result.setSemester(resultSet.getString("semester"));
            result.setPoint(resultSet.getDouble("point"));
            try {
                UserModel user = new UserModel();
                user.setUserName(resultSet.getString("username"));
                user.setFullName(resultSet.getString("fullname"));
                user.setFaculty(resultSet.getString("faculty"));
                user.setClassroom(resultSet.getString("classroom"));
                user.setDateOfBirth(resultSet.getDate("dateOfBirth"));
                user.setGender(resultSet.getInt("gender"));
                result.setUser(user);
            } catch (SQLException e) {
                return null;
            }
            return result;
        } catch (SQLException e) {
            return null;
        }
    }
}
