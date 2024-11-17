package com.readysetgo.traveltracker.debtor.application.port.in;

/**
 * 채무자 삭제 유스케이스 인터페이스입니다.
 */
public interface DeleteDebtorUseCase {

    /**
     * 채무자을 삭제합니다.
     *
     * @param debtorId 삭제할 채무자 ID
     * @return 삭제 성공 여부
     */
    boolean deleteDebtor(Long debtorId);
}