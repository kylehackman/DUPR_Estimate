package hackman.kyle.logic

object QuizViewModel {

    private const val INITIAL_SCORE = 1.5

    private var question = Database.questions[0]
        set(value) {
            field = value
            questionState.update(value)
        }

    val questionState = Observable(Database.questions[0])

    private var score = INITIAL_SCORE

    private var questionIndex = 0

    fun clickYesButton() {
        nextQuestion()
        score += .5
    }

    fun clickNoButton() {
        NavigationViewModel.navigateTo(NavigationViewModel.Screen.RESULTS)
        resetQuestionIndex()
        if (score == INITIAL_SCORE) {
            ResultsViewModel.setDuprRating(0.0)
        } else {
            setRatingAndClassification()
        }
    }

    fun resetScore() {
        score = INITIAL_SCORE
    }

    fun resetQuestionIndex() {
        questionIndex = 0
        question = Database.questions[questionIndex]
    }

    private fun nextQuestion() {
        if (questionIndex >= Database.questions.size - 1) {
            NavigationViewModel.navigateTo(NavigationViewModel.Screen.RESULTS)
            setRatingAndClassification()
            resetQuestionIndex()
        } else {
            questionIndex++
            setRatingAndClassification()
        }
        question = Database.questions[questionIndex]
    }

    private fun setRatingAndClassification() {
        ResultsViewModel.setDuprRating(score)
        ResultsViewModel.calculateClassification(score)
    }
}
