package com.readysetgo.traveltracker.expense.adapter.out;

import com.readysetgo.traveltracker.common.annotation.PersistenceAdapter;
import com.readysetgo.traveltracker.expense.adapter.out.persistence.ExpenseJpaEntity;
import com.readysetgo.traveltracker.expense.adapter.out.persistence.ExpenseRepository;
import com.readysetgo.traveltracker.expense.application.port.in.CreateExpenseCommand;
import com.readysetgo.traveltracker.expense.application.port.out.CreateExpensePort;
import lombok.RequiredArgsConstructor;

/**
 * 비용 데이터를 영속성 계층에 저장하는 어댑터 클래스입니다.
 */
@PersistenceAdapter
@RequiredArgsConstructor
public class CreateExpenseAdapter implements CreateExpensePort {

    private final ExpenseRepository expenseRepository;

    @Override
    public Long createExpense(CreateExpenseCommand command) {
        ExpenseJpaEntity expense = createExpenseEntity(command);
        expenseRepository.save(expense);

        return expense.getId();
    }

    private ExpenseJpaEntity createExpenseEntity(CreateExpenseCommand command) {
        return ExpenseJpaEntity.builder()
            .billingDetails(command.billingDetails())
            .price(command.price())
            .build();
    }
}