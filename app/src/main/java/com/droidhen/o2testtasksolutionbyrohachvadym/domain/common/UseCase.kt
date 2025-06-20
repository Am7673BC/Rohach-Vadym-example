/**
 * Created by Rohach Vadym as a test task for O2 Slovakia, s.r.o., 2025 All rights reserved and belongs to Rohach Vadym.
 * Ownership may transfer to O2 Slovakia, s.r.o. upon hiring
 **/

package com.droidhen.o2testtasksolutionbyrohachvadym.domain.common

/**
 * Basic UseCase abstract class
 */

abstract class UseCase<out T, in Params> {

    /**
     * @param params Set of input parameters.
     * @return type [T] of parameter.
     */
    suspend operator fun invoke(params: Params): T = doWork(params)

    /**
     * Inner business logic of [UseCase]
     *
     * @param Set of input parameters
     * @return type [T] of parameter.
     */
    protected abstract suspend fun doWork(params: Params): T
}