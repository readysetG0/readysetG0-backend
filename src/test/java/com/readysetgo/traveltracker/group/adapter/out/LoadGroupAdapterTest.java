package com.readysetgo.traveltracker.group.adapter.out;

import static java.time.LocalDateTime.now;
import static java.time.temporal.ChronoUnit.MILLIS;
import static org.assertj.core.api.Assertions.assertThat;

import com.readysetgo.traveltracker.group.adapter.out.group.GroupJpaEntity;
import com.readysetgo.traveltracker.group.adapter.out.group.GroupRepository;
import com.readysetgo.traveltracker.group.adapter.out.group.LoadGroupAdapter;
import com.readysetgo.traveltracker.group.domain.Group;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class LoadGroupAdapterTest {

    @Autowired
    private LoadGroupAdapter loadGroupAdapter;

    @Autowired
    private GroupRepository groupRepository;

    @AfterEach
    void tearDown() {
        groupRepository.deleteAllInBatch();
    }

    @DisplayName("그룹 정보를 데이터베이스에서 불러온다.")
    @Test
    void 그룹_정보를_데이터베이스에서_불러온다() {
        //given
        GroupJpaEntity groupEntity = createGroup();
        groupRepository.save(groupEntity);

        //when
        Group group = loadGroupAdapter.loadGroup(groupEntity.getId());

        //then
        assertThat(group).extracting("id", "startDate", "endDate")
            .containsExactly(
                groupEntity.getId(),
                groupEntity.getStartDate().truncatedTo(MILLIS),
                groupEntity.getEndDate().truncatedTo(MILLIS)
            );
    }

    private GroupJpaEntity createGroup() {
        return GroupJpaEntity.builder()
            .destination("제주도")
            .startDate(now().truncatedTo(MILLIS))
            .endDate(now().plusDays(1).truncatedTo(MILLIS))
            .title("즐거운 제주도 여행")
            .password("1234")
            .thumbnailUrl("https://sample-image.url")
            .build();
    }
}