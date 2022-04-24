package app.sosocom.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.sosocom.domain.model.DomainLoveResponse
import app.sosocom.domain.usecase.CheckLoveCalculatorUseCase
import app.sosocom.domain.usecase.GetStatisticsUseCase
import app.sosocom.domain.usecase.SetStatisticsUseCase
import app.sosocom.domain.utils.ErrorType
import app.sosocom.domain.utils.RemoteErrorEmitter
import app.sosocom.domain.utils.ScreenState
import app.sosocom.presentation.widget.utils.SingleLiveEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val checkLoveCalculatorUseCase: CheckLoveCalculatorUseCase,
    private val setStatisticsUseCase: SetStatisticsUseCase,
    private val getStatisticsUseCase: GetStatisticsUseCase
): ViewModel(), RemoteErrorEmitter {

    private val _apiCallEvent = SingleLiveEvent<ScreenState>()
    val apiCallEvent: LiveData<ScreenState> = _apiCallEvent

    var apiCallResult = DomainLoveResponse("", "", 0, "")
    var apiErrorType = ErrorType.UNKNOWN
    var apiErrorMessage = "none"
    var manNameResult = "man"
    var womanNameResult = "woman"

    fun checkLoveCalculator(host: String, key: String, sName: String, fName: String) = viewModelScope.launch {
        checkLoveCalculatorUseCase.execute(this@MainViewModel, host, key, sName, fName).let { response ->
            when(response) {
                null -> _apiCallEvent.postValue(ScreenState.ERROR)
                else -> {
                    apiCallResult = response
                    _apiCallEvent.postValue(ScreenState.LOADING)
                }
            }
        }
    }

    fun setStatistics(plusValue: Int) = setStatisticsUseCase.execute(plusValue)

    fun getStatistics() = getStatisticsUseCase.execute()

    override fun onError(msg: String) {
        apiErrorMessage = msg
    }

    override fun onError(errorType: ErrorType) {
        apiErrorType = errorType
    }
}