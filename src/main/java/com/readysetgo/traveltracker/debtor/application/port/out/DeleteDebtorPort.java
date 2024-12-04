package com.readysetgo.traveltracker.debtor.application.port.out;

/**
 * 채무자 삭제 작업을 영속성 계층에 위임하기 위한 포트 인터페이스입니다.
 */
public interface DeleteDebtorPort {

    /**
     * 채무자 데이터를 삭제합니다.
     *
     * @param debtorId 삭제할 채무자 ID
     * @return 삭제 성공 여부
     */
    Boolean deleteDebtor(Long debtorId);
}