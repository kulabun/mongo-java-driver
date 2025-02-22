/*
 * Copyright 2008-present MongoDB, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.mongodb.client;

import com.mongodb.MongoClientSettings;
import org.bson.BsonArray;
import org.bson.BsonDocument;

import static com.mongodb.ClusterFixture.isServerlessTest;
import static org.junit.Assume.assumeFalse;

public class ServerDiscoveryAndMonitoringTest extends AbstractServerDiscoveryAndMonitoringTest {
    public ServerDiscoveryAndMonitoringTest(final String filename, final String description, final String databaseName,
                                            final String collectionName, final BsonArray data, final BsonDocument definition,
                                            final boolean skipTest) {
        super(filename, description, databaseName, collectionName, data, definition, skipTest);
        assumeFalse(isServerlessTest());
    }

    @Override
    protected MongoClient createMongoClient(final MongoClientSettings settings) {
        return MongoClients.create(settings);
    }
}
