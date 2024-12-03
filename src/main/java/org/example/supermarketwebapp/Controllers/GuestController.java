package org.example.supermarketwebapp.Controllers;


import org.example.supermarketwebapp.Entities.Account;
import org.example.supermarketwebapp.Entities.Product;
import org.example.supermarketwebapp.Repositories.GuestRepository;
import org.example.supermarketwebapp.Repositories.ProductRepository;

import org.example.supermarketwebapp.Services.Impl.GuestServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Guest")
public class GuestController {
    @Autowired
    GuestServiceImpl guestService;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    GuestRepository guestRepository;
    @PostMapping("/guest")
    public void addGuest(@RequestBody Account account){
        guestService.RegisterAccount(account);
    }

    @GetMapping("/search")

    public List<Product> searchProducts(@RequestParam String searchTerm) {

        return guestService.SearchProduct(searchTerm);}
}