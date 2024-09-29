package com.readysetgo.traveltracker.user.adapter.out.persistence.entity;

import com.readysetgo.traveltracker.user.domain.enumeration.SocialType;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
@Table(name="USER", uniqueConstraints = {
        @UniqueConstraint(
                name="SOCIAL_UNIQUE",
                columnNames={"SOCIAL_TYPE","SOCIAL_ID"}
        )})
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String email;

    @Column(name="SOCIAL_TYPE", nullable = false)
    @Enumerated(EnumType.STRING)
    private SocialType socialType;

    @Column(name="SOCIAL_ID", nullable = false)
    private String socialId;

    @Column(nullable = false, unique = true)
    private String fcmId;
}
