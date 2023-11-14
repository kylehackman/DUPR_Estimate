package hackman.kyle.logic

object StartViewModel {
    fun clickWhatIsDUPR() {
        NavigationViewModel.navigateTo(NavigationViewModel.Screen.INFORMATION)
    }

    fun clickHowToCalculate() {
        NavigationViewModel.navigateTo(NavigationViewModel.Screen.CALCULATION)
    }

    fun clickTakeQuiz() {
        NavigationViewModel.navigateTo(NavigationViewModel.Screen.QUIZ)
    }



}
