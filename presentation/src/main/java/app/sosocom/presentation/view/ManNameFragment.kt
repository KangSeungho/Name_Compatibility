package app.sosocom.presentation.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import app.sosocom.domain.utils.ErrorType
import app.sosocom.domain.utils.ScreenState
import app.sosocom.presentation.R
import app.sosocom.presentation.base.BaseFragment
import app.sosocom.presentation.databinding.FragmentMainBinding
import app.sosocom.presentation.databinding.FragmentManNameBinding
import app.sosocom.presentation.viewmodel.MainViewModel

/**
 * 남자 이름 입력
 */
class ManNameFragment : BaseFragment<FragmentManNameBinding>(R.layout.fragment_man_name) {
    private val mainViewModel by activityViewModels<MainViewModel>()

    override fun init() {
        binding.fragment = this
        observeViewModel()
    }

    fun nextBtnClick(view: View) {
        binding.progressBar.visibility = View.VISIBLE
        mainViewModel.checkLoveCalculator(
            "love-calculator.p.rapidapi.com",
            "9862109fc9msha20552451b776e0p13f7efjsnd8f97f572226",
            binding.nameEditTxt.text.toString(),
            mainViewModel.womanNameResult
        )
    }

    private fun observeViewModel() {
        mainViewModel.apiCallEvent.observe(this) {
            binding.progressBar.visibility = View.INVISIBLE
            when(it) {
                ScreenState.LOADING -> findNavController().navigate(R.id.action_manNameFragment_to_resultFragment)
                ScreenState.ERROR -> toastErrorMsg(mainViewModel.apiErrorType)
                else -> shortShowToast("알 수 없는 오류가 발생했습니다.")
            }
        }
    }
}