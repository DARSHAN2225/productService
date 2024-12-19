package dev.darshan.productservice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Builder
public class Product extends BaseModel{

    private String title;

    private String description;

    private String image;

    private double price;

    // product and category
    // 1:1
    // m:1
    @ManyToOne
    private Category category;
}
