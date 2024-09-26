package com.scaler.Splitwise.controllers;

import com.scaler.Splitwise.dto.SettleUpRequest;
import com.scaler.Splitwise.dto.SettleUpResponse;
import com.scaler.Splitwise.models.Expense;
import com.scaler.Splitwise.services.SettleUpService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@AllArgsConstructor
public class SettleUpController  {
    private SettleUpService settleUpService;

    public SettleUpResponse settleUp(SettleUpRequest request){
        List<Expense> expenses=settleUpService.settleUp(request.getUserId(),request.getUserId());

        return new SettleUpResponse(expenses);
    }
}
