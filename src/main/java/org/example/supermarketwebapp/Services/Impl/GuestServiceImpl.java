package org.example.supermarketwebapp.Services.Impl;

import jakarta.transaction.Transactional;
import org.example.supermarketwebapp.Entities.Account;
import org.example.supermarketwebapp.Entities.Product;
import org.example.supermarketwebapp.Repositories.GuestRepository;
import org.example.supermarketwebapp.Repositories.ProductRepository;
import org.example.supermarketwebapp.Repositories.ShoppingCartRepository;
import org.example.supermarketwebapp.Services.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class GuestServiceImpl implements GuestService {
    @Autowired
    GuestRepository guestRepository;
    @Autowired
    ShoppingCartRepository shoppingCartRepository;
    @Autowired
    ProductRepository productRepository;

    @Override
    public void RegisterAccount(Account account) {
        guestRepository.save(account);
    }

    @Override
    public List<Product> SearchProduct(String product) {

        return productRepository.findBySearchTerm(product);
    }

    @Override
    public void AddItemToShoppingCart(Product product) {
//    shoppingCartRepository.save(product)
    }

    @Override
    public void updateShoppingCart() {

    }

    @Override
    public void FilterProduct() {

    }
}