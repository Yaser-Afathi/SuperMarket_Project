package org.example.supermarketwebapp.DTOs;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Builder
@Getter
@Setter
public class CategoryDto {
    private int idCategory;
    private String name;
}
