package app.sosocom.data.repository.remote.datasourceimpl

import app.sosocom.data.repository.remote.datasource.SplashDataSource
import com.google.android.gms.tasks.Task
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.firestore.FirebaseFirestore
import javax.inject.Inject

class SplashDataSourceImpl @Inject constructor(
    private val firebaseRTDB : FirebaseDatabase,
    private val fireStore: FirebaseFirestore
) : SplashDataSource {
    override fun checkAppVersion(): Task<DataSnapshot> {
        return firebaseRTDB.reference.child("version").get()
    }
}