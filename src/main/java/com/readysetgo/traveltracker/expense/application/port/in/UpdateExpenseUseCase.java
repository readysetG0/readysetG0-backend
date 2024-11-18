package com.readysetgo.traveltracker.expense.application.port.in;

/**
 * 비용 수정 유스케이스 인터페이스입니다.
 */
public interface UpdateExpenseUseCase {

    /**
     * 비용 정보를 수정합니다.
     *
     * @param command 비용 수정 명령 객체
     * @return 수정 성공 여부
     */
    boolean updateExpense(UpdateExpenseCommand command);
}