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
import app.sosocom.presentation.databinding.FragmentWomanNameBinding
import app.sosocom.presentation.viewmodel.MainViewModel

/**
 * 여자 이름 입력
 */
class WomanNameFragment : BaseFragment<FragmentWomanNameBinding>(R.layout.fragment_woman_name) {
    private val mainViewModel by activityViewModels<MainViewModel>()

    override fun init() {
        binding.fragment = this
    }

    fun nextBtnClick(view: View) {
        mainViewModel.womanNameResult = binding.nameEditTxt.text.toString()
        findNavController().navigate(R.id.action_womanNameFragment_to_manNameFragment)
    }
}