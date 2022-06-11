package com.softuni.judgev2.repository;

import com.softuni.judgev2.model.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    @Query("select avg(c.score) from Comment c")
    Double findAvgScore();
}
