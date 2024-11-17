package com.readysetgo.traveltracker.expense.adapter.out;

import com.readysetgo.traveltracker.common.annotation.PersistenceAdapter;
import com.readysetgo.traveltracker.expense.adapter.out.persistence.ExpenseJpaEntity;
import com.readysetgo.traveltracker.expense.adapter.out.persistence.ExpenseRepository;
import com.readysetgo.traveltracker.expense.application.port.out.LoadExpensePort;
import com.readysetgo.traveltracker.expense.domain.Expense;
import lombok.RequiredArgsConstructor;

/**
 * 비용 데이터를 조회하기 위한 어댑터 클래스입니다.
 */
@PersistenceAdapter
@RequiredArgsConstructor
public class LoadExpenseAdapter implements LoadExpensePort {

    private final ExpenseRepository expenseRepository;

    @Override
    public Expense loadExpense(Long expenseId) {
        ExpenseJpaEntity expense = expenseRepository.findById(expenseId)
            .orElseThrow(RuntimeException::new); // TODO: 적절한 커스텀 예외로 변경, 현재 500 발생

        return Expense.builder()
            .id(expense.getId())
            .billingDetails(expense.getBillingDetails())
            .price(expense.getPrice())
            .build();
    }
}