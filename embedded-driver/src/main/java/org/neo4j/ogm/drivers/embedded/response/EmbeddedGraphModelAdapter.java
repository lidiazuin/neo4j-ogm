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
package org.neo4j.ogm.drivers.embedded.response;

import java.util.List;
import java.util.Map;

import org.neo4j.ogm.drivers.embedded.driver.EmbeddedEntityAdapter;
import org.neo4j.ogm.result.adapter.GraphModelAdapter;

/**
 * This adapter will transform an embedded response into a json response
 *
 * @author vince
 * @author Michael J. Simons
 */
public class EmbeddedGraphModelAdapter extends GraphModelAdapter {

    private final EmbeddedEntityAdapter entityAdapter;

    public EmbeddedGraphModelAdapter(EmbeddedEntityAdapter entityAdapter) {
        this.entityAdapter = entityAdapter;
    }

    @Override
    public boolean isPath(Object value) {
        return entityAdapter.isPath(value);
    }

    @Override
    public boolean isNode(Object value) {
        return entityAdapter.isNode(value);
    }

    @Override
    public boolean isRelationship(Object value) {
        return entityAdapter.isRelationship(value);
    }

    @Override
    public long nodeId(Object node) {
        return entityAdapter.nodeId(node);
    }

    @Override
    public List<String> labels(Object node) {
        return entityAdapter.labels(node);
    }

    @Override
    public long relationshipId(Object relationship) {
        return entityAdapter.relationshipId(relationship);
    }

    @Override
    public String relationshipType(Object relationship) {
        return entityAdapter.relationshipType(relationship);
    }

    @Override
    public Long startNodeId(Object relationship) {
        return entityAdapter.startNodeId(relationship);
    }

    @Override
    public Long endNodeId(Object relationship) {
        return entityAdapter.endNodeId(relationship);
    }

    @Override
    public Map<String, Object> properties(Object container) {
        return entityAdapter.properties(container);
    }

    @Override
    public List<Object> nodesInPath(Object path) {
        return entityAdapter.nodesInPath(path);
    }

    @Override
    public List<Object> relsInPath(Object path) {
        return entityAdapter.relsInPath(path);
    }
}
