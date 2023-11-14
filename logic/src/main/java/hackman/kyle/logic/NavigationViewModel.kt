package hackman.kyle.logic

object NavigationViewModel {

    enum class Screen {
        START, Information, Calculation, Quiz, Results
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
            Screen.Information -> navigateTo(Screen.START)
            Screen.Calculation -> navigateTo(Screen.START)
            Screen.Results -> ResultsViewModel.systemBack()
            else -> {}
        }
    }

}
