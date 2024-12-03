package org.example.supermarketwebapp.Services;

import org.example.supermarketwebapp.Entities.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
     void addProduct(Product product);
     void deleteProduct(int idProduct);
     void updateProduct(int idProduct);
     List<Product> getProducts();
     Optional<Product> findProdutById(int idProduct);
     void updateProduct(int idProduct,Product product);
}
