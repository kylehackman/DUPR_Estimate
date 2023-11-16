package hackman.kyle.logic

object ResultsViewModel {

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

    /* fun calculateRating() {
         if (QuizViewModel.scoreValue() <= 1) {
             rating = "2.0 - 2.5"
         }
         if (QuizViewModel.scoreValue() <= 2) {
             rating = "2.5 - 3.0"
         }

         if (QuizViewModel.scoreValue() <= 3) {
             rating = "3.0 - 3.5"
         }

         if (QuizViewModel.scoreValue() <= 4) {
             rating = "4.0- 4.5"
         }

         if (QuizViewModel.scoreValue() <= 5) {
             rating = "5.0- 5.5"
         } else {
             rating = "invalid rating"
         }
     }
 */
    private fun onBack() {
        NavigationViewModel.navigateTo(NavigationViewModel.Screen.START)
        QuizViewModel.resetScore()
        QuizViewModel.resetQuestionIndex()

    }
}
