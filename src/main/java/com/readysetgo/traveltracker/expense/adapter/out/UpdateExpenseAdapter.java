package com.readysetgo.traveltracker.expense.adapter.out;

import com.readysetgo.traveltracker.common.annotation.PersistenceAdapter;
import com.readysetgo.traveltracker.expense.adapter.out.persistence.ExpenseJpaEntity;
import com.readysetgo.traveltracker.expense.adapter.out.persistence.ExpenseRepository;
import com.readysetgo.traveltracker.expense.application.port.in.UpdateExpenseCommand;
import com.readysetgo.traveltracker.expense.application.port.out.UpdateExpensePort;
import lombok.RequiredArgsConstructor;

/**
 * 비용 데이터를 수정하기 위한 어댑터 클래스입니다.
 */
@PersistenceAdapter
@RequiredArgsConstructor
public class UpdateExpenseAdapter implements UpdateExpensePort {

    private final ExpenseRepository expenseRepository;

    @Override
    public boolean updateExpense(UpdateExpenseCommand command) {
        ExpenseJpaEntity expense = expenseRepository.findById(command.expenseId())
            .orElseThrow(RuntimeException::new); // TODO: 적절한 커스텀 예외로 변경 현재 500 반환

        expense.updateInfo(command.billingDetails(), command.price());

        return true; //TODO: 필요시 적절한 내용으로 변경
    }
}