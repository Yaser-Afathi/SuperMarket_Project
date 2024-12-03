package org.example.supermarketwebapp.Repositories;

import org.example.supermarketwebapp.Entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {
}
