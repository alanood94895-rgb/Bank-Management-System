package com.example.BMS.Controllers;

import com.example.BMS.Entity.Customer;
import com.example.BMS.Services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("customer")
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @PostMapping("addCustomer")
    public Customer addCustomer(@RequestBody Customer customer) {
        return customerService.addCustomer(customer);
    }

    @GetMapping("getAll")
    public List<Customer> getAllCustomer() {
        return customerService.getAllCustomer();
    }

    @GetMapping("getById")
    public Customer getCustomerById(@RequestParam Integer id) {
        return customerService.getCustomerById(id);
    }

    @GetMapping("getByName")
    public Customer getCustomerByName(@RequestParam String customerName) {
        return customerService.getCustomerByName(customerName);
    }

    @PutMapping("update/{id}")
    public Customer updateCustomerInfo(@RequestParam Customer customer, @PathVariable Integer id) {
        return customerService.updateCustomerInfo(id, customer);
    }

    @DeleteMapping("delete")
    public Boolean deleteCustomer(Integer id) {
        return customerService.deleteCustomer(id);
    }

}

