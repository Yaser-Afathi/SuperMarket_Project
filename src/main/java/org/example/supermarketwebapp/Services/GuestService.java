package org.example.supermarketwebapp.Services;

import org.example.supermarketwebapp.Entities.Account;
import org.example.supermarketwebapp.Entities.Product;

import java.util.List;

public interface GuestService {
    void RegisterAccount(Account account);
    List<Product> SearchProduct(String product);
    void AddItemToShoppingCart(Product product);
    void updateShoppingCart();
    void FilterProduct();
}