package com.readysetgo.traveltracker.common.helper;

import static com.readysetgo.traveltracker.common.helper.util.ArbitraryField.Marker.DIARY_CONTENT;
import static com.readysetgo.traveltracker.common.helper.util.ArbitraryField.Marker.DIARY_TITLE;
import static com.readysetgo.traveltracker.common.helper.util.ArbitraryField.Marker.LATITUDE;
import static com.readysetgo.traveltracker.common.helper.util.ArbitraryField.Marker.LOCATION_NAME;
import static com.readysetgo.traveltracker.common.helper.util.ArbitraryField.Marker.LONGITUDE;
import static com.readysetgo.traveltracker.common.helper.util.ArbitraryField.Marker.UPDATED_DIARY_CONTENT;
import static com.readysetgo.traveltracker.common.helper.util.ArbitraryField.Marker.UPDATED_DIARY_TITLE;
import static com.readysetgo.traveltracker.common.helper.util.ArbitraryField.Marker.UPDATED_LOCATION_NAME;

import com.readysetgo.traveltracker.common.helper.util.ArbitraryField;
import com.readysetgo.traveltracker.marker.adapter.in.web.request.CreateMarkerRequest;
import com.readysetgo.traveltracker.marker.adapter.in.web.request.UpdateMarkerRequest;
import com.readysetgo.traveltracker.marker.adapter.in.web.response.CreateMarkerResponse;
import com.readysetgo.traveltracker.marker.adapter.in.web.response.GetMarkerInfoResponse;

/**
 * API 테스트에서 사용되는 요청 및 응답 객체를 생성하는 헬퍼 클래스입니다.
 * <p>
 * 테스트 시 반복적으로 생성되는 객체를 미리 정의하여, 테스트의 간결성과 가독성을 높입니다.
 * </p>
 */
public class ArbitraryFactory {

    /**
     * 마커 관련 요청 및 응답 객체 생성을 위한 내부 클래스입니다.
     */
    public static class Marker {

        /**
         * 마커 생성 요청 객체
         */
        public static final CreateMarkerRequest aCreateMarkerRequest =
            CreateMarkerRequest.builder()
                .diaryTitle(DIARY_TITLE)
                .diaryContent(DIARY_CONTENT)
                .locationName(LOCATION_NAME)
                .latitude(LATITUDE)
                .longitude(LONGITUDE)
                .build();

        /**
         * 마커 생성 응답 객체
         */
        public static final CreateMarkerResponse aCreateMarkerResponse =
            new CreateMarkerResponse(ArbitraryField.Marker.ID);

        /**
         * 마커 수정 요청 객체
         */
        public static final UpdateMarkerRequest aUpdateMarkerRequest =
            UpdateMarkerRequest.builder()
                .diaryTitle(UPDATED_DIARY_TITLE)
                .diaryContent(UPDATED_DIARY_CONTENT)
                .locationName(UPDATED_LOCATION_NAME)
                .build();

        /**
         * 마커 정보 조회 응답 객체
         */
        public static final GetMarkerInfoResponse aGetMarkerInfoResponse =
            GetMarkerInfoResponse.builder()
                .markerId(ArbitraryField.Marker.ID)
                .diaryTitle(DIARY_TITLE)
                .diaryContent(DIARY_CONTENT)
                .locationName(LOCATION_NAME)
                .latitude(LATITUDE)
                .longitude(LONGITUDE)
                .build();
    }
}