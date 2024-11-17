package com.readysetgo.traveltracker.debtor.adapter;

import static com.readysetgo.traveltracker.common.helper.ArbitraryFactory.Debtor.aDebtorJpaEntity;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

import com.readysetgo.traveltracker.debtor.adapter.out.LoadDebtorAdapter;
import com.readysetgo.traveltracker.debtor.adapter.out.persistence.DebtorJpaEntity;
import com.readysetgo.traveltracker.debtor.adapter.out.persistence.DebtorRepository;
import com.readysetgo.traveltracker.debtor.domain.Debtor;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * {@link LoadDebtorAdapter}에 대한 통합 테스트 클래스입니다.
 * <p>
 * 이 클래스는 데이터베이스와의 실제 상호작용을 통해 어댑터의 동작을 검증합니다.
 * </p>
 */
@SpringBootTest
class LoadDebtorAdapterTest {

    @Autowired
    private LoadDebtorAdapter loadDebtorAdapter;

    @Autowired
    private DebtorRepository debtorRepository;

    /**
     * 각 테스트 후 데이터 정리를 수행합니다.
     */
    @AfterEach
    void tearDown() {
        debtorRepository.deleteAllInBatch(); // 데이터 정리
    }

    /**
     * 어댑터를 사용하여 데이터베이스에서 채무자 정보를 불러오는 테스트입니다.
     */
    @DisplayName("데이터베이스에 저장된 채무자을 어댑터로 불러올 때 유효한 채무자 반환")
    @Test
    void debtorSavedInDatabase_loadedThroughAdapter_returnsValidDebtor() {
        // given
        DebtorJpaEntity debtorEntity = aDebtorJpaEntity();
        debtorRepository.save(debtorEntity);

        // when
        Debtor debtor = loadDebtorAdapter.loadDebtor(debtorEntity.getId());

        // then
        assertThat(debtor, is(notNullValue())); // 객체가 null이 아님을 확인
        assertThat(debtor.getId(), is(equalTo(debtorEntity.getId())));
    }
}