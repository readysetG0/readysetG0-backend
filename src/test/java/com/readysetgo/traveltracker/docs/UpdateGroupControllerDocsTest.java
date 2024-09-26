package com.readysetgo.traveltracker.docs;

import static java.time.LocalDateTime.now;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.multipart;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.preprocessResponse;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.prettyPrint;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.restdocs.request.RequestDocumentation.partWithName;
import static org.springframework.restdocs.request.RequestDocumentation.requestParts;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.readysetgo.traveltracker.group.adapter.in.web.request.UpdateGroupRequest;
import com.readysetgo.traveltracker.group.application.port.in.UpdateGroupCommand;
import com.readysetgo.traveltracker.group.application.port.in.UpdateGroupUseCase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.mock.web.MockPart;
import org.springframework.restdocs.payload.JsonFieldType;

public class UpdateGroupControllerDocsTest extends RestDocsSupport {

    @MockBean
    private UpdateGroupUseCase updateGroupUseCase;

    @DisplayName("그룹 수정 API")
    @Test
    void 그룹_수정_API() throws Exception {
        UpdateGroupRequest request = new UpdateGroupRequest(
            "제주도",
            now(),
            now().plusDays(1),
            "즐거운 제주도 여행",
            "1234"
        );

        given(updateGroupUseCase.updateGroup(any(UpdateGroupCommand.class)))
            .willReturn(true);

        mockMvc.perform(
                multipart("/v1/groups/{groupId}", 1)
                    .part(new MockPart(
                        "request",
                        "request",
                        objectMapper.writeValueAsBytes(request),
                        MediaType.APPLICATION_JSON))
                    .file(new MockMultipartFile("thumbnailImage", "thumbnailImage".getBytes()))
                    .with(mockRequest -> {
                        mockRequest.setMethod("PUT");
                        return mockRequest;
                    })
            )
            .andDo(print())
            .andExpect(status().isOk())
            .andDo(document("update-group",
                    preprocessResponse(prettyPrint()),
                    requestParts(
                        partWithName("request").description("그룹 정보"),
                        partWithName("thumbnailImage").description("썸네일 이미지")
                    ),
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
