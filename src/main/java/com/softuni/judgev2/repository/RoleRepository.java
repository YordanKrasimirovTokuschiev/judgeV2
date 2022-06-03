package com.softuni.judgev2.repository;

import com.softuni.judgev2.model.entity.Role;
import com.softuni.judgev2.model.entity.RoleNameEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleNameEnum roleNameEnum);
}
