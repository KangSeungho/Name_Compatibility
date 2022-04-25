package app.sosocom.presentation.view

import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import app.sosocom.presentation.R
import app.sosocom.presentation.base.BaseFragment
import app.sosocom.presentation.databinding.FragmentMainBinding
import app.sosocom.presentation.viewmodel.MainViewModel

/**
 * 메인 화면
 */
class MainFragment : BaseFragment<FragmentMainBinding>(R.layout.fragment_main) {
    private val mainViewModel by activityViewModels<MainViewModel>()

    override fun init() {
        binding.fragment = this
        mainViewModel.getStatisticsDisplay()
        observeViewModel()
    }

    fun nextBtnClick(view: View) {
        findNavController().navigate(R.id.action_mainFragment_to_womanNameFragment)
    }

    private fun observeViewModel() {
        mainViewModel.getStatisticsEvent.observe(this) {
            binding.statistics.text = it.toString()
        }
    }
}