package com.readysetgo.traveltracker.debtor.application.service;

import com.readysetgo.traveltracker.common.annotation.UseCase;
import com.readysetgo.traveltracker.debtor.adapter.in.web.response.CreateDebtorResponse;
import com.readysetgo.traveltracker.debtor.application.port.in.CreateDebtorCommand;
import com.readysetgo.traveltracker.debtor.application.port.in.CreateDebtorUseCase;
import com.readysetgo.traveltracker.debtor.application.port.out.CreateDebtorPort;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

/**
 * 채무자 생성 비즈니스 로직을 처리하는 서비스 클래스입니다.
 */
@UseCase
@Transactional
@RequiredArgsConstructor
public class CreateDebtorService implements CreateDebtorUseCase {

    private final CreateDebtorPort createDebtorPort;

    @Override
    public CreateDebtorResponse createDebtor(CreateDebtorCommand command) {
        return CreateDebtorResponse.builder()
            .debtorId(createDebtorPort.createDebtor(command))
            .build();
    }
}