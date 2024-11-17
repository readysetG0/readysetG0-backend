package com.readysetgo.traveltracker.debtor.adapter.out;

import com.readysetgo.traveltracker.common.annotation.PersistenceAdapter;
import com.readysetgo.traveltracker.debtor.adapter.out.persistence.DebtorRepository;
import com.readysetgo.traveltracker.debtor.application.port.out.DeleteDebtorPort;
import lombok.RequiredArgsConstructor;

/**
 * 채무자 데이터를 삭제하기 위한 어댑터 클래스입니다.
 */
@PersistenceAdapter
@RequiredArgsConstructor
public class DeleteDebtorAdapter implements DeleteDebtorPort {

    private final DebtorRepository debtorRepository;

    @Override
    public Boolean deleteDebtor(Long debtorId) {
        debtorRepository.deleteById(debtorId);
        return true; //TODO: 필요시 요청에 따른 응답으로 변경
    }
}