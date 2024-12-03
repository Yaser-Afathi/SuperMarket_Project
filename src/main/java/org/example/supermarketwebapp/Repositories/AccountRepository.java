package org.example.supermarketwebapp.Repositories;

import org.example.supermarketwebapp.Entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account,Integer> {
}
