package com.msua.user.external;

import com.msua.user.entity.Hotel;
import com.msua.user.entity.Rating;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "RATING-SERVICE")
public interface RatingService {
    @PutMapping("hotel/update")
    Hotel getHotel(@PathVariable String id, @RequestBody Rating rating);
}
