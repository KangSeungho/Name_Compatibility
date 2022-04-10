package app.sosocom.presentation.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import app.sosocom.domain.utils.ErrorType

abstract class BaseFragment<T: ViewDataBinding>(@LayoutRes val layoutResId: Int) : Fragment() {
    private lateinit var _binding: T
    protected val binding: T get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = DataBindingUtil.inflate(inflater, layoutResId, container, false)
        init()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = this
    }

    abstract fun init()

    protected fun shortShowToast(msg: String) = Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
    protected fun longShowToast(msg: String) = Toast.makeText(context, msg, Toast.LENGTH_LONG).show()
    protected fun toastErrorMsg(errorType: ErrorType) {
        when(errorType) {
            ErrorType.NETWORK -> longShowToast("네트워크 오류가 발생했습니다.")
            ErrorType.SESSION_EXPIRED -> longShowToast("세션이 만료되었습니다.")
            ErrorType.TIMEOUT -> longShowToast("호출 시간이 초과되었습니다.")
            ErrorType.UNKNOWN -> longShowToast("예기치 못한 오류가 발생했습니다.")
        }
    }
}