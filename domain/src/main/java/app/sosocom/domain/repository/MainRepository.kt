package app.sosocom.domain.repository

import app.sosocom.domain.model.DomainLoveResponse
import app.sosocom.domain.utils.RemoteErrorEmitter
import com.google.android.gms.tasks.Task
import com.google.firebase.database.DataSnapshot

interface MainRepository {
    suspend fun checkLoveCalculator(
        remoteErrorEmitter: RemoteErrorEmitter,
        host: String,
        key: String,
        sName: String,
        fName: String
    ): DomainLoveResponse?

    // 통계 가져오기
    fun getStatistics(): Task<DataSnapshot>

    // 통계 저장하기
    fun setStatistics(plusValue: Int): Task<Void>
}