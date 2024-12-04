package com.readysetgo.traveltracker.debtor.application.port.out;

import com.readysetgo.traveltracker.debtor.domain.Debtor;

/**
 * 채무자 조회 작업을 영속성 계층에 위임하기 위한 포트 인터페이스입니다.
 */
public interface LoadDebtorPort {

    /**
     * 채무자 데이터를 조회합니다.
     *
     * @param debtorId 조회할 채무자 ID
     * @return 채무자 도메인 객체
     */
    Debtor loadDebtor(Long debtorId);
}