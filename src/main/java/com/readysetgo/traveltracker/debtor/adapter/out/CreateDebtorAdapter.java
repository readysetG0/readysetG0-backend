package com.readysetgo.traveltracker.debtor.adapter.out;

import com.readysetgo.traveltracker.common.annotation.PersistenceAdapter;
import com.readysetgo.traveltracker.debtor.adapter.out.persistence.DebtorJpaEntity;
import com.readysetgo.traveltracker.debtor.adapter.out.persistence.DebtorRepository;
import com.readysetgo.traveltracker.debtor.application.port.in.CreateDebtorCommand;
import com.readysetgo.traveltracker.debtor.application.port.out.CreateDebtorPort;
import lombok.RequiredArgsConstructor;

/**
 * 채무자 데이터를 영속성 계층에 저장하는 어댑터 클래스입니다.
 */
@PersistenceAdapter
@RequiredArgsConstructor
public class CreateDebtorAdapter implements CreateDebtorPort {

    private final DebtorRepository debtorRepository;

    @Override
    public Long createDebtor(CreateDebtorCommand command) {
        DebtorJpaEntity debtor = createDebtorEntity(command);
        debtorRepository.save(debtor);

        return debtor.getId();
    }

    private DebtorJpaEntity createDebtorEntity(CreateDebtorCommand command) {
        return new DebtorJpaEntity();
    }
}