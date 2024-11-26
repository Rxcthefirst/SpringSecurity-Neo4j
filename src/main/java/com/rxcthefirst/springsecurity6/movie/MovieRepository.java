package com.rxcthefirst.springsecurity6.movie;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import reactor.core.publisher.Mono;

import java.util.Optional;

public interface MovieRepository extends Neo4jRepository<MovieEntity, Long> {
    Optional<MovieEntity> findOneByTitle(String title);
}
