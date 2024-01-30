package com.graduation.graduation_system.data.repository;

import com.graduation.graduation_system.data.entity.Review;
import com.graduation.graduation_system.data.entity.Thesis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {

    List<Review> findByThesis(Thesis thesis);

    @Query("SELECT r FROM Review r WHERE r.thesis = :thesis AND r.isPositive = true")
    List<Review> findPositiveReviewsByThesis(@Param("thesis") Thesis thesis);

    boolean existsByThesisAndIsPositiveTrue(Thesis thesis);

    long countByIsPositiveIsFalse();
}
