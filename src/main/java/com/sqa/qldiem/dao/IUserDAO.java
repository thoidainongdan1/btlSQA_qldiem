package com.sqa.qldiem.dao;

import com.sqa.qldiem.model.UserModel;
import java.util.List;

public interface IUserDAO {

    UserModel findByUserNameAndPasswordAndStatus(String userName, String password, Integer status);
    UserModel findByUserName(String userName);
    List<UserModel> getAllUser();
    Long addUser(UserModel user);
    void updateUser(UserModel user);
    void removeUser(String userName);
}
