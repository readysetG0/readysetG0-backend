package com.readysetgo.traveltracker.docs;

import static java.time.LocalDateTime.now;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.preprocessResponse;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.prettyPrint;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.readysetgo.traveltracker.group.adapter.in.web.response.GetGroupInfoResponse;
import com.readysetgo.traveltracker.group.application.port.in.GetGroupInfoQuery;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.restdocs.payload.JsonFieldType;

public class GetGroupControllerDocsTest extends RestDocsSupport {

    @MockBean
    private GetGroupInfoQuery getGroupInfoQuery;

    @DisplayName("그룹 정보 조회 API")
    @Test
    void 그룹_정보_조회_API() throws Exception {
        GetGroupInfoResponse response = new GetGroupInfoResponse(
            now(),
            now().plusDays(1)
        );

        given(getGroupInfoQuery.getGroupInfo(any(Long.class))).willReturn(response);

        mockMvc.perform(
                get("/v1/groups/{groupId}", 1)
            )
            .andDo(print())
            .andExpect(status().isOk())
            .andDo(document("get-group-info",
                    preprocessResponse(prettyPrint()),
                    responseFields(
                        fieldWithPath("status").type(JsonFieldType.STRING)
                            .description("API 성공 여부"),
                        fieldWithPath("data").type(JsonFieldType.OBJECT)
                            .description("응답"),
                        fieldWithPath("data.startDate").type(JsonFieldType.STRING)
                            .description("시작 날짜"),
                        fieldWithPath("data.endDate").type(JsonFieldType.STRING)
                            .description("종료 날짜"),
                        fieldWithPath("error").type(JsonFieldType.NULL)
                            .description("에러")
                    )
                )
            );

    }
}
