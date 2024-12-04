package com.readysetgo.traveltracker.debtor.application.service;

import com.readysetgo.traveltracker.common.annotation.UseCase;
import com.readysetgo.traveltracker.debtor.adapter.in.web.response.GetDebtorInfoResponse;
import com.readysetgo.traveltracker.debtor.application.port.in.GetDebtorInfoQuery;
import com.readysetgo.traveltracker.debtor.application.port.out.LoadDebtorPort;
import com.readysetgo.traveltracker.debtor.domain.Debtor;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

/**
 * 채무자 조회 비즈니스 로직을 처리하는 서비스 클래스입니다.
 */
@UseCase
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class GetDebtorInfoService implements GetDebtorInfoQuery {

    private final LoadDebtorPort loadDebtorPort;

    @Override
    public GetDebtorInfoResponse getDebtorInfo(Long debtorId) {
        Debtor debtor = loadDebtorPort.loadDebtor(debtorId);
        return GetDebtorInfoResponse.builder()
            .debtorId(debtor.getId())
            .build();
    }
}