package org.example.supermarketwebapp.Controllers;

import org.example.supermarketwebapp.DTOs.Requests.CustomerRequest;
import org.example.supermarketwebapp.DTOs.Responses.CustomerResponse;

import org.example.supermarketwebapp.Entities.*;
import org.example.supermarketwebapp.Repositories.CustomerRepository;
import org.example.supermarketwebapp.Repositories.ProductRepository;
import org.example.supermarketwebapp.Services.Impl.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/Customer")
public class CustomerController {
    @Autowired
    CustomerServiceImpl customerService;
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    ProductRepository productRepository;

    @GetMapping("/customers")
    public ResponseEntity<List<CustomerResponse>> viewCustomers(){
       return customerService.viewCustomers();
 }

    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable int id){
        customerService.deleteCustomer(id);
    }

    @PutMapping("/{id}")
    public void updateCustomer(@PathVariable int id,@RequestBody CustomerRequest customerRequest){
        customerService.updateCustomer(id,customerRequest);
    }

    @PostMapping("/customer")
    public void addCustomer(@RequestBody Customer customer) {
        customerService.addCustomer(customer);
    }


    @PostMapping("/product/{idCustomer}/{idProduct}/{quantity}")
    public void addProductToCustomerCart(@PathVariable int idCustomer, @RequestBody CartItem cartItem){
        customerService.addCartItemToCustomerCart(idCustomer,cartItem);
}

    @DeleteMapping("/product/{idCustomer}/{idProduct}")
    public void deleteProductFromCustomerCart(@PathVariable int idCustomer,@PathVariable int idCartItem){
        customerService.deleteCartItemFromCustomerCart(idCustomer,idCartItem);
    }
    @PutMapping("/cartUpdate/{idCustomer}/{idCartItem}/{itemQuantity}")
    public void updateCartItemFromCustomerCart(@PathVariable int idCustomer,@PathVariable int idCartItem,@PathVariable int itemQuantity){
        customerService.updateCartItemFromCustomerCart(idCustomer, idCartItem, itemQuantity);
    }

    @GetMapping("/customer/{id}")
    public ResponseEntity<CustomerResponse> getCustomer(@PathVariable int id){
        ResponseEntity<CustomerResponse> response=customerService.viewCustomer(id);
        return response;
    }

    @PostMapping("/creditCard/{id}")
    public void addCreditCardToCustomer(@PathVariable int idCustomer, @RequestBody CreditCard creditCard){
        customerService.addCustomerCreditCard(idCustomer,creditCard);
    }
    @PutMapping("/creditCard/{id}")
    public void UpdateCustomerCardInfos(@PathVariable int idCustomer, @RequestBody CreditCard creditCard){
        customerService.updateCustomerCreditCard(idCustomer,creditCard);
    }
    @DeleteMapping("/creditCard/{id}")
    public void DeleteCreditCardFromCustomer(@PathVariable int idCustomer){
        customerService.deleteCustomerCreditCard(idCustomer);
    }

    @PostMapping("/shipment/{id}")
    public void addShipementDetailsToCustomerOrder(@PathVariable int idCustomer, @RequestBody Shippment shippment){
        customerService.addShipmentDetailsToCustomer(idCustomer,shippment);
    }
    @DeleteMapping("/shipment/{id}")
    public void DeleteShipementDetailsFromCustomerOrder(@PathVariable int idCustomer){
        customerService.deleteShipmentDetailsFromCustomer(idCustomer);
    }
    @PutMapping("/shipment/{id}")
    public void UpdateShipementDetailsToCustomerOrder(@PathVariable int idCustomer, @RequestBody Shippment shippment){
        customerService.updateShipmentDetailsToCustomer(idCustomer,shippment);
    }

    @PostMapping("/order/{id}")
    void initializeCustomerOrder(@PathVariable int idCustomer){
        customerService.generateCustomerOrder(idCustomer);
    }

    @DeleteMapping("/order/{idCustomer}/{idOrder}")
    public void  deleteCustomerOrder(@PathVariable int idCustomer ,@PathVariable int idOrder){
        customerService.deleteCustomerOrder(idCustomer,idOrder);
    }

    @PostMapping("/review/{idCustomer}/{idProduct}")
    public void addProductReview(@PathVariable int idCustomer,@PathVariable int idProduct,@RequestBody ProductReview productReview){
        customerService.addProductReview(idCustomer, idProduct, productReview);
    }

    @DeleteMapping("/review/{idCustomer}/{idProduct}")
    public void deleteProductReview(@PathVariable int idCustomer,@PathVariable int idProduct){
        customerService.deleteProductReview(idCustomer, idProduct);
    }

    @PutMapping("/review/{idProductReview}")
    public void updateProductReview(@PathVariable int idProductReview,@RequestBody ProductReview newReview){
        customerService.updateProductReview(idProductReview, newReview);
    }

    @PutMapping("/order/{idCustomer}/{idOder}")
    public void updateCustomerOrder(@PathVariable int idCustomer,@PathVariable int idOder,@RequestBody CustomerOrder customerOrder){
        customerService.updateCustomerOrder(idCustomer, idOder, customerOrder);
    }

}
