package app.sosocom.presentation.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import app.sosocom.presentation.BuildConfig
import app.sosocom.presentation.R
import app.sosocom.presentation.base.BaseActivity
import app.sosocom.presentation.databinding.ActivitySplashBinding
import app.sosocom.presentation.viewmodel.SplashViewModel
import app.sosocom.presentation.widget.extension.startActivityAndFinish
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 * 처음 실행 화면
 */
@AndroidEntryPoint
class SplashActivity : BaseActivity<ActivitySplashBinding>(R.layout.activity_splash) {
    private val splashViewModel by viewModels<SplashViewModel>()

    override fun init() {
        splashViewModel.checkAppVersion()
            .addOnSuccessListener {
                when(BuildConfig.VERSION_NAME == it.value) {
                    true -> {
                        startActivityAndFinish(this, MainActivity::class.java)
                    }
                    false -> {
                        longShowToast("앱 버전이 다릅니다.")
                    }
                }
            }
            .addOnFailureListener {
                Log.e("SPLASH", "error", it)
                shortShowToast("오류가 발생했습니다. 오류코드 - ${it.message}")
            }
    }
}