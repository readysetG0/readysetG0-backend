package com.readysetgo.traveltracker.expense.adapter.in.web;

import com.readysetgo.traveltracker.common.annotation.WebAdapter;
import com.readysetgo.traveltracker.expense.adapter.in.web.request.UpdateExpenseRequest;
import com.readysetgo.traveltracker.expense.application.port.in.UpdateExpenseCommand;
import com.readysetgo.traveltracker.expense.application.port.in.UpdateExpenseUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 비용 수정 요청을 처리하는 컨트롤러 클래스입니다.
 */
@WebAdapter
@RestController
@RequiredArgsConstructor
public class UpdateExpenseController {

    private final UpdateExpenseUseCase updateExpenseUseCase;

    /**
     * 비용 정보를 수정합니다.
     *
     * @param expenseId 수정할 비용 ID
     * @param request   수정 요청 데이터
     * @return 수정 성공 여부
     */
    @PutMapping("/v1/expenses/{expenseId}")
    public Boolean updateExpense(
        @PathVariable Long expenseId,
        @RequestBody UpdateExpenseRequest request
    ) {
        return updateExpenseUseCase.updateExpense(UpdateExpenseCommand.builder()
            .expenseId(expenseId)
            .billingDetails(request.billingDetails())
            .price(request.price())
            .build());
    }
}