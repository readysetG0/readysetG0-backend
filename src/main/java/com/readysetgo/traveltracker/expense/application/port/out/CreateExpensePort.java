package com.readysetgo.traveltracker.expense.application.port.out;

import com.readysetgo.traveltracker.expense.application.port.in.CreateExpenseCommand;

/**
 * 비용 생성 작업을 영속성 계층에 위임하기 위한 포트 인터페이스입니다.
 */
public interface CreateExpensePort {

    /**
     * 비용을 생성합니다.
     *
     * @param command 비용 생성 명령 객체
     * @return 생성된 비용 ID
     */
    Long createExpense(CreateExpenseCommand command);
}