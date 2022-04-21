package app.sosocom.presentation.viewmodel

import androidx.lifecycle.ViewModel
import app.sosocom.domain.usecase.CheckAppVersionUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val checkAppVersionUseCase: CheckAppVersionUseCase
) : ViewModel() {

    fun checkAppVersion() = checkAppVersionUseCase.execute()
}