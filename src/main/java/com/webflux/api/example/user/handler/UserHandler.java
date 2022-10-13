package com.webflux.api.example.user.handler;

import com.webflux.api.example.user.models.UserDTO;
import com.webflux.api.example.user.models.UserEntity;
import com.webflux.api.example.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class UserHandler {

    private final UserService userService;
    private final Logger logger = LoggerFactory.getLogger(UserHandler.class);

    public Mono<ServerResponse> getUserNickName (ServerRequest request) {
        logger.info("Check Params : " + request);
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(userService.getUserNickName(request.pathVariable("id")), UserEntity.class);
    }

    public Mono<ServerResponse> getUserDetail (ServerRequest request) {
        logger.info("Check Params : " + request.bodyToMono(UserDTO.class));
        // MultiValueMap<String, String> params = request.queryParams(); ver1 : map


        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(userService.getUserDetail(request.queryParam("id").get()), UserEntity.class);
    }
}
