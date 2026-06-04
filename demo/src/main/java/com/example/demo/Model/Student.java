package com.example.demo.Model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Student {


    @Id
    private String rollNumber;

    @NotBlank(message = "name cannot be null")
    private String name;
    @NotBlank(message = " gender cannot be nnull")
    private String gender;
    @NotBlank(message =  "dept cannot be nulll")
    private String dept;
    @Email(message =" email cannot be null" )
    private  String email;

    private String password;
}
