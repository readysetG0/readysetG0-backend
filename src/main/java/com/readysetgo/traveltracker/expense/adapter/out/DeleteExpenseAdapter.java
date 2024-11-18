package com.readysetgo.traveltracker.expense.adapter.out;

import com.readysetgo.traveltracker.common.annotation.PersistenceAdapter;
import com.readysetgo.traveltracker.expense.adapter.out.persistence.ExpenseRepository;
import com.readysetgo.traveltracker.expense.application.port.out.DeleteExpensePort;
import lombok.RequiredArgsConstructor;

/**
 * 비용 데이터를 삭제하기 위한 어댑터 클래스입니다.
 */
@PersistenceAdapter
@RequiredArgsConstructor
public class DeleteExpenseAdapter implements DeleteExpensePort {

    private final ExpenseRepository expenseRepository;

    @Override
    public Boolean deleteExpense(Long expenseId) {
        expenseRepository.deleteById(expenseId);
        return true; //TODO: 필요시 요청에 따른 응답으로 변경
    }
}