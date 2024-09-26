package com.scaler.Splitwise.models;

import com.scaler.Splitwise.enums.ExpenseType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Expense extends BaseModel{
    private String description;
    private Double amount;
    private ExpenseType expenseType;
    @ManyToOne
    private Group group;
    @OneToMany
    List<ExpenseUser> paidBy;
    @OneToMany
    List<ExpenseUser> owedBy;





}
