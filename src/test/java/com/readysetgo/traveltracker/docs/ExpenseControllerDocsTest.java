package com.readysetgo.traveltracker.docs;

import static com.readysetgo.traveltracker.common.helper.ArbitraryFactory.Expense.aCreateExpenseRequest;
import static com.readysetgo.traveltracker.common.helper.ArbitraryFactory.Expense.aCreateExpenseResponse;
import static com.readysetgo.traveltracker.common.helper.ArbitraryFactory.Expense.aGetExpenseInfoResponse;
import static com.readysetgo.traveltracker.common.helper.ArbitraryFactory.Expense.aUpdateExpenseRequest;
import static com.readysetgo.traveltracker.common.helper.DocsHelper.ExpenseDocs.createExpenseDocumentation;
import static com.readysetgo.traveltracker.common.helper.DocsHelper.ExpenseDocs.deleteExpenseDocumentation;
import static com.readysetgo.traveltracker.common.helper.DocsHelper.ExpenseDocs.getExpenseDocumentation;
import static com.readysetgo.traveltracker.common.helper.DocsHelper.ExpenseDocs.updateExpenseDocumentation;
import static com.readysetgo.traveltracker.common.helper.util.ArbitraryField.Expense.EXPENSE_BASE_URL;
import static com.readysetgo.traveltracker.common.helper.util.ArbitraryField.Expense.EXPENSE_ID_URL;
import static com.readysetgo.traveltracker.common.helper.util.ArbitraryField.Expense.ID;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.readysetgo.traveltracker.expense.application.port.in.CreateExpenseCommand;
import com.readysetgo.traveltracker.expense.application.port.in.CreateExpenseUseCase;
import com.readysetgo.traveltracker.expense.application.port.in.DeleteExpenseUseCase;
import com.readysetgo.traveltracker.expense.application.port.in.GetExpenseInfoQuery;
import com.readysetgo.traveltracker.expense.application.port.in.UpdateExpenseCommand;
import com.readysetgo.traveltracker.expense.application.port.in.UpdateExpenseUseCase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.ResultActions;

/**
 * 비용 API에 대한 REST Docs 테스트 클래스입니다.
 * <p>
 * 비용 생성, 조회, 수정, 삭제 요청의 API 문서화를 위해 MockMVC와 REST Docs를 이용해 요청 및 응답 필드를 문서화하고 예제 테스트 케이스를 제공합니다.
 * </p>
 */
@DisplayName("비용 API 문서 생성 테스트")
public class ExpenseControllerDocsTest extends RestDocsSupport {

    @MockBean
    private CreateExpenseUseCase createExpenseUseCase;

    @MockBean
    private GetExpenseInfoQuery getExpenseInfoQuery;

    @MockBean
    private UpdateExpenseUseCase updateExpenseUseCase;

    @MockBean
    private DeleteExpenseUseCase deleteExpenseUseCase;

    /**
     * 비용 생성 요청에 대한 API 문서화 테스트 클래스입니다.
     */
    @Nested
    @DisplayName("비용 생성 요청")
    class CreateExpense {

        /**
         * 유효한 비용 생성 요청 시 성공적으로 비용가 생성되고, API 문서화가 수행됩니다.
         *
         * @throws Exception MockMVC 요청 수행 시 발생할 수 있는 예외
         */
        @Test
        @DisplayName("비용 생성 성공")
        void validExpenseRequest_createsExpense_returnsCreatedStatus() throws Exception {
            given(createExpenseUseCase.createExpense(any(CreateExpenseCommand.class)))
                .willReturn(aCreateExpenseResponse);

            String body = objectMapper.writeValueAsString(aCreateExpenseRequest);

            ResultActions perform = mockMvc.perform(post(EXPENSE_BASE_URL)
                .contentType(APPLICATION_JSON)
                .content(body));
            perform
                .andDo(print())
                .andExpect(status().isOk()) //TODO: 201로 수정 필요
                .andDo(createExpenseDocumentation());
        }
    }

    /**
     * 비용 조회 요청에 대한 API 문서화 테스트 클래스입니다.
     */
    @Nested
    @DisplayName("비용 조회 요청")
    class GetExpenseInfo {

        /**
         * 존재하는 비용 ID로 요청 시, 비용 정보를 성공적으로 조회하고 API 문서화가 수행됩니다.
         *
         * @throws Exception MockMVC 요청 수행 시 발생할 수 있는 예외
         */
        @Test
        @DisplayName("비용 조회 성공")
        void existingExpenseId_retrievesExpense_returnsExpenseDetails() throws Exception {
            given(getExpenseInfoQuery.getExpenseInfo(anyLong()))
                .willReturn(aGetExpenseInfoResponse);

            mockMvc.perform(get(EXPENSE_ID_URL, ID))
                .andDo(print())
                .andExpect(status().isOk())
                .andDo(getExpenseDocumentation());
        }
    }

    /**
     * 비용 수정 요청에 대한 API 문서화 테스트 클래스입니다.
     */
    @Nested
    @DisplayName("비용 수정 요청")
    class UpdateExpense {

        /**
         * 유효한 비용 수정 요청 시 성공적으로 비용가 수정되고, API 문서화가 수행됩니다.
         *
         * @throws Exception MockMVC 요청 수행 시 발생할 수 있는 예외
         */
        @Test
        @DisplayName("비용 수정 성공")
        void validUpdateRequest_updatesExpense_returnsOkStatus() throws Exception {
            given(updateExpenseUseCase.updateExpense(any(UpdateExpenseCommand.class)))
                .willReturn(true);

            String body = objectMapper.writeValueAsString(aUpdateExpenseRequest);

            mockMvc.perform(put(EXPENSE_ID_URL, ID)
                    .contentType(APPLICATION_JSON)
                    .content(body))
                .andDo(print())
                .andExpect(status().isOk())
                .andDo(updateExpenseDocumentation());
        }
    }

    /**
     * 비용 삭제 요청에 대한 API 문서화 테스트 클래스입니다.
     */
    @Nested
    @DisplayName("비용 삭제 요청")
    class DeleteExpense {

        /**
         * 존재하는 비용 ID로 삭제 요청 시, 성공적으로 비용가 삭제되고 API 문서화가 수행됩니다.
         *
         * @throws Exception MockMVC 요청 수행 시 발생할 수 있는 예외
         */
        @Test
        @DisplayName("비용 삭제 성공")
        void existingExpenseId_deletesExpense_returnsNoContentStatus() throws Exception {
            given(deleteExpenseUseCase.deleteExpense(anyLong())).willReturn(true);

            mockMvc.perform(delete(EXPENSE_ID_URL, ID))
                .andDo(print())
                .andExpect(status().isOk()) //TODO: 204로 수정 필요
                .andDo(deleteExpenseDocumentation());
        }
    }
}