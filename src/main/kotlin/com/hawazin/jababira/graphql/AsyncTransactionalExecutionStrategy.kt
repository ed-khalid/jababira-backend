package com.hawazin.jababira.graphql

import graphql.ExecutionResult
import graphql.execution.*
import org.springframework.stereotype.Service
import java.util.concurrent.CompletableFuture
import javax.transaction.Transactional

@Service
class AsyncTransactionalExecutionStrategy : AsyncExecutionStrategy() {

    @Transactional
    @Throws(NonNullableFieldWasNullException::class)
    override fun execute(
        executionContext: ExecutionContext?,
        parameters: ExecutionStrategyParameters?
    ): CompletableFuture<ExecutionResult> {
        return super.execute(executionContext, parameters)
    }



}