package com.readysetgo.traveltracker.debtor.application.port.in;

import com.readysetgo.traveltracker.debtor.adapter.in.web.response.CreateDebtorResponse;

/**
 * 채무자 생성 유스케이스 인터페이스입니다.
 */
public interface CreateDebtorUseCase {

    /**
     * 채무자을 생성합니다.
     *
     * @param command 채무자 생성 명령 객체
     * @return 생성된 채무자 정보
     */
    CreateDebtorResponse createDebtor(CreateDebtorCommand command);
}