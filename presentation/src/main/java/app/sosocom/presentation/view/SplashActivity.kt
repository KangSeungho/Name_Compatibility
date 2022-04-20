package app.sosocom.presentation.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import app.sosocom.presentation.R
import app.sosocom.presentation.base.BaseActivity
import app.sosocom.presentation.databinding.ActivitySplashBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 * 처음 실행 화면
 */
class SplashActivity : BaseActivity<ActivitySplashBinding>(R.layout.activity_splash) {
    override fun init() {
        CoroutineScope(Dispatchers.Main).launch {
            delay(1000)
            startActivity(Intent(this@SplashActivity, MainActivity::class.java).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
        }
    }
}