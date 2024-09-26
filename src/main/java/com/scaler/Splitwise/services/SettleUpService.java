package com.scaler.Splitwise.services;

import com.scaler.Splitwise.models.Expense;
import com.scaler.Splitwise.models.ExpenseUser;
import com.scaler.Splitwise.models.Group;
import com.scaler.Splitwise.models.User;
import com.scaler.Splitwise.repository.ExpenseRepository;
import com.scaler.Splitwise.repository.GroupRepository;
import com.scaler.Splitwise.repository.UserRepository;
import com.scaler.Splitwise.stratergies.SettleUpStratergy;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class SettleUpService {

    UserRepository userRepository;
    GroupRepository groupRepository;
    ExpenseRepository expenseRepository;
    SettleUpStratergy settleUpStratergy;
    public List<Expense> settleUp(Long userId, Long grpId){
        User user=userRepository.findById(userId).orElseThrow(()->new IllegalArgumentException("No User Found"));
        Group group=groupRepository.findById(grpId).orElseThrow(()->new IllegalArgumentException("No Group Found"));
        List<Expense> expenses=expenseRepository.findAllByGroup(group);
        List<Expense> groupSettleTransactions=settleUpStratergy.settleUp(expenses);
        List<Expense> transactionForUser=new ArrayList<>();
        for (Expense expense:groupSettleTransactions) {
            List<ExpenseUser> expenseUsers = expense.getOwedBy();
            boolean isExpenseForUser = false;
            for (ExpenseUser expenseUser : expense.getOwedBy()) {
                if (expenseUser.getUser().equals(user)) {
                    isExpenseForUser = true;
                    break;
                }
            }
            for (ExpenseUser expenseUser : expense.getPaidBy()) {
                if (expenseUser.getUser().equals(user)) {
                    isExpenseForUser = true;
                    break;
                }
            }
            if (isExpenseForUser) {
                transactionForUser.add(expense);
            }
        }
        return transactionForUser;
    }
}
