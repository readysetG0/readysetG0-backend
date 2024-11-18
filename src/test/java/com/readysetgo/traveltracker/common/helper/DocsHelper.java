package com.readysetgo.traveltracker.common.helper;

import static com.readysetgo.traveltracker.common.helper.util.ArbitraryField.Category;
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

    /**
     * 카테고리 관련 API 문서화를 위한 내부 클래스입니다.
     */
    public static class CategoryDocs {

        /**
         * 카테고리 생성 API 문서화를 위한 메서드입니다.
         *
         * @return 카테고리 생성 API의 요청/응답 문서화 설정이 적용된 {@link ResultHandler}
         */
        public static ResultHandler createCategoryDocumentation() {
            return MockMvcRestDocumentation.document(Category.DOC_SECTION_CREATE,
                preprocessRequest(prettyPrint()),
                preprocessResponse(prettyPrint()),
                requestFields(
                    fieldWithPath("name").type(STRING).description("카테고리 이름")
                ),
                responseFields(
                    fieldWithPath("status").type(STRING).description("API 성공 여부"),
                    fieldWithPath("data.categoryId").type(NUMBER).description("생성된 카테고리 ID"),
                    fieldWithPath("error").type(NULL).description("에러 정보")
                )
            );
        }

        /**
         * 카테고리 조회 API 문서화를 위한 메서드입니다.
         *
         * @return 카테고리 조회 API의 응답 문서화 설정이 적용된 {@link ResultHandler}
         */
        public static ResultHandler getCategoryDocumentation() {
            return MockMvcRestDocumentation.document(Category.DOC_SECTION_GET,
                preprocessResponse(prettyPrint()),
                responseFields(
                    fieldWithPath("status").type(STRING).description("API 성공 여부"),
                    fieldWithPath("data.categoryId").type(NUMBER).description("카테고리 ID"),
                    fieldWithPath("data.name").type(STRING).description("카테고리 이름"),
                    fieldWithPath("error").type(NULL).description("에러 정보")
                )
            );
        }

        /**
         * 카테고리 삭제 API 문서화를 위한 메서드입니다.
         *
         * @return 카테고리 삭제 API의 응답 문서화 설정이 적용된 {@link ResultHandler}
         */
        public static ResultHandler deleteCategoryDocumentation() {
            return MockMvcRestDocumentation.document(Category.DOC_SECTION_DELETE,
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