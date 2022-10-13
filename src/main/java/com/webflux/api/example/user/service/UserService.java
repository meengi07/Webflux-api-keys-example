package com.webflux.api.example.user.service;

import com.webflux.api.example.user.models.UserDTO;
import com.webflux.api.example.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public Mono<UserDTO> getUserNickName(String id) {
        return userRepository.findById(id).map(m -> new UserDTO(m.getNickname()));
    }

    public Mono<UserDTO> getUserDetail(String id) {

        return userRepository.findById(id).map(m -> new UserDTO(m));
    }

}
