/*
 * Copyright (c) 2002-2022 "Neo4j,"
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
package org.neo4j.ogm.drivers.embedded.transaction;

import org.neo4j.graphdb.Transaction;
import org.neo4j.ogm.exception.TransactionException;
import org.neo4j.ogm.transaction.AbstractTransaction;
import org.neo4j.ogm.transaction.TransactionManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Vince Bickers
 * @author Michael J. Simons
 */
public class EmbeddedTransaction extends AbstractTransaction {

    private final org.neo4j.graphdb.Transaction nativeTransaction;
    private final Logger LOGGER = LoggerFactory.getLogger(EmbeddedTransaction.class);

    /**
     * Request a new transaction.
     * Creates a new user transaction for the current thread, and associates it with
     * a new or existing native transaction in the underlying database. All commit and rollback operations
     * on the user transaction are delegated to the native transaction.
     *
     * @param transactionManager an instance of {@link TransactionManager}
     * @param nativeTransaction  the {@link org.neo4j.graphdb.Transaction} backing this Transaction object
     * @param type               the {@link org.neo4j.ogm.transaction.Transaction.Type} of this transaction
     */
    public EmbeddedTransaction(TransactionManager transactionManager, Transaction nativeTransaction, Type type) {

        super(transactionManager);
        this.nativeTransaction = nativeTransaction;
        this.type = type;
    }

    @Override
    public void rollback() {

        try {
            if (transactionManager.canRollback()) {

                LOGGER.debug("rolling back native transaction: {}", nativeTransaction);
                nativeTransaction.rollback();
                nativeTransaction.close();
            }
        } catch (Exception e) {
            throw new TransactionException(e.getLocalizedMessage(), e);
        } finally {
            super.rollback();
        }
    }

    @Override
    public void commit() {

        try {
            if (transactionManager.canCommit()) {

                LOGGER.debug("Committing native transaction: {}", nativeTransaction);
                nativeTransaction.commit();
                nativeTransaction.close();
            }
        } catch (Exception e) {
            throw new TransactionException(e.getLocalizedMessage(), e);
        } finally {
            super.commit();
        }
    }

    public org.neo4j.graphdb.Transaction getNativeTransaction() {
        return nativeTransaction;
    }
}
