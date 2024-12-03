package org.example.supermarketwebapp.Entities;

import jakarta.persistence.*;
import lombok.*;
import org.example.supermarketwebapp.Enums.AccountStatus;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    int idAccount;
    String name;
    String username;
    String password;
    String phone;
    @OneToOne(cascade = CascadeType.ALL)
    Address shippingAddress;
    AccountStatus accountStatus;
    String email;
    @OneToOne(mappedBy = "account",cascade = CascadeType.ALL)
    Customer customer;
}
