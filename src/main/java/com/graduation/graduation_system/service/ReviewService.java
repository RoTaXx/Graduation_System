package com.graduation.graduation_system.service;

import com.graduation.graduation_system.dto.Review.CreateReviewDTO;
import com.graduation.graduation_system.dto.Review.ReviewDTO;
import com.graduation.graduation_system.dto.Review.UpdateReviewDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;

import java.util.List;

public interface ReviewService {
    List<ReviewDTO> getReviews();

    ReviewDTO getReviewById(@Min(1) Long id);

    CreateReviewDTO createReview(@Valid CreateReviewDTO createReviewDTO);

    UpdateReviewDTO updateReview(Long id, UpdateReviewDTO updateReviewDTO);

    void deleteReview(Long id);
}
