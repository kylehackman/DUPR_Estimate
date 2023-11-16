package hackman.kyle.duprestimate

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import hackman.kyle.duprestimate.databinding.FragmentStartBinding
import hackman.kyle.logic.StartViewModel

class StartFragment : Fragment() {
    private var _binding: FragmentStartBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentStartBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        bindWhatIsDUPR()
        bindCalculateDUPR()
        bindQuiz()
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

    private fun bindWhatIsDUPR() {
        binding.whatIsDUPR.setOnClickListener {
            StartViewModel.clickWhatIsDUPR()
        }
    }

    private fun bindCalculateDUPR() {
        binding.howItsCalculated.setOnClickListener {
            StartViewModel.clickHowToCalculate()
        }
    }

    private fun bindQuiz() {
        binding.estimateDUPR.setOnClickListener {
            StartViewModel.clickTakeQuiz()
        }
    }
}
