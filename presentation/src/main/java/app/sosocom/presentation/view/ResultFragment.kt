package app.sosocom.presentation.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import app.sosocom.presentation.R
import app.sosocom.presentation.base.BaseFragment
import app.sosocom.presentation.databinding.FragmentMainBinding
import app.sosocom.presentation.databinding.FragmentResultBinding

/**
 * 결과 표시
 */
class ResultFragment : BaseFragment<FragmentResultBinding>(R.layout.fragment_result) {
    override fun init() {
        binding.fragment = this
    }

    fun nextBtnClick(view: View) {
        findNavController().navigate(R.id.action_resultFragment_to_mainFragment)
    }
}