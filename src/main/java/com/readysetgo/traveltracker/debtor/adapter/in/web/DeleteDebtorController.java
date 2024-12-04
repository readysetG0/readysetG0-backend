package com.readysetgo.traveltracker.debtor.adapter.in.web;

import com.readysetgo.traveltracker.common.annotation.WebAdapter;
import com.readysetgo.traveltracker.debtor.application.port.in.DeleteDebtorUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * 채무자 삭제 요청을 처리하는 컨트롤러 클래스입니다.
 */
@WebAdapter
@RestController
@RequiredArgsConstructor
public class DeleteDebtorController {

    private final DeleteDebtorUseCase deleteDebtorUseCase;

    /**
     * 채무자을 삭제합니다.
     *
     * @param debtorId 삭제할 채무자 ID
     * @return 삭제 성공 여부
     */
    @DeleteMapping("/v1/debtors/{debtorId}")
    public Boolean deleteDebtor(@PathVariable Long debtorId) {
        return deleteDebtorUseCase.deleteDebtor(debtorId);
    }
}