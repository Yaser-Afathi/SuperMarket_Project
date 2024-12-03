package org.example.supermarketwebapp.Controllers;

import org.example.supermarketwebapp.DTOs.Requests.CustomerRequest;
import org.example.supermarketwebapp.Entities.Customer;
import org.example.supermarketwebapp.Entities.Product;
import org.example.supermarketwebapp.Enums.AccountStatus;
import org.example.supermarketwebapp.Services.Impl.AdminServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Admin")
public class AdminController {
    @Autowired
    AdminServiceImpl adminService;
    @PostMapping("Add_Customer")//available
    public void AddCustomer(@RequestBody Customer customer){
        adminService.addCustomer(customer);
    }
    @DeleteMapping("/Customers/{id}")//unavailable
    public void deleteCustomer(@PathVariable int id){
        adminService.DeleteCustomer(id);
    }

    @PutMapping("/Customers/{id}")//available
    public void updateCustomer(@PathVariable int id,@RequestBody CustomerRequest customer){
        adminService.UpdateCustomer(id,customer);
    }
    @PostMapping("Add_Product")//Available
    public void AddProduct(@RequestBody Product product){
        adminService.AddProduct(product);
    }
    @DeleteMapping("/Products/{id}")//unavailable
    public void DeleteProduct(@PathVariable int id){adminService.DeleteProduct(id);}
    @PutMapping("/Products/{id}")
    public void UpdateProduct(@PathVariable int id,@RequestBody Product product){
        adminService.UpdateProduct(id,product);
    }
    @PostMapping("/Account_Status/{id}")
    public void ManageAccountStatus(@PathVariable int id,@RequestBody AccountStatus accountStatus){
        adminService.ManageAccountStatus(id, accountStatus);
    }
}
