package org.example.supermarketwebapp.DTOs;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.example.supermarketwebapp.Enums.OrderStatus;

import java.time.LocalDateTime;

@Data
@Builder
@Getter
@Setter
public class CustomerOrderDto {
    private int idOrder;
    private LocalDateTime orderDate;
    private String orderNumber;
    private OrderStatus orderStatus;
}
