package com.readysetgo.traveltracker.debtor.application.service;

import com.readysetgo.traveltracker.common.annotation.UseCase;
import com.readysetgo.traveltracker.debtor.application.port.in.DeleteDebtorUseCase;
import com.readysetgo.traveltracker.debtor.application.port.out.DeleteDebtorPort;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

/**
 * 채무자 삭제 비즈니스 로직을 처리하는 서비스 클래스입니다.
 */
@UseCase
@Transactional
@RequiredArgsConstructor
public class DeleteDebtorService implements DeleteDebtorUseCase {

    private final DeleteDebtorPort deleteDebtorPort;

    @Override
    public boolean deleteDebtor(Long debtorId) {
        return deleteDebtorPort.deleteDebtor(debtorId);
    }
}