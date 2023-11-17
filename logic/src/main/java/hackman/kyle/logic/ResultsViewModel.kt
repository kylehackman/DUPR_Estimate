package hackman.kyle.logic

object ResultsViewModel {

    private var classification = ""
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

    // TODO rating dosnt seem to be working, and bug when play the 2nd time
    fun calculateRating() {
        if (rating >= 2 && rating < 3) {
            classification = "Novice"
        }
        if (rating >= 3 && rating < 4) {
            classification = "Intermediate"
        }

        if (rating >= 4 && rating < 5) {
            classification = "Advanced"
        }

        if (rating >= 5) {
            classification = "Pro"
        } else {
            classification = "Beginner"
        }
    }

    private fun onBack() {
        NavigationViewModel.navigateTo(NavigationViewModel.Screen.START)
        QuizViewModel.resetScore()
        QuizViewModel.resetQuestionIndex()
    }
}
