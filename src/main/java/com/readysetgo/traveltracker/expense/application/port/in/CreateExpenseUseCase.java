package com.readysetgo.traveltracker.expense.application.port.in;

import com.readysetgo.traveltracker.expense.adapter.in.web.response.CreateExpenseResponse;

/**
 * 비용 생성 유스케이스 인터페이스입니다.
 */
public interface CreateExpenseUseCase {

    /**
     * 비용을 생성합니다.
     *
     * @param command 비용 생성 명령 객체
     * @return 생성된 비용 정보
     */
    CreateExpenseResponse createExpense(CreateExpenseCommand command);
}