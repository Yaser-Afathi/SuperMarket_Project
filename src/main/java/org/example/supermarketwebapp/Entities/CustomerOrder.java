package org.example.supermarketwebapp.Entities;

import jakarta.persistence.*;
import lombok.*;
import org.example.supermarketwebapp.Enums.OrderStatus;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class CustomerOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idOrder;
    @Temporal(TemporalType.TIMESTAMP)
    LocalDateTime orderDate=LocalDateTime.now();
    String orderNumber;
    OrderStatus orderStatus;
    @OneToOne
    Payment payment;
    @OneToOne
    Shippment shippment;
    @ManyToOne
    Customer customer;
    @OneToMany(mappedBy = "customerOrder", cascade = CascadeType.ALL)
    private List<OrderItem> orderItems;
}
