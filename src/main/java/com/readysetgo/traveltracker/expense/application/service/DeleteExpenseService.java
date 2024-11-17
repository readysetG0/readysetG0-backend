package com.readysetgo.traveltracker.expense.application.service;

import com.readysetgo.traveltracker.common.annotation.UseCase;
import com.readysetgo.traveltracker.expense.application.port.in.DeleteExpenseUseCase;
import com.readysetgo.traveltracker.expense.application.port.out.DeleteExpensePort;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

/**
 * 비용 삭제 비즈니스 로직을 처리하는 서비스 클래스입니다.
 */
@UseCase
@Transactional
@RequiredArgsConstructor
public class DeleteExpenseService implements DeleteExpenseUseCase {

    private final DeleteExpensePort deleteExpensePort;

    @Override
    public boolean deleteExpense(Long expenseId) {
        return deleteExpensePort.deleteExpense(expenseId);
    }
}