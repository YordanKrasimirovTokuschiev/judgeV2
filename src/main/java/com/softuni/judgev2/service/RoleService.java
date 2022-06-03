package com.softuni.judgev2.service;

import com.softuni.judgev2.model.entity.Role;
import com.softuni.judgev2.model.entity.RoleNameEnum;

public interface RoleService {
    void initRoles();

    Role findRole(RoleNameEnum roleNameEnum);
}
