/*
 * Copyright (c) 2002-2021 "Neo4j,"
 * Neo4j Sweden AB [http://neo4j.com]
 *
 * This file is part of Neo4j.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.neo4j.ogm.domain.knowledge;

import java.util.ArrayList;
import java.util.List;

import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

/**
 * @author vince
 */
@NodeEntity
public class Person extends Entity {

    @Relationship(type = "KNOWS_PERSON")
    List<Knows> knownPersons = new ArrayList<>();

    @Relationship(type = "KNOWS_LANGUAGE")
    List<Knows> knownLanguages = new ArrayList<>();

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    public void knows(Person person) {

        Knows knows = new Knows();
        knows.knower = this;
        knows.knowee = person;

        knownPersons.add(knows);
    }

    public void knows(Language language) {

        Knows knows = new Knows();
        knows.knower = this;
        knows.knowee = language;

        knownLanguages.add(knows);
    }
}
