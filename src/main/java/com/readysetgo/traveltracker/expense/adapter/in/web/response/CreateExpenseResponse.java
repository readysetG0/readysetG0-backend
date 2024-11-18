package com.readysetgo.traveltracker.expense.adapter.in.web.response;

import lombok.Builder;

/**
 * 비용 생성 응답 데이터를 표현하는 DTO 클래스입니다.
 */
@Builder
public record CreateExpenseResponse(
    Long expenseId,        // 생성된 비용 ID
    String billingDetails, // 결제 세부 정보
    Double price           // 비용 금액
) {

}