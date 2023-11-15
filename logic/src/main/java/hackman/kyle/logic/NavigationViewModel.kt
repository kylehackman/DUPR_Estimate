package hackman.kyle.logic

object NavigationViewModel {

    enum class Screen {
        START, INFORMATION, CALCULATION, QUIZ, RESULTS
    }

    private var currentScreen = Screen.START
        set(value) {
            field = value
            screenState.update(value)

        }
    val screenState = Observable(currentScreen)

    fun navigateTo(nextScreen: Screen) {
        currentScreen = nextScreen
    }

    fun shouldOverrideBackPressed() = currentScreen != Screen.START

    fun onBackPressed() {
        when (currentScreen) {
            Screen.START -> Unit
            Screen.INFORMATION -> navigateTo(Screen.INFORMATION)
            Screen.CALCULATION -> navigateTo(Screen.CALCULATION)
            Screen.QUIZ -> navigateTo(Screen.QUIZ)
            Screen.RESULTS -> ResultsViewModel.systemBack()
        }
    }

}
