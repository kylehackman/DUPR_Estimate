package hackman.kyle.logic

object StartViewModel {
    fun clickWhatIsDUPR() {
        NavigationViewModel.navigateTo(NavigationViewModel.Screen.Information)
    }

    fun clickHowToCalculate() {
        NavigationViewModel.navigateTo(NavigationViewModel.Screen.Calculation)
    }

    fun clickTakeQuiz() {
        NavigationViewModel.navigateTo(NavigationViewModel.Screen.Quiz)
    }



}
