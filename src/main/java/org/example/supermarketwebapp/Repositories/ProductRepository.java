package org.example.supermarketwebapp.Repositories;

import org.example.supermarketwebapp.Entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Integer> {
    @Query("SELECT p FROM Product p " +

            "LEFT JOIN FETCH p.category " +

            "WHERE p.name LIKE %:searchTerm% OR p.category.name LIKE %:searchTerm%")

    List<Product> findBySearchTerm(@Param("searchTerm") String searchTerm);}
