package com.webflux.api.example.user.models;

import lombok.Data;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@Data
public class User {

    private String id;
    private String password;
    private String nickname;
    private String status;

}
