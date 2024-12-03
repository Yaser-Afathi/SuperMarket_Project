package org.example.supermarketwebapp.Repositories;

import org.example.supermarketwebapp.Entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuestRepository extends JpaRepository<Account,Integer> {
}
