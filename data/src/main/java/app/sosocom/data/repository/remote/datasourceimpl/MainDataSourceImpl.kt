package app.sosocom.data.repository.remote.datasourceimpl

import app.sosocom.data.remote.api.LoveCalculatorApi
import app.sosocom.data.repository.remote.datasource.MainDataSource
import app.sosocom.data.utils.base.BaseDataSource
import app.sosocom.domain.utils.RemoteErrorEmitter
import javax.inject.Inject

class MainDataSourceImpl @Inject constructor(
    private val loveCalculatorApi: LoveCalculatorApi
): BaseDataSource(), MainDataSource {

    override suspend fun checkLoveCalculator(
        remoteErrorEmitter: RemoteErrorEmitter,
        host: String,
        key: String,
        sName: String,
        fName: String
    ) = safeApiCall(remoteErrorEmitter) {
        loveCalculatorApi.getPercentage(host = host, key = key, sName = sName, fName = fName)
    }?.body()

}