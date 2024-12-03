package org.example.supermarketwebapp.Entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ProductReview {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idReview;
    int rating;
    String review;
    @ManyToOne
    Customer customer;
    @ManyToOne
    Product product;
}
