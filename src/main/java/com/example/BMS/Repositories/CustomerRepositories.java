package com.example.BMS.Repositories;

import com.example.BMS.Entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepositories extends JpaRepository<Customer,Integer> {

        @Query("select c from Customer c where c.id=:id ")
        Customer getCustomerByID(@Param("id")Integer id);
        @Query("select c from Customer c where c.customerName=:name")
        Customer getCustomerByName(@Param("customerName") String customerName);

}
