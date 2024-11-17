package com.readysetgo.traveltracker.expense.application.service;

import com.readysetgo.traveltracker.common.annotation.UseCase;
import com.readysetgo.traveltracker.expense.adapter.in.web.response.CreateExpenseResponse;
import com.readysetgo.traveltracker.expense.application.port.in.CreateExpenseCommand;
import com.readysetgo.traveltracker.expense.application.port.in.CreateExpenseUseCase;
import com.readysetgo.traveltracker.expense.application.port.out.CreateExpensePort;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

/**
 * 비용 생성 비즈니스 로직을 처리하는 서비스 클래스입니다.
 */
@UseCase
@Transactional
@RequiredArgsConstructor
public class CreateExpenseService implements CreateExpenseUseCase {

    private final CreateExpensePort createExpensePort;

    @Override
    public CreateExpenseResponse createExpense(CreateExpenseCommand command) {
        return CreateExpenseResponse.builder()
            .expenseId(createExpensePort.createExpense(command))
            .billingDetails(command.billingDetails())
            .price(command.price())
            .build();
    }
}