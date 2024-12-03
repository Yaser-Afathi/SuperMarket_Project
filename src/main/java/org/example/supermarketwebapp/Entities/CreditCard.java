package org.example.supermarketwebapp.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CreditCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idCreditCard;
    @OneToOne
    Address billingAddress;
    String cardNumber;
    int code;
    String nameOnCard;
    @OneToMany(mappedBy = "creditCard")
    List<Payment> paymentList;
    @OneToOne(cascade = CascadeType.ALL)
    Customer customer;

}
