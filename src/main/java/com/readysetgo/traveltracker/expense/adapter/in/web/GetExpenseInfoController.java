package com.readysetgo.traveltracker.expense.adapter.in.web;

import com.readysetgo.traveltracker.common.annotation.WebAdapter;
import com.readysetgo.traveltracker.expense.adapter.in.web.response.GetExpenseInfoResponse;
import com.readysetgo.traveltracker.expense.application.port.in.GetExpenseInfoQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * 비용 조회 요청을 처리하는 컨트롤러 클래스입니다.
 */
@WebAdapter
@RestController
@RequiredArgsConstructor
public class GetExpenseInfoController {

    private final GetExpenseInfoQuery getExpenseInfoQuery;

    /**
     * 비용 정보를 조회합니다.
     *
     * @param expenseId 조회할 비용 ID
     * @return 비용 정보
     */
    @GetMapping("/v1/expenses/{expenseId}")
    public GetExpenseInfoResponse getExpenseInfo(@PathVariable Long expenseId) {
        return getExpenseInfoQuery.getExpenseInfo(expenseId);
    }
}