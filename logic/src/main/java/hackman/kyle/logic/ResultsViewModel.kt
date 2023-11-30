package hackman.kyle.logic

object ResultsViewModel {

    private var classification = "Beginner"
        set(value) {
            field = value
            classificationState.update(value)
        }
    val classificationState = Observable(classification)

    private var rating = 0.0
        set(value) {
            field = value
            ratingScoreState.update(value)
        }
    val ratingScoreState = Observable(rating)

    fun clickBack() {
        onBack()
    }

    fun setDuprRating(score: Double) {
        rating = score
    }

    fun systemBack() {
        onBack()
    }

    fun calculateClassification(scoreClassification: Double) {
        classification = when {
            scoreClassification >= 2.0 && scoreClassification < 3.0 -> "Novice"

            scoreClassification >= 3.0 && scoreClassification < 4.0 -> "Intermediate"

            scoreClassification >= 4.0 && scoreClassification < 5.0 -> "Advanced"

            scoreClassification >= 5.0 -> "Pro"

            else -> "Beginner"
        }
    }

    private fun resetClassification() {
        classification = "Beginner"
    }

    private fun onBack() {
        NavigationViewModel.navigateTo(NavigationViewModel.Screen.START)
        QuizViewModel.resetScore()
        QuizViewModel.resetQuestionIndex()
        resetClassification()
    }
}
