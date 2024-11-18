package com.readysetgo.traveltracker.expense.application.port.out;

import com.readysetgo.traveltracker.expense.domain.Expense;

/**
 * 비용 조회 작업을 영속성 계층에 위임하기 위한 포트 인터페이스입니다.
 */
public interface LoadExpensePort {

    /**
     * 비용 데이터를 조회합니다.
     *
     * @param expenseId 조회할 비용 ID
     * @return 비용 도메인 객체
     */
    Expense loadExpense(Long expenseId);
}