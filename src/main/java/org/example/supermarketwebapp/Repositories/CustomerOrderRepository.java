package org.example.supermarketwebapp.Repositories;

import org.example.supermarketwebapp.Entities.CustomerOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerOrderRepository extends JpaRepository<CustomerOrder,Integer> {
}
