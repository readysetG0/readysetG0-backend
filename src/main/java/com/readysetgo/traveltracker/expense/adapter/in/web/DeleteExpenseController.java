package com.readysetgo.traveltracker.expense.adapter.in.web;

import com.readysetgo.traveltracker.common.annotation.WebAdapter;
import com.readysetgo.traveltracker.expense.application.port.in.DeleteExpenseUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * 비용 삭제 요청을 처리하는 컨트롤러 클래스입니다.
 */
@WebAdapter
@RestController
@RequiredArgsConstructor
public class DeleteExpenseController {

    private final DeleteExpenseUseCase deleteExpenseUseCase;

    /**
     * 비용을 삭제합니다.
     *
     * @param expenseId 삭제할 비용 ID
     * @return 삭제 성공 여부
     */
    @DeleteMapping("/v1/expenses/{expenseId}")
    public Boolean deleteExpense(@PathVariable Long expenseId) {
        return deleteExpenseUseCase.deleteExpense(expenseId);
    }
}