package org.example.supermarketwebapp.DTOs;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Builder
@Getter
@Setter
public class CreditCardDto {
    private int idCreditCard;
    private AddressDto billingAddress;
    private String cardNumber;
    private String nameOnCard;
}
