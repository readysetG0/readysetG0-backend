package com.readysetgo.traveltracker.docs;

import static com.readysetgo.traveltracker.common.helper.ArbitraryFactory.Debtor.aCreateDebtorRequest;
import static com.readysetgo.traveltracker.common.helper.ArbitraryFactory.Debtor.aCreateDebtorResponse;
import static com.readysetgo.traveltracker.common.helper.ArbitraryFactory.Debtor.aGetDebtorInfoResponse;
import static com.readysetgo.traveltracker.common.helper.DocsHelper.DebtorDocs.createDebtorDocumentation;
import static com.readysetgo.traveltracker.common.helper.DocsHelper.DebtorDocs.deleteDebtorDocumentation;
import static com.readysetgo.traveltracker.common.helper.DocsHelper.DebtorDocs.getDebtorDocumentation;
import static com.readysetgo.traveltracker.common.helper.util.ArbitraryField.Debtor.DEBTOR_BASE_URL;
import static com.readysetgo.traveltracker.common.helper.util.ArbitraryField.Debtor.DEBTOR_ID_URL;
import static com.readysetgo.traveltracker.common.helper.util.ArbitraryField.Debtor.ID;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.readysetgo.traveltracker.debtor.application.port.in.CreateDebtorCommand;
import com.readysetgo.traveltracker.debtor.application.port.in.CreateDebtorUseCase;
import com.readysetgo.traveltracker.debtor.application.port.in.DeleteDebtorUseCase;
import com.readysetgo.traveltracker.debtor.application.port.in.GetDebtorInfoQuery;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.ResultActions;

/**
 * 채무자 API에 대한 REST Docs 테스트 클래스입니다.
 * <p>
 * 채무자 생성, 조회, 수정, 삭제 요청의 API 문서화를 위해 MockMVC와 REST Docs를 이용해 요청 및 응답 필드를 문서화하고 예제 테스트 케이스를 제공합니다.
 * </p>
 */
@DisplayName("채무자 API 문서 생성 테스트")
public class DebtorControllerDocsTest extends RestDocsSupport {

    @MockBean
    private CreateDebtorUseCase createDebtorUseCase;

    @MockBean
    private GetDebtorInfoQuery getDebtorInfoQuery;

    @MockBean
    private DeleteDebtorUseCase deleteDebtorUseCase;

    /**
     * 채무자 생성 요청에 대한 API 문서화 테스트 클래스입니다.
     */
    @Nested
    @DisplayName("채무자 생성 요청")
    class CreateDebtor {

        /**
         * 유효한 채무자 생성 요청 시 성공적으로 채무자가 생성되고, API 문서화가 수행됩니다.
         *
         * @throws Exception MockMVC 요청 수행 시 발생할 수 있는 예외
         */
        @Test
        @DisplayName("채무자 생성 성공")
        void validDebtorRequest_createsDebtor_returnsCreatedStatus() throws Exception {
            given(createDebtorUseCase.createDebtor(any(CreateDebtorCommand.class)))
                .willReturn(aCreateDebtorResponse);

            String body = objectMapper.writeValueAsString(aCreateDebtorRequest);

            ResultActions perform = mockMvc.perform(post(DEBTOR_BASE_URL)
                .contentType(APPLICATION_JSON)
                .content(body));
            perform
                .andDo(print())
                .andExpect(status().isOk()) //TODO: 201로 수정 필요
                .andDo(createDebtorDocumentation());
        }
    }

    /**
     * 채무자 조회 요청에 대한 API 문서화 테스트 클래스입니다.
     */
    @Nested
    @DisplayName("채무자 조회 요청")
    class GetDebtorInfo {

        /**
         * 존재하는 채무자 ID로 요청 시, 채무자 정보를 성공적으로 조회하고 API 문서화가 수행됩니다.
         *
         * @throws Exception MockMVC 요청 수행 시 발생할 수 있는 예외
         */
        @Test
        @DisplayName("채무자 조회 성공")
        void existingDebtorId_retrievesDebtor_returnsDebtorDetails() throws Exception {
            given(getDebtorInfoQuery.getDebtorInfo(anyLong()))
                .willReturn(aGetDebtorInfoResponse);

            mockMvc.perform(get(DEBTOR_ID_URL, ID))
                .andDo(print())
                .andExpect(status().isOk())
                .andDo(getDebtorDocumentation());
        }
    }

    /**
     * 채무자 삭제 요청에 대한 API 문서화 테스트 클래스입니다.
     */
    @Nested
    @DisplayName("채무자 삭제 요청")
    class DeleteDebtor {

        /**
         * 존재하는 채무자 ID로 삭제 요청 시, 성공적으로 채무자가 삭제되고 API 문서화가 수행됩니다.
         *
         * @throws Exception MockMVC 요청 수행 시 발생할 수 있는 예외
         */
        @Test
        @DisplayName("채무자 삭제 성공")
        void existingDebtorId_deletesDebtor_returnsNoContentStatus() throws Exception {
            given(deleteDebtorUseCase.deleteDebtor(anyLong())).willReturn(true);

            mockMvc.perform(delete(DEBTOR_ID_URL, ID))
                .andDo(print())
                .andExpect(status().isOk()) //TODO: 204로 수정 필요
                .andDo(deleteDebtorDocumentation());
        }
    }
}