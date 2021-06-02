package com.sqa.qldiem.service.impl;

import com.sqa.qldiem.dao.IUserDAO;
import com.sqa.qldiem.dao.impl.UserDAO;
import com.sqa.qldiem.model.UserModel;
import com.sqa.qldiem.service.IUserService;
import java.util.List;
import javax.inject.Inject;

public class UserService implements IUserService {

    @Inject
    private IUserDAO userDAO;

    @Override
    public UserModel findByUserNameAndPasswordAndStatus(String userName, String password, Integer status) {
        return userDAO.findByUserNameAndPasswordAndStatus(userName, password, status);
    }

    @Override
    public Long addUser(UserModel user) {
        return userDAO.addUser(user);
    }

    @Override
    public UserModel findByUserName(String userName) {
        return userDAO.findByUserName(userName);
    }

    @Override
    public void updateUser(UserModel user) {
        userDAO.updateUser(user);
    }

    @Override
    public void removeUser(String userName) {
        userDAO.removeUser(userName);
    }

    @Override
    public List<UserModel> getUsersByRole(int roleId) {
        return userDAO.getUsersByRole(roleId);
    }

    public void setDAO() {
        userDAO = new UserDAO();
    }
}
