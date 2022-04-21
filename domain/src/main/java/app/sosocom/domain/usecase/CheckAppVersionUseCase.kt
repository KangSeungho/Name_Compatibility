package app.sosocom.domain.usecase

import app.sosocom.domain.repository.SplashRepository
import javax.inject.Inject

class CheckAppVersionUseCase @Inject constructor(
    private val splashRepository: SplashRepository
) {
    fun execute() = splashRepository.checkAppVersion()
}