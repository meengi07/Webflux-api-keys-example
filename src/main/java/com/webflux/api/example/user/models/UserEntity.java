package com.webflux.api.example.user.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table(name = "user")
public class UserEntity {

    @Id
    @Column("id")
    private String id;
    @Column("password")
    private String password;
    @Column("nickname")
    private String nickname;


}
