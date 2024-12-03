package org.example.supermarketwebapp.Services.Impl;

import jakarta.transaction.Transactional;
import org.example.supermarketwebapp.Entities.Product;
import org.example.supermarketwebapp.ErrorHandling.ResourceNotFoundException;
import org.example.supermarketwebapp.Repositories.ProductRepository;
import org.example.supermarketwebapp.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional

public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository productRepository;
    @Override
    public void addProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    public void deleteProduct(int idProduct) {
        productRepository.deleteById(idProduct);
    }

    @Override
    public void updateProduct(int idProduct) {

    }

    @Override
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> findProdutById(int idProduct) {
        return productRepository.findById(idProduct);
    }

    @Override
    public void updateProduct(int idProduct, Product product) {
        Product existingProduct = productRepository.findById(idProduct)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with id: " + idProduct));

        // Update the fields of the existing product with the values from the request body
        existingProduct.setAvailableUnits(product.getAvailableUnits());
        existingProduct.setDescription(product.getDescription());
        existingProduct.setPrice(product.getPrice());

        // Save the updated product to the database
        productRepository.save(existingProduct);
    }


}
