package app.sosocom.domain.usecase

import app.sosocom.domain.repository.MainRepository
import javax.inject.Inject

class SetStatisticsUseCase @Inject constructor(
    private val mainRepository: MainRepository
) {
    fun execute(plusValue: Int) = mainRepository.setStatistics(plusValue)
}