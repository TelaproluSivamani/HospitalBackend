package com.HealthCare.Management.Entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import lombok.Data;


@Entity
@Table(name="Hospital")
@Data

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name="User_Id")
    private Long Id;

    @NotBlank(message = "Gmail ID is required")
    @Column(unique = true,nullable = false)
    @Email(message="Please provide a valid email address")
    private String email;

    @NotBlank(message = "UserName is required")
    @Column(unique = true,nullable = false)
    @Size(min = 3,max=50, message = "Username must be between 3 and 8 characters")
    private String userName;

    @NotBlank(message = "Password is required")
    @Size(min = 8,message = "Password must be at least 8 characters long")
    @Column(nullable = false)
    private String password;

    public User(){}
    public User(Long Id,String email,String useName,String password){
        this.Id=Id;
        this.email=email;
        this.userName=useName;
        this.password=password;
    }

    public Long getId(){return Id;}
    public void setId(Long Id){this.Id=Id;}

    public String getEmail(){return email;}
    public void setEmail(String email){this.email=email;}

    public String getPassword(){return password;}
    public void setPassword(String password){this.password=password;}

    public String getUserName(){return userName;}
    public void  setUserName(String userName){this.userName=userName;}

}
