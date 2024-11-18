package com.readysetgo.traveltracker.common.helper;

import static com.readysetgo.traveltracker.common.helper.util.ArbitraryField.Expense;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.preprocessRequest;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.preprocessResponse;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.prettyPrint;
import static org.springframework.restdocs.payload.JsonFieldType.BOOLEAN;
import static org.springframework.restdocs.payload.JsonFieldType.NULL;
import static org.springframework.restdocs.payload.JsonFieldType.NUMBER;
import static org.springframework.restdocs.payload.JsonFieldType.STRING;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.requestFields;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;

import org.springframework.restdocs.mockmvc.MockMvcRestDocumentation;
import org.springframework.test.web.servlet.ResultHandler;

/**
 * API 문서화를 위한 헬퍼 클래스입니다.
 * <p>
 * 각종 도메인 API의 요청 및 응답 필드를 문서화하여 Spring REST Docs를 통해 API 문서를 생성할 수 있도록 지원합니다.
 * </p>
 */
public class DocsHelper {

    public static class ExpenseDocs {

        /**
         * 비용 생성 API 문서화를 위한 메서드입니다.
         * <p>
         * 비용 생성 요청과 응답 필드를 정의하여 문서화에 활용합니다.
         * </p>
         *
         * @return 비용 생성 API의 요청/응답 문서화 설정이 적용된 {@link ResultHandler}
         */
        public static ResultHandler createExpenseDocumentation() {
            return MockMvcRestDocumentation.document(Expense.DOC_SECTION_CREATE_EXPENSE,
                preprocessRequest(prettyPrint()),
                preprocessResponse(prettyPrint()),
                requestFields(
                    fieldWithPath("billingDetails").type(STRING).description("비용 제목"),
                    fieldWithPath("price").type(NUMBER).description("비용 금액")
                ),
                responseFields(
                    fieldWithPath("status").type(STRING).description("API 성공 여부"),
                    fieldWithPath("data.billingDetails").type(STRING).description("비용 제목"),
                    fieldWithPath("data.price").type(NUMBER).description("비용 금액"),
                    fieldWithPath("data.expenseId").type(NUMBER).description("생성된 비용 ID"),
                    fieldWithPath("error").type(NULL).description("에러 정보")
                )
            );
        }

        /**
         * 비용 조회 API 문서화를 위한 메서드입니다.
         * <p>
         * 비용 조회 요청에 대한 응답 필드를 정의하여 문서화에 활용합니다.
         * </p>
         *
         * @return 비용 조회 API의 응답 문서화 설정이 적용된 {@link ResultHandler}
         */
        public static ResultHandler getExpenseDocumentation() {
            return MockMvcRestDocumentation.document(Expense.DOC_SECTION_GET_EXPENSE,
                preprocessResponse(prettyPrint()),
                responseFields(
                    fieldWithPath("status").description("응답 상태"),
                    fieldWithPath("data.expenseId").description("비용 ID"),
                    fieldWithPath("data.price").description("가격"),
                    fieldWithPath("data.billingDetails").description("청구 상세 정보"),
                    fieldWithPath("error").description("오류 정보").optional()
                )
            );
        }

        /**
         * 비용 수정 API 문서화를 위한 메서드입니다.
         * <p>
         * 비용 수정 요청과 응답 필드를 정의하여 문서화에 활용합니다.
         * </p>
         *
         * @return 비용 수정 API의 요청/응답 문서화 설정이 적용된 {@link ResultHandler}
         */
        public static ResultHandler updateExpenseDocumentation() {
            return MockMvcRestDocumentation.document(Expense.DOC_SECTION_UPDATE_EXPENSE,
                preprocessRequest(prettyPrint()),
                preprocessResponse(prettyPrint()),
                requestFields(
                    fieldWithPath("expenseId").type(NUMBER).description("수정할 비용 ID"),
                    fieldWithPath("billingDetails").type(STRING).description("수정할 비용 제목"),
                    fieldWithPath("price").type(NUMBER).description("수정할 비용 금액")
                ),
                responseFields(
                    fieldWithPath("status").type(STRING).description("API 성공 여부"),
                    fieldWithPath("data").type(BOOLEAN).description("수정 성공 여부"),
                    fieldWithPath("error").type(NULL).description("에러 정보")
                )
            );
        }

        /**
         * 비용 삭제 API 문서화를 위한 메서드입니다.
         * <p>
         * 비용 삭제 요청에 대한 응답 필드를 정의하여 문서화에 활용합니다.
         * </p>
         *
         * @return 비용 삭제 API의 응답 문서화 설정이 적용된 {@link ResultHandler}
         */
        public static ResultHandler deleteExpenseDocumentation() {
            return MockMvcRestDocumentation.document(Expense.DOC_SECTION_DELETE_EXPENSE,
                preprocessResponse(prettyPrint()),
                responseFields(
                    fieldWithPath("status").type(STRING).description("API 성공 여부"),
                    fieldWithPath("data").type(BOOLEAN).description("삭제 성공 여부"),
                    fieldWithPath("error").type(NULL).description("에러 정보")
                )
            );
        }
    }
}