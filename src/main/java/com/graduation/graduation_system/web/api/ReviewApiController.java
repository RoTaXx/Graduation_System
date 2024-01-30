package com.graduation.graduation_system.web.api;

import com.graduation.graduation_system.dto.Review.CreateReviewDTO;
import com.graduation.graduation_system.dto.Review.ReviewDTO;
import com.graduation.graduation_system.dto.Review.UpdateReviewDTO;
import com.graduation.graduation_system.service.ReviewService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
public class ReviewApiController {

    private final ReviewService reviewService;

    public ReviewApiController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping
    public List<ReviewDTO> getReviews() {
        return reviewService.getReviews();
    }

    @PostMapping
    public CreateReviewDTO createReview(@RequestBody CreateReviewDTO createReviewDTO) {
        return reviewService.createReview(createReviewDTO);
    }

    @GetMapping("/{id}")
    public ReviewDTO getReviewById(@PathVariable Long id) {
        return reviewService.getReviewById(id);
    }

    @PutMapping("/{id}")
    public UpdateReviewDTO updateReview(@PathVariable Long id, @RequestBody UpdateReviewDTO updateReviewDTO) {
        return reviewService.updateReview(id, updateReviewDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReview(@PathVariable Long id) {
        reviewService.deleteReview(id);
        return ResponseEntity.noContent().build();
    }

}
