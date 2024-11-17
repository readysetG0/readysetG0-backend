package com.readysetgo.traveltracker.debtor.adapter.out;

import com.readysetgo.traveltracker.common.annotation.PersistenceAdapter;
import com.readysetgo.traveltracker.debtor.adapter.out.persistence.DebtorJpaEntity;
import com.readysetgo.traveltracker.debtor.adapter.out.persistence.DebtorRepository;
import com.readysetgo.traveltracker.debtor.application.port.out.LoadDebtorPort;
import com.readysetgo.traveltracker.debtor.domain.Debtor;
import lombok.RequiredArgsConstructor;

/**
 * 채무자 데이터를 조회하기 위한 어댑터 클래스입니다.
 */
@PersistenceAdapter
@RequiredArgsConstructor
public class LoadDebtorAdapter implements LoadDebtorPort {

    private final DebtorRepository debtorRepository;

    @Override
    public Debtor loadDebtor(Long debtorId) {
        DebtorJpaEntity debtor = debtorRepository.findById(debtorId)
            .orElseThrow(RuntimeException::new); // TODO: 적절한 커스텀 예외로 변경, 현재 500 발생

        return Debtor.builder()
            .id(debtor.getId())
            .build();
    }
}