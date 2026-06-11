package com.example.BMS.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;

@Data
@Entity
@Table
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer customerId;

    @NotBlank(message = "Customer name cannot be empty")
    private String customerName;
    @Column(unique = true)
    @NotBlank(message = "Account number cannot be empty")
    private String accountNumber;
    @PositiveOrZero(message = "Balance cannot be negative")
    private Double balance;
    @Email(message = "Invalid email format")
    @NotBlank(message = "Email cannot be empty")
    private String email;
    private String phoneNumber;

}
