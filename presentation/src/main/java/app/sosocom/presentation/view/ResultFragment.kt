package app.sosocom.presentation.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import app.sosocom.presentation.R
import app.sosocom.presentation.base.BaseFragment
import app.sosocom.presentation.databinding.FragmentMainBinding
import app.sosocom.presentation.databinding.FragmentResultBinding
import app.sosocom.presentation.viewmodel.MainViewModel

/**
 * 결과 표시
 */
class ResultFragment : BaseFragment<FragmentResultBinding>(R.layout.fragment_result) {
    private val mainViewModel by activityViewModels<MainViewModel>()

    override fun init() {
        binding.fragment = this
    }

    private fun initResult() {
        binding.score.text = mainViewModel.apiCallResult.percentage.toString()
        when(mainViewModel.apiCallResult.percentage) {
            in 0..20 -> binding.message.text = "조금 힘들어 보여요"
            in 21..40 -> binding.message.text = "노력해 보세요"
            in 41..70 -> binding.message.text = "기대해도 좋겠는데요?"
            in 71..90 -> binding.message.text = "일단 축하드려요"
            in 91..99 -> binding.message.text = "와우.. 눈을 의심하고 있어요"
            100 -> binding.message.text = "완벽하네요! 축하드려요~"
            else -> binding.message.text = "알수없는 힘?"
        }
    }

    fun nextBtnClick(view: View) {
        mainViewModel.checkLoveCalculator(
            "love-calculator.p.rapidapi.com",
            "9862109fc9msha20552451b776e0p13f7efjsnd8f97f572226",
            mainViewModel.manNameResult,
            mainViewModel.womanNameResult
        )
        findNavController().navigate(R.id.action_resultFragment_to_mainFragment)
    }
}