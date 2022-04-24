package app.sosocom.data.repository.remote.datasourceimpl

import app.sosocom.data.remote.api.LoveCalculatorApi
import app.sosocom.data.repository.remote.datasource.MainDataSource
import app.sosocom.data.utils.base.BaseDataSource
import app.sosocom.domain.utils.RemoteErrorEmitter
import com.google.android.gms.tasks.Task
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.firestore.FirebaseFirestore
import javax.inject.Inject

class MainDataSourceImpl @Inject constructor(
    private val loveCalculatorApi: LoveCalculatorApi,
    private val firebaseRTDB: FirebaseDatabase,
    private val fireStore: FirebaseFirestore
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

    override fun getStatistics(): Task<DataSnapshot> {
        return firebaseRTDB.reference.child("statistics").get()
    }

    override fun setStatistics(plusValue: Int): Task<Void> {
        return firebaseRTDB.reference.child("statistics").setValue(plusValue)
    }
}