package org.example.supermarketwebapp.Services.Impl;

import jakarta.persistence.Id;
import org.example.supermarketwebapp.DTOs.Requests.CustomerRequest;
import org.example.supermarketwebapp.Entities.Account;
import org.example.supermarketwebapp.Entities.Customer;
import org.example.supermarketwebapp.Entities.Product;
import org.example.supermarketwebapp.Entities.ShoppingCart;
import org.example.supermarketwebapp.Enums.AccountStatus;
import org.example.supermarketwebapp.ErrorHandling.ResourceNotFoundException;
import org.example.supermarketwebapp.Repositories.AccountRepository;
import org.example.supermarketwebapp.Repositories.CustomerRepository;
import org.example.supermarketwebapp.Repositories.ProductRepository;
import org.example.supermarketwebapp.Repositories.ShoppingCartRepository;
import org.example.supermarketwebapp.Services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    ShoppingCartRepository shoppingCartRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    AccountRepository accountRepository;
    @Override
    public void addCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void DeleteCustomer(int idCustomer) {
        Customer customer= customerRepository.findById(idCustomer).orElseThrow(()->new ResourceNotFoundException("Customer wasnt found"));
        ShoppingCart shoppingCart= shoppingCartRepository.findById(customer.getShoppingCart().getIdCart()).orElseThrow(()->new ResourceNotFoundException("Cart wasnt found"));
        shoppingCartRepository.delete(shoppingCart);
        customerRepository.delete(customer);
    }

    @Override
    public void UpdateCustomer(int idCustomer, CustomerRequest customerRequest) {
        Customer existingCustomer = customerRepository.findById(idCustomer)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found with id: " + idCustomer));
        // Update the existing customer's information with the new information from customerRequest
        existingCustomer.getAccount().setEmail(customerRequest.getAccount().getEmail());
        existingCustomer.getAccount().getShippingAddress().setCity(customerRequest.getAccount().getShippingAddress().getCity());
        existingCustomer.getAccount().getShippingAddress().setStreetAddress(customerRequest.getAccount().getShippingAddress().getStreetAddress());
        existingCustomer.getAccount().getShippingAddress().setState(customerRequest.getAccount().getShippingAddress().getState());
        existingCustomer.getAccount().setUsername(customerRequest.getAccount().getUsername());
        existingCustomer.getAccount().setPhone(customerRequest.getAccount().getPhone());
        customerRepository.save(existingCustomer);
    }

    @Override
    public void AddProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    public void DeleteProduct(int IdProduct) {
        Product product=productRepository.findById(IdProduct).orElseThrow(()
                -> new ResourceNotFoundException("Product not found with id :"+IdProduct));
        productRepository.delete(product);
    }

    @Override
    public void UpdateProduct(int IdProduct, Product product) {
        Product existingproduct=productRepository.findById(IdProduct).orElseThrow(()
                -> new ResourceNotFoundException("Product not found with id :"+IdProduct));
        existingproduct.setAvailableUnits(product.getAvailableUnits());
        existingproduct.setName(product.getName());
        existingproduct.setCategory(product.getCategory());
        existingproduct.setPrice(product.getPrice());
        existingproduct.setDescription(product.getDescription());
        existingproduct.setImageUrl(product.getImageUrl());
        productRepository.save(existingproduct);
    }

    @Override
    public void ManageAccountStatus(int IdAccount, AccountStatus accountStatus) {
        Account account=accountRepository.findById(IdAccount).orElseThrow(()
        -> new ResourceNotFoundException("Account not found with id :"+ IdAccount));
        account.setAccountStatus(accountStatus);
        accountRepository.save(account);
    }
}
