package hackman.kyle.duprestimate

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import hackman.kyle.duprestimate.databinding.FragmentInfoBinding
import hackman.kyle.logic.InformationViewModel

class InformationFragment : Fragment() {
    private var _binding: FragmentInfoBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentInfoBinding.inflate(inflater, container, false)
        return binding.root
    }


    private fun bindBackButton() {
        binding.duprInfo.setOnClickListener {
            InformationViewModel.clickBack()
        }
    }
}
