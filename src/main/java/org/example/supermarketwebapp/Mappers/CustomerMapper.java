package org.example.supermarketwebapp.Mappers;

import org.example.supermarketwebapp.DTOs.*;
import org.example.supermarketwebapp.Entities.*;
import org.example.supermarketwebapp.DTOs.Responses.CustomerResponse;
import org.mapstruct.Mapper;

import java.util.List;


@Mapper(componentModel = "spring")
    public interface CustomerMapper {
    CustomerResponse CustomerToCustomerResponse(Customer customer);
    Customer CustomerResponseToCustomer(CustomerResponse dto);
    AccountDto accountToAccountDto(Account account);
    ShoppingCartDto shoppingCartToShoppingCartDto(ShoppingCart shoppingCart);
    CustomerOrderDto customerOrderToCustomerOrderDto(CustomerOrder customerOrder);
    List<CustomerOrderDto> customerOrdersToCustomerOrderDtos(List<CustomerOrder> customerOrderList);
    AddressDto AddressToAddressDto(Address address);
    CategoryDto CategoryToCategoryDto(Category category);
    PaymentDto PaymentToPaymentDto(Payment payment);
    ProductReviewDto ProductReviewToProductReviewDto(ProductReview productReview);
    ShippmentDto ShippmentDtoToShippment(Shippment shippment);



    ///add the rest of the mapping for the essantial dto s r
}
