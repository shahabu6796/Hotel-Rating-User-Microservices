package com.msua.controller;

import com.msua.entity.Rating;
import com.msua.service.RatingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/rating")
public class RatingController {
    private final RatingService ratingService;
    @PostMapping("/save")
    public Rating saveRating(@RequestBody Rating rating){
        return ratingService.createRating(rating);
    }
    @GetMapping("/getall")
    public List<Rating> getAllRatings(){
        return ratingService.getAllRatings();
    }
    @GetMapping("/rating/{id}")
    public Rating getRatingById(@PathVariable String id){
        return ratingService.getById(id);
    }

    @GetMapping("/users/{userId}")
    public List<Rating> getRatingByUserId(@PathVariable String userId){
        return ratingService.getRatingByUserId(userId);
    }
    @GetMapping("/hotels/{hotelId}")
    public List<Rating> getRatingByHotelId(@PathVariable String hotelId){
        return ratingService.getRatingByHotelId(hotelId);
    }
    @PutMapping("/update")
    public Rating updateRating(@RequestBody Rating rating){
        return ratingService.updateRating(rating);
    }
}
