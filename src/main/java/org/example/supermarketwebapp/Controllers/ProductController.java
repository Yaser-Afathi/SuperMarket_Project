package org.example.supermarketwebapp.Controllers;
import org.example.supermarketwebapp.Entities.Product;
import org.example.supermarketwebapp.Repositories.ProductRepository;
import org.example.supermarketwebapp.Services.Impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductServiceImpl productService;
    @Autowired
    ProductRepository productRepository;

    @GetMapping("/productList")
    public List<Product> viewProducts() {
            return productService.getProducts();
    }

    @GetMapping("/{id}")
    public Optional<Optional<Product>> findProductById(@PathVariable int id){
        return Optional.ofNullable(productService.findProdutById(id));
    }
    @PutMapping("/{id}")
    public void updateProduct(@PathVariable int id, @RequestBody Product product) {
        productService.updateProduct(id, product);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable int id){
        productService.deleteProduct(id);
    }

    @PostMapping("/product")
    public void addProduct(@PathVariable Product product){
        productService.addProduct(product);
    }
}
