package com.graduation.graduation_system.service.impl;

import com.graduation.graduation_system.data.entity.Review;
import com.graduation.graduation_system.data.entity.Teacher;
import com.graduation.graduation_system.data.entity.Thesis;
import com.graduation.graduation_system.data.repository.ReviewRepository;
import com.graduation.graduation_system.data.repository.TeacherRepository;
import com.graduation.graduation_system.data.repository.ThesisRepository;
import com.graduation.graduation_system.dto.Review.CreateReviewDTO;
import com.graduation.graduation_system.dto.Review.ReviewDTO;
import com.graduation.graduation_system.dto.Review.UpdateReviewDTO;
import com.graduation.graduation_system.exceptions.ReviewNotFoundException;
import com.graduation.graduation_system.service.ReviewService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Validated
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;
    private final ThesisRepository thesisRepository;
    private final TeacherRepository teacherRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<ReviewDTO> getReviews() {
        return reviewRepository.findAll().stream()
                .map(this::convertToReviewDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ReviewDTO getReviewById(@Min(1) Long id) {
        return modelMapper.map(reviewRepository.findById(id)
                .orElseThrow(() -> new ReviewNotFoundException("Invalid Review Id:" + id)), ReviewDTO.class);
    }

    @Override
    public CreateReviewDTO createReview(@Valid CreateReviewDTO createReviewDTO) {
        Thesis thesis = thesisRepository.findById(createReviewDTO.getThesisId())
                .orElseThrow(() -> new RuntimeException("Invalid Thesis Id:" + createReviewDTO.getThesisId()));

        if (!createReviewDTO.isPositive() || !thesisHasPositiveReview(thesis)) {
            Teacher teacher = teacherRepository.findById(createReviewDTO.getTeacherId())
                    .orElseThrow(() -> new RuntimeException("Invalid Teacher Id:" + createReviewDTO.getTeacherId()));

            Review review = modelMapper.map(createReviewDTO, Review.class);
            review.setThesis(thesis);
            review.setTeacher(teacher);

            return modelMapper.map(reviewRepository.save(review), CreateReviewDTO.class);
        } else {
            throw new RuntimeException("Thesis already has a positive review. Cannot create another review.");
        }
    }

    @Override
    public UpdateReviewDTO updateReview(Long id, UpdateReviewDTO updateReviewDTO) {
        Review review = modelMapper.map(getReviewById(id), Review.class);

        review.setText(updateReviewDTO.getText());
        review.setPositive(updateReviewDTO.isPositive());

        return modelMapper.map(reviewRepository.save(review), UpdateReviewDTO.class);
    }

    @Override
    public void deleteReview(Long id) {
        reviewRepository.deleteById(id);
    }


    private ReviewDTO convertToReviewDTO(Review review) {
        return modelMapper.map(review, ReviewDTO.class);
    }

    private boolean thesisHasPositiveReview(Thesis thesis) {
        return reviewRepository.existsByThesisAndIsPositiveTrue(thesis);
    }
}

