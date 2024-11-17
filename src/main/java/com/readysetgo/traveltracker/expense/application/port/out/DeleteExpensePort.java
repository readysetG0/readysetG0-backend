package com.readysetgo.traveltracker.expense.application.port.out;

/**
 * 비용 삭제 작업을 영속성 계층에 위임하기 위한 포트 인터페이스입니다.
 */
public interface DeleteExpensePort {

    /**
     * 비용 데이터를 삭제합니다.
     *
     * @param expenseId 삭제할 비용 ID
     * @return 삭제 성공 여부
     */
    Boolean deleteExpense(Long expenseId);
}