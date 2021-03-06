package com.alexggg99.domain;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by Alex on 27.11.2015.
 */
public interface UserRepository extends CrudRepository<User, Long> {
    public User findUserByUsername(String username);
}
