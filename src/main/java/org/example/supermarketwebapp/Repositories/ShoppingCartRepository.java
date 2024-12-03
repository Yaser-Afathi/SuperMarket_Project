package org.example.supermarketwebapp.Repositories;

import org.example.supermarketwebapp.Entities.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCart,Integer> {
}
