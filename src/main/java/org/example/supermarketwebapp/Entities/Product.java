package org.example.supermarketwebapp.Entities;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idProduct;
    @Nullable
    String name;
    @Nullable
    Double price;
    @Nullable
    @Column(length = 1000)
    String description;
    @Nullable
    int availableUnits;
    @Nullable
    String imageUrl;
    @ManyToOne
    @Nullable
    Category category;
    @OneToMany(mappedBy = "product")
    List<ProductReview> productReviewList;
    public Product( String name, double price, String description, int availableUnits) {

        this.name=name;
        this.price=price;
        this.description=description;
        this.availableUnits=availableUnits;
    }
}
