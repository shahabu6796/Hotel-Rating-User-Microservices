package com.msua.user.external;

import com.msua.user.entity.Hotel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "HOTEL-SERVICE")
public interface HotelService {
    @GetMapping("hotel/hotel/{id}")
    Hotel getHotel(@PathVariable String id);
}
