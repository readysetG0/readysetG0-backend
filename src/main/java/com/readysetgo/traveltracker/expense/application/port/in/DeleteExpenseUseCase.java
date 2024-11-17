package com.readysetgo.traveltracker.expense.application.port.in;

/**
 * 비용 삭제 유스케이스 인터페이스입니다.
 */
public interface DeleteExpenseUseCase {

    /**
     * 비용을 삭제합니다.
     *
     * @param expenseId 삭제할 비용 ID
     * @return 삭제 성공 여부
     */
    boolean deleteExpense(Long expenseId);
}