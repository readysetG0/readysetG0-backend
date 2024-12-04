package com.readysetgo.traveltracker.debtor.application.port.out;

import com.readysetgo.traveltracker.debtor.application.port.in.CreateDebtorCommand;

/**
 * 채무자 생성 작업을 영속성 계층에 위임하기 위한 포트 인터페이스입니다.
 */
public interface CreateDebtorPort {

    /**
     * 채무자을 생성합니다.
     *
     * @param command 채무자 생성 명령 객체
     * @return 생성된 채무자 ID
     */
    Long createDebtor(CreateDebtorCommand command);
}