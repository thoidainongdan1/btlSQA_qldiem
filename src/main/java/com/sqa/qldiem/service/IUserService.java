package com.sqa.qldiem.service;

import com.sqa.qldiem.model.UserModel;
import java.util.List;

public interface IUserService {

    UserModel findByUserNameAndPasswordAndStatus(String userName, String password, Integer status);
    UserModel findByUserName(String userName);
    List<UserModel> getAllUser();
    Long addUser(UserModel user);
    void updateUser(UserModel user);
    void removeUser(String userName);
}
