package com.sqa.qldiem.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.sqa.qldiem.model.RoleModel;
import com.sqa.qldiem.model.UserModel;

public class UserMapper implements RowMapper<UserModel> {

    @Override
    public UserModel mapRow(ResultSet resultSet) {
        try {
            UserModel user = new UserModel();
            user.setUserName(resultSet.getString("username"));
            user.setFullName(resultSet.getString("fullname"));
            user.setPassword(resultSet.getString("password"));
            user.setAddress(resultSet.getString("address"));
            user.setFaculty(resultSet.getString("faculty"));
            user.setPhone(resultSet.getString("phone"));
            user.setRoleId(resultSet.getLong("roleid"));
            user.setDateOfBirth(resultSet.getDate("dateOfBirth"));
            user.setGender(resultSet.getInt("gender"));
            user.setClassroom(resultSet.getString("classroom"));
            user.setStatus(resultSet.getInt("status"));
            try {
                RoleModel role = new RoleModel();
                role.setCode(resultSet.getString("code"));
                role.setName(resultSet.getString("name"));
                user.setRole(role);
            } catch (SQLException e) {
                System.out.print(e.getMessage());
            }
            return user;
        } catch (SQLException e) {
            return null;
        }
    }
}
