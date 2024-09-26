package com.scaler.Splitwise.dto;

import com.scaler.Splitwise.models.Expense;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class SettleUpResponse {
    private List<Expense> expenses;
}
