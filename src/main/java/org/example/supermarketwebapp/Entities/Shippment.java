package org.example.supermarketwebapp.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Shippment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idShipment;
    LocalDateTime shipmentDate=LocalDateTime.now();
    @OneToOne(mappedBy = "shippment")
    CustomerOrder customerOrder;
}
