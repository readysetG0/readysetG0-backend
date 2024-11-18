package com.readysetgo.traveltracker.expense.adapter.out;

import static com.readysetgo.traveltracker.common.helper.ArbitraryFactory.Expense.anExpenseJpaEntity;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.closeTo;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

import com.readysetgo.traveltracker.expense.adapter.out.persistence.ExpenseJpaEntity;
import com.readysetgo.traveltracker.expense.adapter.out.persistence.ExpenseRepository;
import com.readysetgo.traveltracker.expense.domain.Expense;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * {@link LoadExpenseAdapter}에 대한 통합 테스트 클래스입니다.
 * <p>
 * 이 클래스는 데이터베이스와의 실제 상호작용을 통해 어댑터의 동작을 검증합니다.
 * </p>
 */
@SpringBootTest
class LoadExpenseAdapterTest {

    @Autowired
    private LoadExpenseAdapter loadExpenseAdapter;

    @Autowired
    private ExpenseRepository expenseRepository;

    /**
     * 각 테스트 후 데이터 정리를 수행합니다.
     */
    @AfterEach
    void tearDown() {
        expenseRepository.deleteAllInBatch(); // 데이터 정리
    }

    /**
     * 어댑터를 사용하여 데이터베이스에서 비용 정보를 불러오는 테스트입니다.
     */
    @DisplayName("데이터베이스에 저장된 비용을 어댑터로 불러올 때 유효한 비용 반환")
    @Test
    void expenseSavedInDatabase_loadedThroughAdapter_returnsValidExpense() {
        // given
        ExpenseJpaEntity expenseEntity = anExpenseJpaEntity();
        expenseRepository.save(expenseEntity);

        // when
        Expense expense = loadExpenseAdapter.loadExpense(expenseEntity.getId());

        // then
        assertThat(expense, is(notNullValue())); // 객체가 null이 아님을 확인
        assertThat(expense.getId(), is(equalTo(expenseEntity.getId())));
        assertThat(expense.getPrice(), is(closeTo(expenseEntity.getPrice(), 0.01)));
        assertThat(expense.getBillingDetails(), is(equalTo(expenseEntity.getBillingDetails())));
    }
}