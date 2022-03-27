package app.sosocom.domain.repository

import app.sosocom.domain.model.DomainLoveResponse
import app.sosocom.domain.utils.RemoteErrorEmitter

interface MainRepository {
    suspend fun checkLoveCalculator(
        remoteErrorEmitter: RemoteErrorEmitter,
        host: String,
        key: String,
        sName: String,
        fName: String
    ): DomainLoveResponse?
}