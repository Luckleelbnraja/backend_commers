package com.example.e_commer.booking.service;


import com.example.e_commer.booking.entity.Review;
import com.example.e_commer.booking.repository.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;

    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public Object create(Review review){
        return reviewRepository.save(review);
    }

    public Object getListData(){
        return reviewRepository.findAll();
    }

    public Object getDataDetail(Long id){
        return reviewRepository.findById(id).get();
    }

    public void deleted(Long id){
        Optional<Review> review = reviewRepository.findById(id);
        review.ifPresent(reviewRepository::delete);
    }
}
