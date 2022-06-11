package com.softuni.judgev2.service;

import com.softuni.judgev2.model.entity.RoleNameEnum;
import com.softuni.judgev2.model.entity.User;
import com.softuni.judgev2.model.service.UserServiceModel;
import com.softuni.judgev2.model.view.UserProfileViewModel;

import java.util.List;

public interface UserService {
    void registerUser(UserServiceModel userServiceModel);

    UserServiceModel findUserByUsernameAndPassword(String username, String password);

    void login(UserServiceModel userServiceModel);

    void logout();

    List<String> findAllUsernames();

    void changeRole(String username, RoleNameEnum roleNameEnum);

    User findById(Long id);

    UserProfileViewModel findProfileById(Long id);

    Long findUsersCount();
}
