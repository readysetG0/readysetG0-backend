package com.readysetgo.traveltracker.expense.application.port.in;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;

/**
 * 비용 수정 비즈니스 로직에 필요한 데이터를 전달하는 명령 객체입니다.
 */
@Builder
public record UpdateExpenseCommand(
    @NotNull Long expenseId,        // 수정할 비용 ID
    @NotNull String billingDetails, // 수정할 결제 세부 정보
    @NotNull Double price           // 수정할 비용 금액
) {

}