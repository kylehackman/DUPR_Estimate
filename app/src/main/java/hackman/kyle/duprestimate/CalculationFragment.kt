package hackman.kyle.duprestimate

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import hackman.kyle.duprestimate.databinding.FragmentCalculationBinding
import hackman.kyle.logic.CalculationViewModel

class CalculationFragment : Fragment() {
    private var _binding: FragmentCalculationBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCalculationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        bindBackButton()
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

    private fun bindBackButton() {
        binding.duprCalculation.setOnClickListener {
            CalculationViewModel.clickBack()
        }
    }
}
