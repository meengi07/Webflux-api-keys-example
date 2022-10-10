package com.webflux.api.example.user.controller;

import com.webflux.api.example.user.models.User;
import com.webflux.api.example.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @GetMapping("/{id}")
    public Mono<User> getUserInfo(@PathVariable String id) {
        return userService.getUserInfo(id);
    }

    @GetMapping("/nickname/{id}")
    public Mono<String> getUserNickname(@PathVariable String id) {
        return userService.getUserInfo(id)
                .map(m -> m.getNickname());
    }

    @GetMapping("/list")
    public Flux<User> getUserList(User user) {
        return userService.getUserList(user);
    }


}
