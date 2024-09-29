package com.readysetgo.traveltracker.user.adapter.out.persistence;

import com.readysetgo.traveltracker.user.adapter.out.mapper.UserMapper;
import com.readysetgo.traveltracker.user.adapter.out.persistence.entity.UserEntity;
import com.readysetgo.traveltracker.user.adapter.out.persistence.repository.UserRepository;
import com.readysetgo.traveltracker.user.application.port.out.UserPort;
import com.readysetgo.traveltracker.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UserRepositoryAdapter implements UserPort {

    private final UserRepository userRepository;

    @Override
    public User find(Long id) {
        //Todo 커스텀 exception 수정 필요
        UserEntity userEntity = userRepository.findById(id).orElseThrow(() -> new RuntimeException("not exist user"));

        return UserMapper.toDomain(userEntity);
    }
}
