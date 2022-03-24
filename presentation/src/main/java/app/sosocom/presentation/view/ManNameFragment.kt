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
import app.sosocom.presentation.databinding.FragmentManNameBinding

/**
 * 남자 이름 입력
 */
class ManNameFragment : BaseFragment<FragmentManNameBinding>(R.layout.fragment_man_name) {
    override fun init() {
        binding.fragment = this
    }

    fun nextBtnClick(view: View) {
        findNavController().navigate(R.id.action_manNameFragment_to_resultFragment)
    }
}