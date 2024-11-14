package com.readysetgo.traveltracker.group.application.service;

import static java.time.LocalDateTime.now;
import static java.time.temporal.ChronoUnit.DAYS;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

import com.readysetgo.traveltracker.group.adapter.in.web.response.GetGroupInfoResponse;
import com.readysetgo.traveltracker.group.application.port.out.LoadGroupPort;
import com.readysetgo.traveltracker.group.domain.Group;
import java.time.LocalDateTime;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GetGroupInfoServiceTest {

    private final LoadGroupPort loadGroupPort = mock(LoadGroupPort.class);

    private final GetGroupInfoService getGroupInfoService = new GetGroupInfoService(loadGroupPort);

    @DisplayName("여행의 시작 날짜와 종료 날짜를 조회한다.")
    @Test
    void 여행의_시작_날짜와_종료_날짜를_조회한다() {
        //given
        LocalDateTime dateTime = now();

        Group group = Group.of(1L, dateTime, dateTime.plus(1L, DAYS));

        given(loadGroupPort.loadGroup(any(Long.class))).willReturn(group);

        //when
        GetGroupInfoResponse response = getGroupInfoService.getGroupInfo(1L);

        //then
        assertThat(response).extracting("startDate", "endDate")
            .containsExactly(dateTime, dateTime.plus(1L, DAYS));
    }
}