package com.scaler.Splitwise.models;

import com.scaler.Splitwise.enums.ExpenseUserType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class ExpenseUser extends  BaseModel{
    @ManyToOne
    private Expense expense;
    @ManyToOne
    private User user;
    private ExpenseUserType expenseUserType;
    private Double amount;


}
