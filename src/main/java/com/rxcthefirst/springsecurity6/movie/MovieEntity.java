package com.rxcthefirst.springsecurity6.movie;

import com.rxcthefirst.springsecurity6.person.PersonEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.neo4j.core.schema.*;

import java.util.HashSet;
import java.util.Set;

import static org.springframework.data.neo4j.core.schema.Relationship.Direction.INCOMING;

@Data
@Node("Movie")
public class MovieEntity {
    @Id
    @GeneratedValue
    private final Long Id;
    private final String title;
    @Property("tagline")
    private final String description;
    @Relationship(type = "ACTED_IN", direction = INCOMING)
    private Set<PersonEntity> actors = new HashSet<>();
    @Relationship(type = "DIRECTED", direction = INCOMING)
    private Set<PersonEntity> directors = new HashSet<>();
    //Getters omitted for brevity
}