package com.readysetgo.traveltracker.expense.adapter.in.web.request;

import lombok.Builder;

/**
 * 비용 수정 요청 데이터를 표현하는 DTO 클래스입니다.
 */
@Builder
public record UpdateExpenseRequest(
    Long expenseId,        // 비용 ID
    String billingDetails, // 수정할 결제 세부 정보
    Double price           // 수정할 비용 금액
) {

}