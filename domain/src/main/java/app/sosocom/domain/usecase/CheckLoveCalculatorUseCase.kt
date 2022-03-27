package app.sosocom.domain.usecase

import app.sosocom.domain.repository.MainRepository
import app.sosocom.domain.utils.RemoteErrorEmitter
import javax.inject.Inject

class CheckLoveCalculatorUseCase @Inject constructor(
    private val mainRepository: MainRepository
) {
    suspend fun execute(remoteErrorEmitter: RemoteErrorEmitter, host: String, key: String, sName: String, fName: String)
        = mainRepository.checkLoveCalculator(remoteErrorEmitter, host, key, sName, fName)
}