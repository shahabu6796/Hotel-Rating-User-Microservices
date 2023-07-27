package com.msua.service;

import com.msua.entity.Rating;

import java.util.List;

public interface RatingService {
    Rating getById(String id);
    List<Rating> getRatingByUserId(String userId);

    Rating createRating(Rating rating);

    List<Rating> getAllRatings();

    List<Rating> getRatingByHotelId(String hotelId);

    Rating updateRating(Rating rating);
}