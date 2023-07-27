package com.msua.user.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @Column(name = "ID")
    private String userId = "";
    private String name = "";
    private String email = "";
    private String about = "";

    @Transient
    private List<Rating> ratings = new ArrayList<>();
}
