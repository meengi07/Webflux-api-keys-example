package com.webflux.api.example.user.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY) // empty, null 빼고 데이터 주고받음
public class UserDTO {

    private String id;
    private String password;
    private String nickName;

    @Builder
    public UserDTO (UserEntity user) {
        this.id = user.getId();
        this.password = user.getPassword();
        this.nickName = user.getNickname();
    }

    @Builder
    public UserDTO(String nick) {
        this.nickName = nick;
    }
}
