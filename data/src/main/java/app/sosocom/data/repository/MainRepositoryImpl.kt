package app.sosocom.data.repository

import app.sosocom.data.mapper.MainMapper
import app.sosocom.data.repository.remote.datasource.MainDataSource
import app.sosocom.domain.repository.MainRepository
import app.sosocom.domain.utils.RemoteErrorEmitter
import javax.inject.Inject

class MainRepositoryImpl @Inject constructor(
    private val mainDataSource: MainDataSource
): MainRepository {
    override suspend fun checkLoveCalculator(
        remoteErrorEmitter: RemoteErrorEmitter,
        host: String,
        key: String,
        sName: String,
        fName: String
    ) = MainMapper.loveMapper(mainDataSource.checkLoveCalculator(remoteErrorEmitter, host, key, sName, fName))
}