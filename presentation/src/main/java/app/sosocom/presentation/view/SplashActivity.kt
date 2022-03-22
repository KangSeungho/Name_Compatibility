package app.sosocom.presentation.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import app.sosocom.presentation.R

/**
 * 처음 실행 화면
 */
class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
    }
}