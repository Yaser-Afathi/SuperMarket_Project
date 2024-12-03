package org.example.supermarketwebapp.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder

public class Customer{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idCustomer;
    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "account_id")
    Account account;
    @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
    List<CustomerOrder> customerOrderList;
    @OneToOne(mappedBy = "customer",cascade = CascadeType.ALL)
    CreditCard creditCard;
    @OneToOne(cascade = CascadeType.ALL)
    ShoppingCart shoppingCart;
}
