package org.example.supermarketwebapp.Services;

import org.example.supermarketwebapp.DTOs.Requests.CustomerRequest;
import org.example.supermarketwebapp.Entities.Customer;
import org.example.supermarketwebapp.Entities.Product;
import org.example.supermarketwebapp.Enums.AccountStatus;

public interface AdminService {
    public void addCustomer(Customer customer);
    public void DeleteCustomer(int idCustomer);
    public void UpdateCustomer(int idCustomer, CustomerRequest customer);
    public void AddProduct(Product product);
    public void DeleteProduct(int IdProduct);
    public void UpdateProduct(int IdProduct,Product product);
    public void ManageAccountStatus(int IdAccount, AccountStatus accountStatus);

}
