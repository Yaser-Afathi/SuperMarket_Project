package org.example.supermarketwebapp.Services.Impl;

import jakarta.persistence.criteria.Order;
import jakarta.transaction.Transactional;
import org.example.supermarketwebapp.DTOs.AccountDto;
import org.example.supermarketwebapp.DTOs.CustomerOrderDto;
import org.example.supermarketwebapp.DTOs.Requests.CustomerRequest;
import org.example.supermarketwebapp.DTOs.Responses.CustomerResponse;
import org.example.supermarketwebapp.DTOs.ShoppingCartDto;
import org.example.supermarketwebapp.Entities.*;
import org.example.supermarketwebapp.Enums.OrderStatus;
import org.example.supermarketwebapp.ErrorHandling.ResourceNotFoundException;
import org.example.supermarketwebapp.Mappers.CustomerMapper;
import org.example.supermarketwebapp.Repositories.*;
import org.example.supermarketwebapp.Services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService{
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    CustomerOrderRepository customerOrderRepository;
    @Autowired
    CustomerMapper customerMapper;
    @Autowired
    CreditCardRepository creditCardRepository;
    @Autowired
    ProductReviewRepository productReviewRepository;

    //Admin related methods:
    @Override
    public void addCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void deleteCustomer(int idCustomer) {
        Customer customer= customerRepository.findById(idCustomer).orElseThrow(()->new ResourceNotFoundException("Customer wasnt found"));
        customerRepository.delete(customer);
    }

    @Override
    public ResponseEntity<List<CustomerResponse>> viewCustomers() {
        List<Customer> customers = customerRepository.findAll();

        if (!customers.isEmpty()) {
            List<CustomerResponse> customerResponses = new ArrayList<>();

            for (Customer customer : customers) {
                // Map the Account entity to AccountDto
                AccountDto accountDto = customerMapper.accountToAccountDto(customer.getAccount());
                // Map the Customer entity to CustomerDto
                CustomerResponse customerDto = customerMapper.CustomerToCustomerResponse(customer);
                // Map the list of CustomerOrder entities to a list of CustomerOrderDto
                List<CustomerOrderDto> customerOrderDtoList = customerMapper.customerOrdersToCustomerOrderDtos(customer.getCustomerOrderList());
                // Map the ShoppingCart entity to a ShoppingCartDto
                ShoppingCartDto shoppingCartDto = customerMapper.shoppingCartToShoppingCartDto(customer.getShoppingCart());

                // Create the CustomerResponse using the mapped DTOs
                CustomerResponse customerResponse = CustomerResponse.builder()
                        .idCustomer(customer.getIdCustomer())
                        .account(accountDto)
                        .shoppingCart(shoppingCartDto)
                        .customerOrderList(customerOrderDtoList)
                        .build();

                customerResponses.add(customerResponse);
            }

            return ResponseEntity.ok(customerResponses);
        } else {
            // Handle case when no customers are found
            return ResponseEntity.notFound().build();
        }
    }


    @Override
    public ResponseEntity<CustomerResponse> viewCustomer(int customerId) {
        Optional<Customer> customerOptional = customerRepository.findById(customerId);

        if (customerOptional.isPresent()) {
            Customer customer = customerOptional.get();

            // Map the Account entity to AccountDto
            AccountDto accountDto = customerMapper.accountToAccountDto(customer.getAccount());
            // Map the Customer entity to CustomerDto
            CustomerResponse customerDto = customerMapper.CustomerToCustomerResponse(customer);
            // Map the list of CustomerOrder entities to a list of CustomerOrderDto
            List<CustomerOrderDto> customerOrderDtoList = customerMapper.customerOrdersToCustomerOrderDtos(customer.getCustomerOrderList());
            // Map the ShoppingCart entity to a ShoppingCartDto
            ShoppingCartDto shoppingCartDto = customerMapper.shoppingCartToShoppingCartDto(customer.getShoppingCart());

            // Create the CustomerResponse using the mapped DTOs
            CustomerResponse customerResponse=CustomerResponse.builder()
                    .idCustomer(customerId)
                    .account(accountDto)
                    .shoppingCart(shoppingCartDto)
                    .customerOrderList(customerOrderDtoList)
                    .build();


            return ResponseEntity.ok(customerResponse);
        } else {
            // Handle case when customer is not found
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public void updateCustomer(int customerId, CustomerRequest customerRequest) {
        Customer existingCustomer = customerRepository.findById(customerId)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found with id: " + customerId));

        // Update the existing customer's information with the new information from customerRequest
        existingCustomer.getAccount().setEmail(customerRequest.getAccount().getEmail());
        existingCustomer.getAccount().getShippingAddress().setCity(customerRequest.getAccount().getShippingAddress().getCity());
        existingCustomer.getAccount().getShippingAddress().setStreetAddress(customerRequest.getAccount().getShippingAddress().getStreetAddress());
        existingCustomer.getAccount().getShippingAddress().setState(customerRequest.getAccount().getShippingAddress().getState());
        existingCustomer.getAccount().setUsername(customerRequest.getAccount().getUsername());
        existingCustomer.getAccount().setPhone(customerRequest.getAccount().getPhone());
        customerRepository.save(existingCustomer);
    }


    //Customer-ShoppingCart related methods:

    @Override
    public void addCartItemToCustomerCart(int idCustomer, CartItem cartItem) {
        Customer existingCustomer=customerRepository.findById(idCustomer).orElseThrow(()->new ResourceNotFoundException("Customer wasn't found"));
        existingCustomer.getShoppingCart().getCartItems().add(cartItem);
    }

    @Override
    public void deleteCartItemFromCustomerCart(int idCustomer, int idCartItem) {
        Customer existingCustomer=customerRepository.findById(idCustomer).orElseThrow(()->new ResourceNotFoundException("Customer wasn't found"));
        for(CartItem cartItem :existingCustomer.getShoppingCart().getCartItems()){
            if (cartItem.getId()==idCartItem) existingCustomer.getShoppingCart().getCartItems().remove(cartItem);
        }
        customerRepository.save(existingCustomer);
    }

    @Override
    public void updateCartItemFromCustomerCart(int idCustomer, int idCartItem,int itemQuantity) {
        Customer existingCustomer=customerRepository.findById(idCustomer).orElseThrow(()->new ResourceNotFoundException("Customer wasn't found"));
        for(CartItem cartItem :existingCustomer.getShoppingCart().getCartItems()){
            if (cartItem.getId()==idCartItem) cartItem.setQuantity(itemQuantity);
        }
        customerRepository.save(existingCustomer);
    }

    //Customer-Reviews related methods:

    @Override
    public void addProductReview(int idCustomer, int idProduct, ProductReview review) {
        Product reviewedProduct = productRepository.findById(idProduct).orElseThrow(() -> new ResourceNotFoundException("Product not found"));
        Customer reviewingCustomer=customerRepository.findById(idCustomer).orElseThrow(()->new ResourceNotFoundException("Customer id non existing"));
        review.setCustomer(reviewingCustomer);
        review.setProduct(reviewedProduct);
        productReviewRepository.save(review);
    }

    @Override
    public void deleteProductReview(int idCustomer, int idProduct) {
        Product reviewedProduct=productRepository.findById(idProduct).orElseThrow(()->new ResourceNotFoundException("Product wasnt found"));
        Customer reviewingCustomer=customerRepository.findById(idCustomer).orElseThrow(()->new ResourceNotFoundException("Customer id non existing"));
        for (ProductReview review:reviewedProduct.getProductReviewList()){
            if (review.getCustomer().equals(reviewingCustomer)){
                reviewedProduct.getProductReviewList().remove(review);
                productReviewRepository.save(review);
            }

        }

    }

    @Override
    public void updateProductReview(int idProductReview,ProductReview newReview) {
       ProductReview existingReview=productReviewRepository.findById(idProductReview).get();
       existingReview.setReview(newReview.getReview()!=null ? newReview.getReview() : existingReview.getReview());
       existingReview.setRating(newReview.getRating());
       productReviewRepository.save(existingReview);
    }

    //Customer-CustomerOrder-Shipment related methods:

    @Override
    public void generateCustomerOrder(int idCustomer) {
        Customer existingCustomer = customerRepository.findById(idCustomer)
                .orElseThrow(() -> new ResourceNotFoundException("Customer was not found with the id: " + idCustomer));

        ShoppingCart shoppingCart = existingCustomer.getShoppingCart();

        List<CartItem> cartItems = shoppingCart.getCartItems();

        List<OrderItem> orderItems = new ArrayList<>();

        for (CartItem cartItem : cartItems) {
            OrderItem orderItem = OrderItem.builder()
                    .product(cartItem.getProduct())
                    .quantity(cartItem.getQuantity())
                    .build();
            orderItems.add(orderItem);
        }

        CustomerOrder customerOrder = CustomerOrder.builder()
                .orderDate(LocalDateTime.now())
                .orderNumber(UUID.randomUUID().toString())
                .orderStatus(OrderStatus.PENDING)
                .payment(null)
                .shippment(null)
                .orderItems(orderItems)
                .build();

        existingCustomer.getCustomerOrderList().add(customerOrder);

        customerRepository.save(existingCustomer);
    }


    @Override
    public void deleteCustomerOrder(int idCustomer, int idOrder) {
        Customer existingCustomer=customerRepository.findById(idCustomer).orElseThrow(()->new ResourceNotFoundException("Customer wasnt found "));
        for (CustomerOrder customerOrder:existingCustomer.getCustomerOrderList()){
            if (customerOrder.equals(customerOrderRepository.findById(idOrder))) existingCustomer.getCustomerOrderList().remove(customerOrder);
        }
        customerRepository.save(existingCustomer);
    }

    @Override
    public void updateCustomerOrder(int idCustomer, int idOrder, CustomerOrder updatedOrder) {
        // Find the customer
        Customer existingCustomer = customerRepository.findById(idCustomer)
                .orElseThrow(() -> new ResourceNotFoundException("Customer was not found with the id: " + idCustomer));

        // Find the order
        CustomerOrder existingOrder = existingCustomer.getCustomerOrderList().stream()
                .filter(order -> order.getIdOrder() == idOrder)
                .findFirst()
                .orElseThrow(() -> new ResourceNotFoundException("Order was not found with the id: " + idOrder));

        // Update the order details
        existingOrder.setOrderDate(updatedOrder.getOrderDate() != null ? updatedOrder.getOrderDate() : existingOrder.getOrderDate());
        existingOrder.setOrderNumber(updatedOrder.getOrderNumber() != null ? updatedOrder.getOrderNumber() : existingOrder.getOrderNumber());
        existingOrder.setOrderStatus(updatedOrder.getOrderStatus() != null ? updatedOrder.getOrderStatus() : existingOrder.getOrderStatus());
        existingOrder.setPayment(updatedOrder.getPayment() != null ? updatedOrder.getPayment() : existingOrder.getPayment());
        existingOrder.setShippment(updatedOrder.getShippment() != null ? updatedOrder.getShippment() : existingOrder.getShippment());

        // If there are new order items, update them
        if (updatedOrder.getOrderItems() != null && !updatedOrder.getOrderItems().isEmpty()) {
            existingOrder.setOrderItems(updatedOrder.getOrderItems());
        }

        // Save the updated order
        customerRepository.save(existingCustomer);
    }


    //Customer-Payment related methods:

    @Override
    public void addCustomerCreditCard(int idCustomer, CreditCard creditCard) {
        Customer existingCustomer=customerRepository.findById(idCustomer).orElseThrow(()->new ResourceNotFoundException("Customer was not found"));
        existingCustomer.setCreditCard(creditCard);
        customerRepository.save(existingCustomer);
    }
    @Override
    public void updateCustomerCreditCard(int idCustomer,CreditCard creditCard) {
        Customer existingCustomer=customerRepository.findById(idCustomer)
                .orElseThrow(()->new ResourceNotFoundException("Customer was not found with id: "+idCustomer));
        existingCustomer.setCreditCard(creditCard);
        customerRepository.save(existingCustomer);

    }
    @Override
    public void deleteCustomerCreditCard(int idCustomer) {
        Customer existingCustomer=customerRepository.findById(idCustomer)
                .orElseThrow(()->new ResourceNotFoundException("Customer was not found with id: "+idCustomer));
        existingCustomer.setCreditCard(null);
        customerRepository.save(existingCustomer);
    }

    //Customer shipment related methods:
    @Override
    public void addShipmentDetailsToCustomer(int idCustomer, Shippment shipment) {
        Customer existingCustomer=customerRepository.findById(idCustomer).orElseThrow(()->new ResourceNotFoundException("Customer was not found"));
        for (CustomerOrder order:existingCustomer.getCustomerOrderList()){
            order.setShippment(shipment);
        }
        customerRepository.save(existingCustomer);

    }
    @Override
    public void updateShipmentDetailsToCustomer(int idCustomer, Shippment shippment) {
        Customer existingCustomer=customerRepository.findById(idCustomer)
                .orElseThrow(()->new ResourceNotFoundException("Customer was not found with the id :"+idCustomer));
        for (CustomerOrder order:existingCustomer.getCustomerOrderList()){
            order.setShippment(shippment);
        }
        customerRepository.save(existingCustomer);
    }
    @Override
    public void deleteShipmentDetailsFromCustomer(int idCustomer) {
        Customer existingCustomer=customerRepository.findById(idCustomer)
                .orElseThrow(()->new ResourceNotFoundException("Customer was not found with the id :"+idCustomer));
        for (CustomerOrder order:existingCustomer.getCustomerOrderList()){
            order.setShippment(null);
        }
        customerRepository.save(existingCustomer);
    }
}
