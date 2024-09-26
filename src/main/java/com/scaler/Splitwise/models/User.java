package com.scaler.Splitwise.models;

import jakarta.persistence.Entity;
import lombok.Data;

@Entity(name = "users")
@Data
public class User extends BaseModel{
    private String name;
    private String phoneNum;
    private String password;



}
