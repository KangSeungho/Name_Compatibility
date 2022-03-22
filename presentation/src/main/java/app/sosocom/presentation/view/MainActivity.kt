package app.sosocom.presentation.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import app.sosocom.presentation.R

/**
 * Fragment 표시하는 Main 화면
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}