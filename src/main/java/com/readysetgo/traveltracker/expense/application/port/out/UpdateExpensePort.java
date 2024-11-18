package com.readysetgo.traveltracker.expense.application.port.out;

import com.readysetgo.traveltracker.expense.application.port.in.UpdateExpenseCommand;

/**
 * 비용 수정 작업을 영속성 계층에 위임하기 위한 포트 인터페이스입니다.
 */
public interface UpdateExpensePort {

    /**
     * 비용 데이터를 수정합니다.
     *
     * @param command 비용 수정 명령 객체
     * @return 수정 성공 여부
     */
    boolean updateExpense(UpdateExpenseCommand command);
}