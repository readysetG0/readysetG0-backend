package com.readysetgo.traveltracker.expense.application.port.in;

import lombok.Builder;

/**
 * 비용 생성 비즈니스 로직에 필요한 데이터를 전달하는 명령 객체입니다.
 */
@Builder
public record CreateExpenseCommand(
    String billingDetails, // 결제 세부 정보
    Double price           // 비용 금액
) {

}