package com.readysetgo.traveltracker.user.adapter.out.persistence.repository;

import com.readysetgo.traveltracker.user.adapter.out.persistence.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

}
