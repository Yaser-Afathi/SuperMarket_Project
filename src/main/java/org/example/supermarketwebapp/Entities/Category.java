package org.example.supermarketwebapp.Entities;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idCategory;
    String name;
    @OneToMany(mappedBy = "category")
    List<Product> productsList;
    public Category(String name) {
        this.name=name;
    }

}
