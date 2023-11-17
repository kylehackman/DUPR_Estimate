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
            Screen.INFORMATION -> navigateTo(Screen.START)
            Screen.CALCULATION -> navigateTo(Screen.START)
            Screen.QUIZ -> navigateTo(Screen.START)
            Screen.RESULTS -> ResultsViewModel.systemBack()
        }
    }
}
