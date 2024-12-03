package org.example.supermarketwebapp.Entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idAddress;
    String city;
    String state;
    String streetAddress;
    String zipcode;
    @OneToOne(mappedBy = "shippingAddress",cascade = CascadeType.ALL)
    Account account;
}
