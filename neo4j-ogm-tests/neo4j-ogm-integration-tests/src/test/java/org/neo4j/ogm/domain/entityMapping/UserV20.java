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
package org.neo4j.ogm.domain.entityMapping;

import org.neo4j.ogm.annotation.Relationship;

/**
 * Two annotated incoming fields, same relationship type
 *
 * @author Luanne Misquitta
 */
public class UserV20 {

    @Relationship(type = "KNOWS", direction = Relationship.Direction.INCOMING)
    UserV20 user;

    @Relationship(type = "KNOWS", direction = Relationship.Direction.INCOMING)
    PlainUser plainUser;

    public UserV20() {
    }

    public UserV20 getUser() {
        return user;
    }

    public PlainUser getPlainUser() {
        return plainUser;
    }
}
