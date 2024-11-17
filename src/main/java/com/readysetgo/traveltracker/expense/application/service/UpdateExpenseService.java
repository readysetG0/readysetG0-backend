package com.readysetgo.traveltracker.expense.application.service;

import com.readysetgo.traveltracker.common.annotation.UseCase;
import com.readysetgo.traveltracker.expense.application.port.in.UpdateExpenseCommand;
import com.readysetgo.traveltracker.expense.application.port.in.UpdateExpenseUseCase;
import com.readysetgo.traveltracker.expense.application.port.out.UpdateExpensePort;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

/**
 * 비용 수정 비즈니스 로직을 처리하는 서비스 클래스입니다.
 */
@UseCase
@Transactional
@RequiredArgsConstructor
public class UpdateExpenseService implements UpdateExpenseUseCase {

    private final UpdateExpensePort updateExpensePort;

    @Override
    public boolean updateExpense(UpdateExpenseCommand command) {
        return updateExpensePort.updateExpense(command);
    }
}