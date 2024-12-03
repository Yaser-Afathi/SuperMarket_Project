package org.example.supermarketwebapp.DTOs;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.example.supermarketwebapp.Enums.AccountStatus;


@Data
@Builder
@Getter
@Setter
public class AccountDto {
    private int idAccount;
    private String name;
    private String username;
    private String phone;
    private AddressDto shippingAddress;
    private AccountStatus accountStatus;
    private String email;
//    private CustomerOrderDto customerOrderDto;
//    private ShoppingCartDto shoppingCartDto;
    //need to add the other suitable dto s in order to get a proper customer response
}
