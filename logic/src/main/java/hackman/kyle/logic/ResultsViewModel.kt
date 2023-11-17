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
        if (scoreClassification >= 2.0 && scoreClassification < 3.0) {
            classification = "Novice"
        } else if (scoreClassification >= 3.0 && scoreClassification < 4.0) {
            classification = "Intermediate"
        } else if (scoreClassification >= 4.0 && scoreClassification < 5.0) {
            classification = "Advanced"
        } else if (scoreClassification >= 5.0) {
            classification = "Pro"
        } else {
            classification = "Beginner"
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
