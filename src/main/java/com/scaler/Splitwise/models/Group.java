package com.scaler.Splitwise.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

@Entity(name = "User_Groups")
public class Group extends BaseModel{
    private String name;
    @ManyToMany
    private List<User> users;
    @ManyToOne
    private User adminUser;
    @OneToMany
    private List<Expense> expenses;



}
