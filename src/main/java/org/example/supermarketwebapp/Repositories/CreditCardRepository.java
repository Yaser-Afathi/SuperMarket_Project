package org.example.supermarketwebapp.Repositories;

import org.example.supermarketwebapp.Entities.CreditCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CreditCardRepository extends JpaRepository<CreditCard,Integer> {
}
