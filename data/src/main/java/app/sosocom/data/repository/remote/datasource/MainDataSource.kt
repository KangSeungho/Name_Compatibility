package app.sosocom.data.repository.remote.datasource

import app.sosocom.data.remote.model.DataLoveResponse
import app.sosocom.domain.utils.RemoteErrorEmitter
import com.google.android.gms.tasks.Task
import com.google.firebase.database.DataSnapshot

interface MainDataSource {
    // 궁합 API 호출
    suspend fun checkLoveCalculator(
        remoteErrorEmitter: RemoteErrorEmitter,
        host: String,
        key: String,
        sName: String,
        fName: String
    ): DataLoveResponse?

    // 통계 가져오기
    fun getStatistics(): Task<DataSnapshot>

    // 통계 저장하기
    fun setStatistics(plusValue: Int): Task<Void>
}