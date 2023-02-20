package com.Dashboard.demo;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface Repo extends MongoRepository<User,Integer> {
    List<User> findByName(String name);

    void deleteByName(String name);
}
