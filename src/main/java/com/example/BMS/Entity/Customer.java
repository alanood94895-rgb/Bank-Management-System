package com.example.BMS.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

@Entity
@Data
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;

    @NotBlank(message = "Customer name cannot be empty")
    private String customerName;

    @Column(unique = true)
    @NotBlank(message = "Account number is required")
    private String accountNumber;

    @PositiveOrZero(message = "Balance cannot be negative")
    private double balance;

    @Email(message = "Invalid email format")
    private String email;

    private String phoneNumber;

    public Customer() {
    }

}