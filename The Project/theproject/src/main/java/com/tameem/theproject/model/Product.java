package com.tameem.theproject.model;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    private double price;

    private int quantityAvailable;

    private String imageURL; // This field stores the URL of the image


    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;
}
