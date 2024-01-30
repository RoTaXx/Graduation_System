package com.graduation.graduation_system.config;

import com.graduation.graduation_system.data.entity.Review;
import com.graduation.graduation_system.dto.Review.CreateReviewDTO;
import com.graduation.graduation_system.dto.Review.UpdateReviewDTO;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        // Explicitly exclude the setId() method from BaseEntity
        modelMapper.createTypeMap(CreateReviewDTO.class, Review.class)
                .addMappings(mapper -> mapper.skip(Review::setId));


        return modelMapper;
    }
}
