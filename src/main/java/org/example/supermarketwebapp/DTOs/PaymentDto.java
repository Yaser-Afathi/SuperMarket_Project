package org.example.supermarketwebapp.DTOs;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.example.supermarketwebapp.Enums.PaymentStatus;

@Getter
@Setter
@Data
@Builder
public class PaymentDto {
    private int idPayment;
    private double amount;
    private PaymentStatus paymentStatus;
    // Other fields as needed
    // Getters and setters
}
