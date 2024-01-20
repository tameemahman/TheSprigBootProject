package com.bootproject.H.B.dto;

import jakarta.persistence.*;
import lombok.Data;

@Data

public class ProductDTO {


    private Long id;
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", referencedColumnName = "category_id")
    private int categoryId;
    private  double price;
    private double weight;

    private String description;
    private String imageName;
}
