package com.bootproject.H.B.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data

public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private  int id;

    private  String name;
}
