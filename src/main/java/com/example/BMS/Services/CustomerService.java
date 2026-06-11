package com.example.BMS.Services;


import com.example.BMS.Entity.Customer;
import com.example.BMS.Repositories.CustomerRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    CustomerRepositories customerRepositories;


    public Customer addCustomer(Customer newCustomer) {
        return customerRepositories.save(newCustomer);
    }

    public List<Customer> getAllCustomer() {
        return customerRepositories.findAll();
    }


    public Customer getCustomerById(Integer id) {
        if (id == null) {
            throw new RuntimeException("ID Cannot Be Null..");
        }
        return customerRepositories.getCustomerByID(id);
    }

    public Customer getCustomerByName(String name) {
        if (name == null) {
            throw new RuntimeException("Name Cannot Be Null..");
        }
        return customerRepositories.getCustomerByName(name);
    }

    public Customer updateCustomerInfo(Integer id,Customer customer) {
        Customer customerToUpdate = customerRepositories.getCustomerByID(id);
        if (customerToUpdate == null) {
            throw new RuntimeException("Customer does not exist");
        }
        customerToUpdate.setCustomerName(customer.getCustomerName());
        customerToUpdate.setAccountNumber(customer.getAccountNumber());
        customerToUpdate.setEmail(customer.getEmail());
        customerToUpdate.setPhoneNumber(customer.getPhoneNumber());
        customerToUpdate.setBalance(customer.getBalance());
        return customerRepositories.save(customerToUpdate);

    }

    public Boolean deleteCustomer(Integer id) {
        Customer customer = customerRepositories.getCustomerByID(id);
        if (customer != null) {
            customerRepositories.deleteById(id);
            return true;
        }
        return false;
    }

}

