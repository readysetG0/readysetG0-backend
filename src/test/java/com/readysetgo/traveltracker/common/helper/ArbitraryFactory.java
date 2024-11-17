package com.readysetgo.traveltracker.common.helper;

import com.readysetgo.traveltracker.common.helper.util.ArbitraryField;
import com.readysetgo.traveltracker.expense.adapter.in.web.request.CreateExpenseRequest;
import com.readysetgo.traveltracker.expense.adapter.in.web.request.UpdateExpenseRequest;
import com.readysetgo.traveltracker.expense.adapter.in.web.response.CreateExpenseResponse;
import com.readysetgo.traveltracker.expense.adapter.in.web.response.GetExpenseInfoResponse;
import com.readysetgo.traveltracker.expense.adapter.out.persistence.ExpenseJpaEntity;

/**
 * API 테스트에서 사용되는 요청 및 응답 객체를 생성하는 헬퍼 클래스입니다.
 * <p>
 * 테스트 시 반복적으로 생성되는 객체를 미리 정의하여, 테스트의 간결성과 가독성을 높입니다.
 * </p>
 */
public class ArbitraryFactory {

    /**
     * 비용(Expense) 관련 요청 및 응답 객체 생성을 위한 내부 클래스입니다.
     */
    public static class Expense {

        /**
         * 미리 정의된 비용 생성 요청 객체입니다.
         * <p>
         * 테스트에서 비용 생성 요청 데이터를 반복적으로 사용할 때 활용됩니다.
         * </p>
         */
        public static final CreateExpenseRequest aCreateExpenseRequest =
            CreateExpenseRequest.builder()
                .billingDetails(ArbitraryField.Expense.BILLING_DETAILS)
                .price(ArbitraryField.Expense.PRICE)
                .build();

        /**
         * 미리 정의된 비용 생성 응답 객체입니다.
         * <p>
         * 테스트에서 비용 생성 결과 데이터를 반복적으로 사용할 때 활용됩니다.
         * </p>
         */
        public static final CreateExpenseResponse aCreateExpenseResponse =
            CreateExpenseResponse.builder()
                .expenseId(ArbitraryField.Expense.EXPENSE_ID)
                .billingDetails(ArbitraryField.Expense.BILLING_DETAILS)
                .price(ArbitraryField.Expense.PRICE)
                .build();

        /**
         * 미리 정의된 비용 수정 요청 객체입니다.
         * <p>
         * 테스트에서 비용 수정 요청 데이터를 반복적으로 사용할 때 활용됩니다.
         * </p>
         */
        public static final UpdateExpenseRequest aUpdateExpenseRequest =
            UpdateExpenseRequest.builder()
                .expenseId(ArbitraryField.Expense.EXPENSE_ID)
                .billingDetails("Updated " + ArbitraryField.Expense.BILLING_DETAILS)
                .price(ArbitraryField.Expense.PRICE + 500.0) // 예시로 금액 증가
                .build();

        /**
         * 미리 정의된 비용 정보 조회 응답 객체입니다.
         * <p>
         * 테스트에서 비용 조회 결과 데이터를 반복적으로 사용할 때 활용됩니다.
         * </p>
         */
        public static final GetExpenseInfoResponse aGetExpenseInfoResponse =
            GetExpenseInfoResponse.builder()
                .expenseId(ArbitraryField.Expense.EXPENSE_ID)
                .price(ArbitraryField.Expense.PRICE)
                .billingDetails(ArbitraryField.Expense.BILLING_DETAILS)
                .build();

        /**
         * 미리 정의된 `ExpenseJpaEntity` 객체를 생성합니다.
         * <p>
         * 테스트에서 JPA 엔터티를 필요로 하는 경우에 활용됩니다.
         * </p>
         *
         * @return 미리 정의된 `ExpenseJpaEntity` 객체
         */
        public static ExpenseJpaEntity anExpenseJpaEntity() {
            return ExpenseJpaEntity.builder()
                .billingDetails(ArbitraryField.Expense.BILLING_DETAILS)
                .price(ArbitraryField.Expense.PRICE)
                .build();
        }
    }
}