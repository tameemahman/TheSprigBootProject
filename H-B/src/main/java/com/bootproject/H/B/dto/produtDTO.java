package com.bootproject.H.B.dto;

import com.bootproject.H.B.model.Category;
import jakarta.persistence.*;
import lombok.Data;

@Data

public class produtDTO {


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
