package com.readysetgo.traveltracker.debtor.application.port.in;

import lombok.Builder;

/**
 * 채무자 생성 비즈니스 로직에 필요한 데이터를 전달하는 명령 객체입니다.
 */
@Builder
public record CreateDebtorCommand(

) {

}