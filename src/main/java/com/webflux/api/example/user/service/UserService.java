package com.webflux.api.example.user.service;

import com.webflux.api.example.user.models.User;
import com.webflux.api.example.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public Mono<User> getUserInfo(String id) {
        return userRepository.findById(id);
    }

    public Flux<User> getUserList(User user) {
        return userRepository.getUserList(user);
    }

}
