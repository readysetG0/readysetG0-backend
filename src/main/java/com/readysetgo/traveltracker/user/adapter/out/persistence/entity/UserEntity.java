package com.readysetgo.traveltracker.user.adapter.out.persistence.entity;

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

    @Column(unique = true)
    private Long email;

    @Column(name="SOCIAL_TYPE", nullable = false)
    private String socialType;

    @Column(name="SOCIAL_ID", nullable = false)
    private String socialId;

    @Column(nullable = false, unique = true)
    private String fcmId;
}
