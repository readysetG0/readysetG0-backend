package com.readysetgo.traveltracker.docs;

import static com.readysetgo.traveltracker.common.helper.ArbitraryFactory.Category.aCreateCategoryRequest;
import static com.readysetgo.traveltracker.common.helper.ArbitraryFactory.Category.aCreateCategoryResponse;
import static com.readysetgo.traveltracker.common.helper.ArbitraryFactory.Category.aGetCategoryInfoResponse;
import static com.readysetgo.traveltracker.common.helper.DocsHelper.CategoryDocs.createCategoryDocumentation;
import static com.readysetgo.traveltracker.common.helper.DocsHelper.CategoryDocs.deleteCategoryDocumentation;
import static com.readysetgo.traveltracker.common.helper.DocsHelper.CategoryDocs.getCategoryDocumentation;
import static com.readysetgo.traveltracker.common.helper.util.ArbitraryField.Category.CATEGORY_BASE_URL;
import static com.readysetgo.traveltracker.common.helper.util.ArbitraryField.Category.CATEGORY_ID_URL;
import static com.readysetgo.traveltracker.common.helper.util.ArbitraryField.Category.ID;
import static com.readysetgo.traveltracker.common.helper.util.ArbitraryField.Category.NAME;
import static org.mockito.BDDMockito.any;
import static org.mockito.BDDMockito.anyLong;
import static org.mockito.BDDMockito.given;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.readysetgo.traveltracker.category.application.port.in.CreateCategoryCommand;
import com.readysetgo.traveltracker.category.application.port.in.CreateCategoryUseCase;
import com.readysetgo.traveltracker.category.application.port.in.DeleteCategoryUseCase;
import com.readysetgo.traveltracker.category.application.port.in.GetCategoryInfoQuery;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

/**
 * 카테고리 API에 대한 REST Docs 테스트 클래스입니다.
 * <p>
 * 카테고리 생성, 조회, 수정, 삭제 요청의 API 문서화를 위해 MockMVC와 REST Docs를 이용해 요청 및 응답 필드를 문서화하고 예제 테스트 케이스를 제공합니다.
 * </p>
 */
@DisplayName("카테고리 API 문서 생성 테스트")
public class CategoryControllerDocsTest extends RestDocsSupport {

    @MockBean
    private CreateCategoryUseCase createCategoryUseCase;

    @MockBean
    private GetCategoryInfoQuery getCategoryInfoQuery;

    @MockBean
    private DeleteCategoryUseCase deleteCategoryUseCase;

    /**
     * 카테고리 생성 요청에 대한 API 문서화 테스트 클래스입니다.
     */
    @Nested
    @DisplayName("카테고리 생성 요청")
    class CreateCategory {

        /**
         * 유효한 카테고리 생성 요청 시 성공적으로 카테고리가 생성되고, API 문서화가 수행됩니다.
         *
         * @throws Exception MockMVC 요청 수행 시 발생할 수 있는 예외
         */
        @Test
        @DisplayName("카테고리 생성 성공")
        void validCategoryRequest_createsCategory_returnsCreatedStatus() throws Exception {
            // given
            given(createCategoryUseCase.createCategory(any(CreateCategoryCommand.class)))
                .willReturn(aCreateCategoryResponse);

            String body = objectMapper.writeValueAsString(aCreateCategoryRequest);

            // when, then
            mockMvc.perform(post(CATEGORY_BASE_URL)
                    .contentType(APPLICATION_JSON)
                    .content(body))
                .andDo(print())
                .andExpect(status().isOk()) //TODO: 201 로 수정 필요
                .andDo(createCategoryDocumentation());
        }
    }

    /**
     * 카테고리 조회 요청에 대한 API 문서화 테스트 클래스입니다.
     */
    @Nested
    @DisplayName("카테고리 조회 요청")
    class GetCategoryInfo {

        /**
         * 존재하는 카테고리 ID로 요청 시, 카테고리 정보를 성공적으로 조회하고 API 문서화가 수행됩니다.
         *
         * @throws Exception MockMVC 요청 수행 시 발생할 수 있는 예외
         */
        @Test
        @DisplayName("카테고리 조회 성공")
        void existingCategoryId_retrievesCategory_returnsCategoryDetails() throws Exception {
            // given
            given(getCategoryInfoQuery.getCategoryInfo(anyLong()))
                .willReturn(aGetCategoryInfoResponse);

            // when, then
            mockMvc.perform(get(CATEGORY_ID_URL, ID))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.categoryId").value(ID))
                .andExpect(jsonPath("$.data.name").value(NAME))
                .andDo(getCategoryDocumentation());
        }
    }


    /**
     * 카테고리 삭제 요청에 대한 API 문서화 테스트 클래스입니다.
     */
    @Nested
    @DisplayName("카테고리 삭제 요청")
    class DeleteCategory {

        /**
         * 존재하는 카테고리 ID로 삭제 요청 시, 성공적으로 카테고리가 삭제되고 API 문서화가 수행됩니다.
         *
         * @throws Exception MockMVC 요청 수행 시 발생할 수 있는 예외
         */
        @Test
        @DisplayName("카테고리 삭제 성공")
        void existingCategoryId_deletesCategory_returnsNoContentStatus() throws Exception {
            // given
            given(deleteCategoryUseCase.deleteCategory(anyLong())).willReturn(true);

            // when, then
            mockMvc.perform(delete(CATEGORY_ID_URL, ID))
                .andDo(print())
                .andExpect(status().isOk()) //TODO: 204로 수정 필요
                .andDo(deleteCategoryDocumentation());
        }
    }
}