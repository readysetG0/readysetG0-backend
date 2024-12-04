package com.readysetgo.traveltracker.debtor.adapter.in.web;

import com.readysetgo.traveltracker.common.annotation.WebAdapter;
import com.readysetgo.traveltracker.debtor.adapter.in.web.request.CreateDebtorRequest;
import com.readysetgo.traveltracker.debtor.adapter.in.web.response.CreateDebtorResponse;
import com.readysetgo.traveltracker.debtor.application.port.in.CreateDebtorCommand;
import com.readysetgo.traveltracker.debtor.application.port.in.CreateDebtorUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 채무자 생성 요청을 처리하는 컨트롤러 클래스입니다.
 */
@WebAdapter
@RestController
@RequiredArgsConstructor
public class CreateDebtorController {

    private final CreateDebtorUseCase createDebtorUseCase;

    /**
     * 채무자 생성 요청을 처리합니다.
     *
     * @param request 채무자 생성 요청 데이터
     * @return 생성된 채무자 정보
     */
    @PostMapping("/v1/debtors")
    public CreateDebtorResponse createDebtor(@RequestBody CreateDebtorRequest request) {
        return createDebtorUseCase.createDebtor(CreateDebtorCommand.builder()
            .build());
    }
}