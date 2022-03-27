package app.sosocom.data.repository.remote.datasource

import app.sosocom.data.remote.model.DataLoveResponse
import app.sosocom.domain.utils.RemoteErrorEmitter

interface MainDataSource {
    suspend fun checkLoveCalculator(
        remoteErrorEmitter: RemoteErrorEmitter,
        host: String,
        key: String,
        sName: String,
        fName: String
    ): DataLoveResponse?
}