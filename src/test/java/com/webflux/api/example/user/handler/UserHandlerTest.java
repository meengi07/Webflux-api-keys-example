package com.webflux.api.example.user.handler;

import com.webflux.api.example.user.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class UserHandlerTest {

    private WebTestClient client;

    @Mock
    private UserService userService;

    @Autowired
    private UserHandler handler;

    @BeforeEach
    void setup() {
        RouterFunction<ServerResponse> router = RouterFunctions
                .route(RequestPredicates.GET("/user/nickname/{id}"), handler::getUserNickName)
                .andRoute(RequestPredicates.GET("/user/detail"), handler::getUserDetail);
        this.client = WebTestClient.bindToRouterFunction(router).build();
    }

    @Test
    void getUserNickName() {
        client.get()
            .uri("/user/nickname/{id}", "hello1")
            .headers(header -> {
                header.setContentType(MediaType.APPLICATION_JSON);
                // token... etc...
            })
            .exchange()
            .expectStatus()
            .isOk()
            .expectBody()
            .consumeWith(System.out::println);
    }

    @Test
    void getUserDetail() {
        client.get()
                .uri("/user/detail?id=hello1")
                .headers(header -> {
                    header.setContentType(MediaType.APPLICATION_JSON);
                })
                .exchange()
                .expectStatus()
                .isOk()
                .expectBody()
                .consumeWith(System.out::println);
    }
}