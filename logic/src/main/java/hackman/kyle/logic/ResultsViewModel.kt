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
            ratingState.update(value)
        }
    val ratingState = Observable(rating)

    fun clickBack() {
        onBack()
    }

    fun setDuprRating(rating: Double) {
        this.rating = rating
    }

    private fun resetRating() {
        rating = 0.0
    }

    fun systemBack() {
        onBack()
    }

    fun calculateClassification(score: Double) {
        classification = when {
            score >= 2.0 && score < 3.0 -> "Novice"

            score >= 3.0 && score < 4.0 -> "Intermediate"

            score >= 4.0 && score < 5.0 -> "Advanced"

            score >= 5.0 -> "Pro"

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
        resetRating()
    }
}
