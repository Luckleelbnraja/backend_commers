package com.example.e_commer.booking.controller;


import com.example.e_commer.booking.entity.Review;
import com.example.e_commer.booking.service.ReviewService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/review")
public class ReviewController {
    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }


    @PostMapping
    public Object create(@RequestBody Review review){
        return reviewService.create(review);
    }

    @GetMapping
    public Object getListRevview(){
        return reviewService.getListData();
    }

    @GetMapping("/{id}")
    public Object getDetailReview(@PathVariable("id") Long id){
        return reviewService.getDataDetail(id);
    }

    @DeleteMapping("/{id}")
    public void deleteReview(@PathVariable("id") Long id){
        reviewService.deleted(id);
    }
}
