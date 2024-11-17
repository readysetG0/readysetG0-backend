package com.readysetgo.traveltracker.debtor.application.port.in;

import com.readysetgo.traveltracker.debtor.adapter.in.web.response.GetDebtorInfoResponse;

/**
 * 채무자 조회 유스케이스 인터페이스입니다.
 */
public interface GetDebtorInfoQuery {

    /**
     * 채무자 정보를 조회합니다.
     *
     * @param debtorId 조회할 채무자 ID
     * @return 채무자 정보 응답 객체
     */
    GetDebtorInfoResponse getDebtorInfo(Long debtorId);
}