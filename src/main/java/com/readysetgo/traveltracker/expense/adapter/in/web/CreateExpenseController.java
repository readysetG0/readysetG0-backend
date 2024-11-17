package com.readysetgo.traveltracker.expense.adapter.in.web;

import com.readysetgo.traveltracker.common.annotation.WebAdapter;
import com.readysetgo.traveltracker.expense.adapter.in.web.request.CreateExpenseRequest;
import com.readysetgo.traveltracker.expense.adapter.in.web.response.CreateExpenseResponse;
import com.readysetgo.traveltracker.expense.application.port.in.CreateExpenseCommand;
import com.readysetgo.traveltracker.expense.application.port.in.CreateExpenseUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 비용 생성 요청을 처리하는 컨트롤러 클래스입니다.
 */
@WebAdapter
@RestController
@RequiredArgsConstructor
public class CreateExpenseController {

    private final CreateExpenseUseCase createExpenseUseCase;

    /**
     * 비용 생성 요청을 처리합니다.
     *
     * @param request 비용 생성 요청 데이터
     * @return 생성된 비용 정보
     */
    @PostMapping("/v1/expenses")
    public CreateExpenseResponse createExpense(@RequestBody CreateExpenseRequest request) {
        return createExpenseUseCase.createExpense(CreateExpenseCommand.builder()
            .billingDetails(request.billingDetails())
            .price(request.price())
            .build());
    }
}