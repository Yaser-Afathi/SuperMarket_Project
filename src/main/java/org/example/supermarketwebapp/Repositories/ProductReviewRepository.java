package org.example.supermarketwebapp.Repositories;

import org.example.supermarketwebapp.Entities.ProductReview;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductReviewRepository extends JpaRepository<ProductReview,Integer> {
}
