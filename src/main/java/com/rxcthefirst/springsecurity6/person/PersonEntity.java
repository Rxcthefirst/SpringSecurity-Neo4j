package com.rxcthefirst.springsecurity6.person;

import lombok.Data;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;


@Data
@Node("Person")
public class PersonEntity {
    @Id
    private final String name;
    private final Integer born;
    public PersonEntity(Integer born, String name) {
        this.born = born;
        this.name = name;
    }
}
