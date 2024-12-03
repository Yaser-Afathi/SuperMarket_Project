package org.example.supermarketwebapp.DTOs;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@Builder
public class ProductReviewDto {
    private int idReview;
    private int rating;
    private String review;
    // Other fields as needed
    // Getters and setters
}
