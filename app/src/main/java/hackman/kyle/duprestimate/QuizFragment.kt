package hackman.kyle.duprestimate

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import hackman.kyle.duprestimate.databinding.FragmentTakeQuizBinding
import hackman.kyle.logic.QuizViewModel

class QuizFragment : Fragment() {
    private var _binding: FragmentTakeQuizBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTakeQuizBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        bindQuizNoButton()
        bindQuizYesButton()
    }

    private fun observeQuestion() {
        QuizViewModel.questionState.observe(this) {
            binding.question.text = it.name
        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

    private fun bindQuizNoButton() {
        binding.quizNoButton.setOnClickListener {
            QuizViewModel.clickNoButton()
        }
    }

    private fun bindQuizYesButton() {
        binding.quizYesButton.setOnClickListener {
            QuizViewModel.clickYesButton()
        }
    }
}
