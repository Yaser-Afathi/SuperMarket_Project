package org.example.supermarketwebapp.Repositories;

import org.example.supermarketwebapp.Entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Integer> {
}
