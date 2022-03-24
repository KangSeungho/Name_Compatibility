package app.sosocom.presentation.base

import android.os.Bundle
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

abstract class BaseActivity<T: ViewDataBinding>(@LayoutRes private val layoutResId: Int) : AppCompatActivity() {
    private lateinit var _binding: T
    protected val binding: T get() = _binding

    private var waitTime = 0L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = DataBindingUtil.setContentView(this, layoutResId)
        init()
    }

    abstract fun init()

    override fun onBackPressed() {
        if(System.currentTimeMillis() - waitTime >= 1500) {
            waitTime = System.currentTimeMillis()
            shortShowToast("뒤로가기 버튼을 한번 더 누르면 종료됩니다.")
        } else {
            finish()
        }
    }

    protected fun shortShowToast(msg: String) = Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    protected fun longShowToast(msg: String) = Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
}