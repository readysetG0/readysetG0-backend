package com.readysetgo.traveltracker.debtor.adapter.in.web;

import com.readysetgo.traveltracker.common.annotation.WebAdapter;
import com.readysetgo.traveltracker.debtor.adapter.in.web.response.GetDebtorInfoResponse;
import com.readysetgo.traveltracker.debtor.application.port.in.GetDebtorInfoQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * 채무자 조회 요청을 처리하는 컨트롤러 클래스입니다.
 */
@WebAdapter
@RestController
@RequiredArgsConstructor
public class GetDebtorInfoController {

    private final GetDebtorInfoQuery getDebtorInfoQuery;

    /**
     * 채무자 정보를 조회합니다.
     *
     * @param debtorId 조회할 채무자 ID
     * @return 채무자 정보
     */
    @GetMapping("/v1/debtors/{debtorId}")
    public GetDebtorInfoResponse getDebtorInfo(@PathVariable Long debtorId) {
        return getDebtorInfoQuery.getDebtorInfo(debtorId);
    }
}