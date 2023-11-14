package hackman.kyle.logic

object ResultsViewModel {

    fun clickBack() {
        onBack()
    }

    fun systemBack() {
        onBack()
    }

    private fun onBack() {
        NavigationViewModel.navigateTo(NavigationViewModel.Screen.START)
    }
}
