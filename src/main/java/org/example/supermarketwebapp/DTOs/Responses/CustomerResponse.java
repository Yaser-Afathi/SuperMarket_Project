package org.example.supermarketwebapp.DTOs.Responses;


import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.example.supermarketwebapp.DTOs.AccountDto;
import org.example.supermarketwebapp.DTOs.CreditCardDto;
import org.example.supermarketwebapp.DTOs.CustomerOrderDto;
import org.example.supermarketwebapp.DTOs.ShoppingCartDto;
import org.example.supermarketwebapp.Entities.Account;
import org.example.supermarketwebapp.Entities.CustomerOrder;
import org.example.supermarketwebapp.Entities.ShoppingCart;

import java.util.List;

@Data
@Builder
@Getter
@Setter
public class CustomerResponse {
    private int idCustomer;
    private AccountDto account;
    private List<CustomerOrderDto> customerOrderList;
    private ShoppingCartDto shoppingCart;
    // Other fields as needed for response
    // Getters and setters
}
