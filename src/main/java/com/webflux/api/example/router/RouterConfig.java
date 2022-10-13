package com.webflux.api.example.router;

import com.webflux.api.example.user.handler.UserHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.accept;


@Configuration
@EnableWebFlux
@RequiredArgsConstructor
public class RouterConfig {

    private final UserHandler userHandler;

    @Bean
    public RouterFunction<ServerResponse> routes() {
        return RouterFunctions
                .route()
                .path("/user", builder -> builder
                        .nest(accept(MediaType.APPLICATION_JSON), builder2 -> builder2
                                .GET("/detail", userHandler::getUserDetail))
                                .GET("/nickname/{id}", userHandler::getUserNickName)
                ).build();
    }
}
