package com.msua.user.payload;

import lombok.*;
import org.springframework.http.HttpStatus;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ResponseApi {
    private String message;
    private boolean success;
    private HttpStatus status;
}
