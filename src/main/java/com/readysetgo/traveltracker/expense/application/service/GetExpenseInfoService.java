package com.readysetgo.traveltracker.expense.application.service;

import com.readysetgo.traveltracker.common.annotation.UseCase;
import com.readysetgo.traveltracker.expense.adapter.in.web.response.GetExpenseInfoResponse;
import com.readysetgo.traveltracker.expense.application.port.in.GetExpenseInfoQuery;
import com.readysetgo.traveltracker.expense.application.port.out.LoadExpensePort;
import com.readysetgo.traveltracker.expense.domain.Expense;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

/**
 * 비용 조회 비즈니스 로직을 처리하는 서비스 클래스입니다.
 */
@UseCase
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class GetExpenseInfoService implements GetExpenseInfoQuery {

    private final LoadExpensePort loadExpensePort;

    @Override
    public GetExpenseInfoResponse getExpenseInfo(Long expenseId) {
        Expense expense = loadExpensePort.loadExpense(expenseId);
        return GetExpenseInfoResponse.builder()
            .expenseId(expense.getId())
            .billingDetails(expense.getBillingDetails())
            .price(expense.getPrice())
            .build();
    }
}