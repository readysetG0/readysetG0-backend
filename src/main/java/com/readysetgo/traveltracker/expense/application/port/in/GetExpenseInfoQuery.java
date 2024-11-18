package com.readysetgo.traveltracker.expense.application.port.in;

import com.readysetgo.traveltracker.expense.adapter.in.web.response.GetExpenseInfoResponse;

/**
 * 비용 조회 유스케이스 인터페이스입니다.
 */
public interface GetExpenseInfoQuery {

    /**
     * 비용 정보를 조회합니다.
     *
     * @param expenseId 조회할 비용 ID
     * @return 비용 정보 응답 객체
     */
    GetExpenseInfoResponse getExpenseInfo(Long expenseId);
}