package org.example.supermarketwebapp.Entities;

import jakarta.persistence.*;
import lombok.*;
import org.example.supermarketwebapp.Enums.PaymentStatus;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idPayment;
    double amount;
    PaymentStatus paymentStatus;
    @OneToOne(mappedBy = "payment")
    CustomerOrder customerOrder;
    @ManyToOne
    CreditCard creditCard;
}
