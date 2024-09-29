package com.readysetgo.traveltracker.docs;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.delete;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.preprocessResponse;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.prettyPrint;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.readysetgo.traveltracker.group.application.port.in.DeleteGroupUseCase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.restdocs.payload.JsonFieldType;

public class DeleteGroupControllerDocsTest extends RestDocsSupport {

    @MockBean
    private DeleteGroupUseCase deleteGroupUseCase;

    @DisplayName("그룹 삭제 API")
    @Test
    void 그룹_삭제_API() throws Exception {
        given(deleteGroupUseCase.deleteGroup(any(Long.class)))
            .willReturn(true);

        mockMvc.perform(
                delete("/v1/groups/{groupId}", 1)
            )
            .andDo(print())
            .andExpect(status().isOk())
            .andDo(document("delete-group",
                    preprocessResponse(prettyPrint()),
                    responseFields(
                        fieldWithPath("status").type(JsonFieldType.STRING)
                            .description("API 성공 여부"),
                        fieldWithPath("data").type(JsonFieldType.BOOLEAN)
                            .description("응답"),
                        fieldWithPath("error").type(JsonFieldType.NULL)
                            .description("에러")
                    )
                )
            );
    }
}
