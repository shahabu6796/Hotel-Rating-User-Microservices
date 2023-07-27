package com.msua.user.service;

import com.msua.user.entity.Hotel;
import com.msua.user.entity.Rating;
import com.msua.user.entity.User;
import com.msua.user.external.HotelService;
import com.msua.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final RestTemplate restTemplate;
    private final HotelService hotelService;
    private Logger logger = LoggerFactory.getLogger(User.class);

    @Override
    public User saveUser(User user) {
        //apply validation if needed
        String userId = UUID.randomUUID().toString();
        user.setUserId(userId);
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(String userId) {
        //fetching user from database with the help of UserRepository
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found for the given id " + userId));

        //fetching ratings given by user from RATING-SERVICE
        // String ratingUrl = "http://localhost:8086/rating/users/" + userId;
        //instead on hardcoded url using service name
        String ratingUrl = "http://RATING-SERVICE/rating/users/" + userId;
        var userRatings = restTemplate.getForObject(ratingUrl, Rating[].class);
        List<Rating> ratings = Arrays.stream(userRatings).toList();
        logger.info("{} ", ratings);
        List<Rating> ratingsWithHotel = ratings.stream().map(rating -> {
            //logger.info("This is {} ", rating.getHotelId());
            // fetching hotel
            // String hotelFetchingUrl = "http://localhost:8082/hotel/hotel/" + rating.getHotelId();
            //insted on hardcoded url using service name
            //String hotelFetchingUrl = "http://HOTEL-SERVICE/hotel/hotel/" + rating.getHotelId();

            //calling hotel service using feign clinet web client
            //fetching hotel from HOTEL_SERVICE

            Hotel hotel = hotelService.getHotel(rating.getHotelId());
//            ResponseEntity<Hotel> forEntity = restTemplate.getForEntity(hotelFetchingUrl, Hotel.class);

//            rating.setHotel(forEntity.getBody());
            rating.setHotel(hotel);
            return rating;
        }).toList();
        user.setRatings(ratingsWithHotel);
        return user;
    }

    @Override
    public ResponseEntity<String> deleteUser(String userId) {
        return null;
    }

    @Override
    public ResponseEntity<String> updateUser(String userId) {
        return null;
    }
}
