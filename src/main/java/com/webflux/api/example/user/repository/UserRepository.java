package com.webflux.api.example.user.repository;

import com.webflux.api.example.user.models.User;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface UserRepository extends ReactiveCrudRepository<User,String> {
    @Query("SELECT * FROM USER WHERE STATUS = #{#user.status}")
    Flux<User> getUserList(User user);
}
