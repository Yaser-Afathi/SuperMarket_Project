package org.example.supermarketwebapp.DTOs.Requests;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.example.supermarketwebapp.DTOs.AccountDto;
import org.example.supermarketwebapp.DTOs.CreditCardDto;
import org.example.supermarketwebapp.DTOs.CustomerOrderDto;
import org.example.supermarketwebapp.DTOs.ShoppingCartDto;
import org.example.supermarketwebapp.Entities.Account;
import org.example.supermarketwebapp.Entities.CreditCard;
import org.example.supermarketwebapp.Entities.CustomerOrder;
import org.example.supermarketwebapp.Entities.ShoppingCart;

import java.util.List;

@Getter
@Setter
@Data
@Builder
public class CustomerRequest {
    int idCustomer;
    AccountDto account;
    List<CustomerOrderDto> customerOrderList;
    ShoppingCartDto shoppingCart;
    CreditCardDto creditCard;
}

