package com.softuni.judgev2.repository;

import com.softuni.judgev2.model.entity.Homework;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HomeworkRepository extends JpaRepository<Homework, Long> {

    Optional<Homework> findTop1ByOrderByComments();
}
