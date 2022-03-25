package app.sosocom.presentation.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import app.sosocom.presentation.R
import app.sosocom.presentation.base.BaseActivity
import app.sosocom.presentation.databinding.ActivityMainBinding
import app.sosocom.presentation.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

/**
 * Fragment 표시하는 Main 화면
 */
@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {
    private val mainViewModel by viewModels<MainViewModel>()

    override fun init() {

    }
}