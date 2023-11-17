package hackman.kyle.duprestimate

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import hackman.kyle.duprestimate.databinding.FragmentResultsBinding
import hackman.kyle.logic.ResultsViewModel

class ResultsFragment : Fragment() {

    private var _binding: FragmentResultsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentResultsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        bindBackButton()
        observeRating()
        observeClassification()
    }

    private fun observeRating() {
        ResultsViewModel.ratingScoreState.addObserver {
            binding.ratingResult.text = it.toString()
        }
    }

    private fun observeClassification() {
        ResultsViewModel.classificationState.addObserver {
            binding.ratingClassification.text = it
        }
    }
    override fun onDestroyView() {
        _binding = null
        ResultsViewModel.ratingScoreState.removeAllObservers()
        super.onDestroyView()
    }

    private fun bindBackButton() {
        binding.back.setOnClickListener {
            ResultsViewModel.clickBack()
        }
    }
}
