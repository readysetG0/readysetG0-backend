package com.readysetgo.traveltracker.debtor.adapter.in.web.response;

import lombok.Builder;

/**
 * 채무자 조회 응답 데이터를 표현하는 DTO 클래스입니다.
 */
@Builder
public record GetDebtorInfoResponse(
    Long debtorId        // 채무자 ID
) {

}