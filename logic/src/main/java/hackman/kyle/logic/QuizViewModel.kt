package hackman.kyle.logic

object QuizViewModel {

    private var question = Database.questions[0]
        set(value) {
            field = value
            questionState.update(value)
        }

    val questionState = Observable(Database.questions[0])

    private var score = 2.0
        set(value) {
            field = value
            scoreState.update(value)
        }

    val scoreState = Observable(score)

    private var questionIndex = 0

    fun clickYesButton() {
        nextQuestion()
        score += .5
    }

    fun clickNoButton() {
        NavigationViewModel.navigateTo(NavigationViewModel.Screen.RESULTS)
        ResultsViewModel.setDuprRating(score)
        resetQuestionIndex()
    }

    fun resetScore() {
        score = 2.0
    }

    fun resetQuestionIndex() {
        questionIndex = 0
        question = Database.questions[questionIndex]
    }

    fun nextQuestion() {
        if (questionIndex >= Database.questions.size - 1) {
            NavigationViewModel.navigateTo(NavigationViewModel.Screen.RESULTS)
            ResultsViewModel.setDuprRating(score)
            resetQuestionIndex()
        } else {
            questionIndex++
            ResultsViewModel.setDuprRating(score)

        }
        question = Database.questions[questionIndex]
    }
}
