package com.readysetgo.traveltracker.expense.adapter.in.web.request;

import lombok.Builder;

/**
 * 비용 생성 요청 데이터를 표현하는 DTO 클래스입니다.
 */
@Builder
public record CreateExpenseRequest(
    String billingDetails, // 결제 세부 정보
    Double price           // 비용 금액
) {

}