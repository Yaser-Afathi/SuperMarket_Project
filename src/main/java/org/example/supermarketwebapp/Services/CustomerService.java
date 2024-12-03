package org.example.supermarketwebapp.Services;

import jakarta.persistence.criteria.Order;
import org.example.supermarketwebapp.DTOs.Requests.CustomerRequest;
import org.example.supermarketwebapp.DTOs.Responses.CustomerResponse;
import org.example.supermarketwebapp.Entities.*;
import org.springframework.http.ResponseEntity;
import java.util.List;


public interface CustomerService {

    //Admin related methods:
    void addCustomer(Customer customer);
    void deleteCustomer(int idCustomer);
    ResponseEntity<List<CustomerResponse>> viewCustomers();
    ResponseEntity<CustomerResponse> viewCustomer(int customerId);
    void updateCustomer(int customerId, CustomerRequest customerRequest);


    //Customer-ShoppingCart related methods:
    void addCartItemToCustomerCart(int idCustomer, CartItem cartItem);
    void deleteCartItemFromCustomerCart(int idCustomer,int idCartItem);
    void updateCartItemFromCustomerCart(int idCustomer,int idCartItem,int itemQuantity);

    //Customer-Reviews related methods:
    void addProductReview(int idCustomer,int idProduct,ProductReview review);
    void deleteProductReview(int idCustomer,int idProduct);
    void updateProductReview(int  idProductReview,ProductReview newReview);

    //Customer-CustomerOrder-Shipment related methods:
    void generateCustomerOrder(int idCustomer);
    void deleteCustomerOrder(int idCustomer,int idOrder);
    void updateCustomerOrder(int idCustomer, int idOrder, CustomerOrder order);

    //Customer-Payment related methods:
    void addCustomerCreditCard(int idCustomer, CreditCard creditCard);
    void updateCustomerCreditCard(int idCustomer,CreditCard creditCard);
    void deleteCustomerCreditCard(int idCustomer);

    //Customer shipment related methods:
    void addShipmentDetailsToCustomer(int idCustomer, Shippment shipment);
    void updateShipmentDetailsToCustomer(int idCustomer,Shippment shippment);
    void deleteShipmentDetailsFromCustomer(int idCustomer);

}
