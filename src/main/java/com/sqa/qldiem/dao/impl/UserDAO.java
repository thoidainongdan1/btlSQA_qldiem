package com.sqa.qldiem.dao.impl;

import java.util.List;

import com.sqa.qldiem.dao.IUserDAO;
import com.sqa.qldiem.mapper.UserMapper;
import com.sqa.qldiem.model.UserModel;

public class UserDAO extends AbstractDAO<UserModel> implements IUserDAO {

    @Override
    public UserModel findByUserNameAndPasswordAndStatus(String userName, String password, Integer status) {
        String sql = "SELECT * FROM user AS u INNER JOIN role AS r "
                + "ON r.id = u.roleid WHERE username = ? AND password = ? AND status = ?";
        List<UserModel> users = query(sql, new UserMapper(), userName, password, status);
        return users.isEmpty() ? null : users.get(0);
    }

    @Override
    public List<UserModel> getAllUser() {
        String sql = "SELECT * FROM user AS u INNER JOIN role AS r ON r.id = u.roleid WHERE status = 1 "
                + "ORDER BY roleid, username";
        List<UserModel> users = query(sql, new UserMapper());
        return users;
    }

    @Override
    public Long addUser(UserModel user) {
        user.setStatus(1);
        String sql = "INSERT INTO user (username, password, fullname, "
                + "address, faculty, phone, dateOfBirth, gender, status, roleid) "
                + "VALUES (?,?,?,?,?,?,?,?,?,?)";
        return insert(sql, user.getUserName(), user.getPassword(), user.getFullName(),
                user.getAddress(), user.getFaculty(), user.getPhone(), user.getDateOfBirth(),
                user.getGender(), user.getStatus(), user.getRoleId());
    }

    @Override
    public UserModel findByUserName(String userName) {
        String sql = "SELECT * FROM user AS u INNER JOIN role AS r "
                + "ON r.id = u.roleid WHERE username = ?";
        List<UserModel> users = query(sql, new UserMapper(), userName);
        return users.isEmpty() ? null : users.get(0);
    }

    @Override
    public void updateUser(UserModel user) {
        String sql = "UPDATE user SET password = ?, fullname = ?, "
                + "address = ?, faculty = ?, phone = ?, dateOfBirth = ?, gender = ?, roleid = ? "
                + "WHERE username = ?";
        update(sql, user.getPassword(), user.getFullName(),
                user.getAddress(), user.getFaculty(), user.getPhone(), user.getDateOfBirth(), 
                user.getGender(), user.getRoleId(), user.getUserName());
    }

    @Override
    public void removeUser(String userName) {
        String sql = "UPDATE user SET status = 0 WHERE username = ?";
        update(sql, userName);
    }

    @Override
    public List<UserModel> getUsersByRole(int roleId) {
        String sql = "SELECT * FROM user "
                + "WHERE roleId = ? and status = 1 "
                + "ORDER BY username";
        List<UserModel> users = query(sql, new UserMapper(), roleId);
        return users;
    }
}
