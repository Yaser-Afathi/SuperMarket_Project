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
public class ShoppingCart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idCart;
    @OneToMany(mappedBy = "shoppingCart", cascade = CascadeType.ALL)
    List<CartItem> cartItems;
}
