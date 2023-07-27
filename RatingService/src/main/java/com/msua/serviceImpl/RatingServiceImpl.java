package com.msua.serviceImpl;

import com.msua.entity.Rating;
import com.msua.repository.RatingRepository;
import com.msua.service.RatingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RatingServiceImpl implements RatingService{
    private final RatingRepository ratingRepository;
    @Override
    public Rating getById(String id) {
        return ratingRepository.findById(id).orElseThrow(()->new RuntimeException("record not availble."));
    }

    @Override
    public List<Rating> getRatingByUserId(String userId) {
        return ratingRepository.findByUserId(userId);
    }

    @Override
    public Rating createRating(Rating rating) {
        return ratingRepository.save(rating);
    }

    @Override
    public List<Rating> getAllRatings() {
        return ratingRepository.findAll();
    }

    @Override
    public List<Rating> getRatingByHotelId(String hotelId) {
        return ratingRepository.findByHotelId(hotelId);
    }

    @Override
    public Rating updateRating(Rating rating) {
        Optional<Rating> optionalRating = ratingRepository.findById(rating.getRatingId());
        Rating dbRating = optionalRating.orElseThrow(() -> new RuntimeException("Rating for specified is not present"));
        dbRating.setRating(rating.getRating());
        dbRating.setFeedback(rating.getFeedback());
        dbRating.setHotelId(rating.getHotelId());
        dbRating.setUserId(rating.getUserId());
        return ratingRepository.save(dbRating);
    }
}