package com.readysetgo.traveltracker.docs;

import static com.readysetgo.traveltracker.common.helper.ArbitraryFactory.Marker.aCreateMarkerRequest;
import static com.readysetgo.traveltracker.common.helper.ArbitraryFactory.Marker.aCreateMarkerResponse;
import static com.readysetgo.traveltracker.common.helper.ArbitraryFactory.Marker.aGetMarkerInfoResponse;
import static com.readysetgo.traveltracker.common.helper.ArbitraryFactory.Marker.aUpdateMarkerRequest;
import static com.readysetgo.traveltracker.common.helper.DocsHelper.MarkerDocs.createMarkerDocumentation;
import static com.readysetgo.traveltracker.common.helper.DocsHelper.MarkerDocs.deleteMarkerDocumentation;
import static com.readysetgo.traveltracker.common.helper.DocsHelper.MarkerDocs.getMarkerDocumentation;
import static com.readysetgo.traveltracker.common.helper.DocsHelper.MarkerDocs.updateMarkerDocumentation;
import static com.readysetgo.traveltracker.common.helper.util.ArbitraryField.Marker.ID;
import static com.readysetgo.traveltracker.common.helper.util.ArbitraryField.Marker.MARKER_BASE_URL;
import static com.readysetgo.traveltracker.common.helper.util.ArbitraryField.Marker.MARKER_ID_URL;
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

import com.readysetgo.traveltracker.marker.application.port.in.CreateMarkerCommand;
import com.readysetgo.traveltracker.marker.application.port.in.CreateMarkerUseCase;
import com.readysetgo.traveltracker.marker.application.port.in.DeleteMarkerUseCase;
import com.readysetgo.traveltracker.marker.application.port.in.GetMarkerInfoQuery;
import com.readysetgo.traveltracker.marker.application.port.in.UpdateMarkerCommand;
import com.readysetgo.traveltracker.marker.application.port.in.UpdateMarkerUseCase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

/**
 * 마커 API에 대한 REST Docs 테스트 클래스입니다.
 * <p>
 * 마커 생성, 조회, 수정, 삭제 요청의 API 문서화를 위해 MockMVC와 REST Docs를 이용해 요청 및 응답 필드를 문서화하고 예제 테스트 케이스를 제공합니다.
 * </p>
 */
@DisplayName("마커 API 문서 생성 테스트")
public class MarkerControllerDocsTest extends RestDocsSupport {

    @MockBean
    private CreateMarkerUseCase createMarkerUseCase;

    @MockBean
    private GetMarkerInfoQuery getMarkerInfoQuery;

    @MockBean
    private UpdateMarkerUseCase updateMarkerUseCase;

    @MockBean
    private DeleteMarkerUseCase deleteMarkerUseCase;

    /**
     * 마커 생성 요청에 대한 API 문서화 테스트 클래스입니다.
     */
    @Nested
    @DisplayName("마커 생성 요청")
    class CreateMarker {

        /**
         * 유효한 마커 생성 요청 시 성공적으로 마커가 생성되고, API 문서화가 수행됩니다.
         *
         * @throws Exception MockMVC 요청 수행 시 발생할 수 있는 예외
         */
        @Test
        @DisplayName("마커 생성 성공")
        void validMarkerRequest_createsMarker_returnsCreatedStatus() throws Exception {
            given(createMarkerUseCase.createMarker(any(CreateMarkerCommand.class)))
                .willReturn(aCreateMarkerResponse);

            String body = objectMapper.writeValueAsString(aCreateMarkerRequest);

            mockMvc.perform(post(MARKER_BASE_URL)
                    .contentType(APPLICATION_JSON)
                    .content(body))
                .andDo(print())
                .andExpect(status().isOk()) //TODO: 201로 수정 필요
                .andDo(createMarkerDocumentation());
        }
    }

    /**
     * 마커 조회 요청에 대한 API 문서화 테스트 클래스입니다.
     */
    @Nested
    @DisplayName("마커 조회 요청")
    class GetMarkerInfo {

        /**
         * 존재하는 마커 ID로 요청 시, 마커 정보를 성공적으로 조회하고 API 문서화가 수행됩니다.
         *
         * @throws Exception MockMVC 요청 수행 시 발생할 수 있는 예외
         */
        @Test
        @DisplayName("마커 조회 성공")
        void existingMarkerId_retrievesMarker_returnsMarkerDetails() throws Exception {
            given(getMarkerInfoQuery.getMarkerInfo(anyLong()))
                .willReturn(aGetMarkerInfoResponse);

            mockMvc.perform(get(MARKER_ID_URL, ID))
                .andDo(print())
                .andExpect(status().isOk())
                .andDo(getMarkerDocumentation());
        }
    }

    /**
     * 마커 수정 요청에 대한 API 문서화 테스트 클래스입니다.
     */
    @Nested
    @DisplayName("마커 수정 요청")
    class UpdateMarker {

        /**
         * 유효한 마커 수정 요청 시 성공적으로 마커가 수정되고, API 문서화가 수행됩니다.
         *
         * @throws Exception MockMVC 요청 수행 시 발생할 수 있는 예외
         */
        @Test
        @DisplayName("마커 수정 성공")
        void validUpdateRequest_updatesMarker_returnsOkStatus() throws Exception {
            given(updateMarkerUseCase.updateMarker(any(UpdateMarkerCommand.class)))
                .willReturn(true);

            String body = objectMapper.writeValueAsString(aUpdateMarkerRequest);

            mockMvc.perform(put(MARKER_ID_URL, ID)
                    .contentType(APPLICATION_JSON)
                    .content(body))
                .andDo(print())
                .andExpect(status().isOk())
                .andDo(updateMarkerDocumentation());
        }
    }

    /**
     * 마커 삭제 요청에 대한 API 문서화 테스트 클래스입니다.
     */
    @Nested
    @DisplayName("마커 삭제 요청")
    class DeleteMarker {

        /**
         * 존재하는 마커 ID로 삭제 요청 시, 성공적으로 마커가 삭제되고 API 문서화가 수행됩니다.
         *
         * @throws Exception MockMVC 요청 수행 시 발생할 수 있는 예외
         */
        @Test
        @DisplayName("마커 삭제 성공")
        void existingMarkerId_deletesMarker_returnsNoContentStatus() throws Exception {
            given(deleteMarkerUseCase.deleteMarker(anyLong())).willReturn(true);

            mockMvc.perform(delete(MARKER_ID_URL, ID))
                .andDo(print())
                .andExpect(status().isOk()) //TODO: 204로 수정 필요
                .andDo(deleteMarkerDocumentation());
        }
    }
}