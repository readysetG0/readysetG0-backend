package com.readysetgo.traveltracker.expense.adapter.in.web.response;

import lombok.Builder;

/**
 * 비용 조회 응답 데이터를 표현하는 DTO 클래스입니다.
 */
@Builder
public record GetExpenseInfoResponse(
    Long expenseId,        // 비용 ID
    String billingDetails, // 결제 세부 정보
    Double price           // 비용 금액
) {

}