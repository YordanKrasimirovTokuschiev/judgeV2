package com.softuni.judgev2.service.impl;

import com.softuni.judgev2.model.entity.Role;
import com.softuni.judgev2.model.entity.RoleNameEnum;
import com.softuni.judgev2.repository.RoleRepository;
import com.softuni.judgev2.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public void initRoles() {
        if (roleRepository.count() == 0) {
            Role admin = new Role(RoleNameEnum.ADMIN);
            Role user = new Role(RoleNameEnum.USER);

            roleRepository.save(admin);
            roleRepository.save(user);
        }
    }

    @Override
    public Role findRole(RoleNameEnum roleNameEnum) {
        return roleRepository
                .findByName(roleNameEnum)
                .orElse(null);
    }
}
