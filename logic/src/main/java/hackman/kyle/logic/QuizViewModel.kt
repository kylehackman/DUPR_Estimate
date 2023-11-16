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
    }

    fun scoreValue() {
        score
    }

    fun resetScore() {
        score = 2.0
    }

    fun nextQuestion() {
        questionIndex++
    }
}
