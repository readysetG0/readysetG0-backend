package com.readysetgo.traveltracker.docs;

import static java.time.LocalDateTime.now;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.post;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.preprocessRequest;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.preprocessResponse;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.prettyPrint;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.requestFields;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.readysetgo.traveltracker.group.adapter.in.web.request.CreateGroupRequest;
import com.readysetgo.traveltracker.group.adapter.in.web.response.CreateGroupResponse;
import com.readysetgo.traveltracker.group.application.port.in.CreateGroupUseCase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.restdocs.payload.JsonFieldType;

public class CreateGroupControllerDocsTest extends RestDocsSupport {

    @MockBean
    private CreateGroupUseCase createGroupUseCase;

    @DisplayName("그룹 생성 API")
    @Test
    void 그룹_생성_API() throws Exception {
        CreateGroupRequest request = new CreateGroupRequest(
            "제주도",
            now(),
            now().plusDays(1),
            "즐거운 제주도 여행",
            "1234",
            "https://sample-image.url"
        );

        CreateGroupResponse response = new CreateGroupResponse(1L);

        given(createGroupUseCase.createGroup(any()))
            .willReturn(response);

        mockMvc.perform(
                post("/v1/groups")
                    .content(objectMapper.writeValueAsString(request))
                    .contentType(MediaType.APPLICATION_JSON)
            )
            .andDo(print())
            .andExpect(status().isOk())
            .andDo(document("create-group",
                    preprocessRequest(prettyPrint()),
                    preprocessResponse(prettyPrint()),
                    requestFields(
                        fieldWithPath("destination").type(JsonFieldType.STRING)
                            .description("목적지"),
                        fieldWithPath("startDate").type(JsonFieldType.STRING)
                            .description("시작 날짜"),
                        fieldWithPath("endDate").type(JsonFieldType.STRING)
                            .description("종료 날짜"),
                        fieldWithPath("title").type(JsonFieldType.STRING)
                            .description("제목"),
                        fieldWithPath("password").type(JsonFieldType.STRING)
                            .description("비밀번호"),
                        fieldWithPath("thumbnailUrl").type(JsonFieldType.STRING)
                            .description("썸네일 이미지 url")
                    ),
                    responseFields(
                        fieldWithPath("status").type(JsonFieldType.STRING)
                            .description("API 성공 여부"),
                        fieldWithPath("data").type(JsonFieldType.OBJECT)
                            .description("응답"),
                        fieldWithPath("data.groupId").type(JsonFieldType.NUMBER)
                            .description("그룹 id"),
                        fieldWithPath("error").type(JsonFieldType.NULL)
                            .description("에러")
                    )
                )
            );

    }
}
