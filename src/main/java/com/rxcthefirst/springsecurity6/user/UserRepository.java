package com.rxcthefirst.springsecurity6.user;

import org.springframework.data.neo4j.repository.Neo4jRepository;

import java.util.Optional;

public interface UserRepository extends Neo4jRepository<User, Long> {

    Optional<User> findByEmail(String email);

}
