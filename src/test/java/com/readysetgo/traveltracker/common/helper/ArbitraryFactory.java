package com.readysetgo.traveltracker.common.helper;

import com.readysetgo.traveltracker.common.helper.util.ArbitraryField;
import com.readysetgo.traveltracker.debtor.adapter.in.web.request.CreateDebtorRequest;
import com.readysetgo.traveltracker.debtor.adapter.in.web.response.CreateDebtorResponse;
import com.readysetgo.traveltracker.debtor.adapter.in.web.response.GetDebtorInfoResponse;
import com.readysetgo.traveltracker.debtor.adapter.out.persistence.DebtorJpaEntity;

/**
 * API 테스트에서 사용되는 요청 및 응답 객체를 생성하는 헬퍼 클래스입니다.
 * <p>
 * 테스트 시 반복적으로 생성되는 객체를 미리 정의하여, 테스트의 간결성과 가독성을 높입니다.
 * </p>
 */
public class ArbitraryFactory {

    /**
     * 채무자(Debtor) 관련 요청 및 응답 객체 생성을 위한 내부 클래스입니다.
     */
    public static class Debtor {

        /**
         * 미리 정의된 채무자 생성 요청 객체입니다.
         * <p>
         * 테스트에서 채무자 생성 요청 데이터를 반복적으로 사용할 때 활용됩니다.
         * </p>
         */
        public static final CreateDebtorRequest aCreateDebtorRequest =
            CreateDebtorRequest.builder()
                .build();

        /**
         * 미리 정의된 채무자 생성 응답 객체입니다.
         * <p>
         * 테스트에서 채무자 생성 결과 데이터를 반복적으로 사용할 때 활용됩니다.
         * </p>
         */
        public static final CreateDebtorResponse aCreateDebtorResponse =
            CreateDebtorResponse.builder()
                .debtorId(ArbitraryField.Debtor.DEBTOR_ID)
                .build();

        /**
         * 미리 정의된 채무자 정보 조회 응답 객체입니다.
         * <p>
         * 테스트에서 채무자 조회 결과 데이터를 반복적으로 사용할 때 활용됩니다.
         * </p>
         */
        public static final GetDebtorInfoResponse aGetDebtorInfoResponse =
            GetDebtorInfoResponse.builder()
                .debtorId(ArbitraryField.Debtor.DEBTOR_ID)
                .build();

        /**
         * 미리 정의된 `DebtorJpaEntity` 객체를 생성합니다.
         * <p>
         * 테스트에서 JPA 엔터티를 필요로 하는 경우에 활용됩니다.
         * </p>
         *
         * @return 미리 정의된 `DebtorJpaEntity` 객체
         */
        public static DebtorJpaEntity aDebtorJpaEntity() {
            return new DebtorJpaEntity();
        }
    }
}