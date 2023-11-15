package hackman.kyle.logic

object InformationViewModel {

    fun clickBack() {
        NavigationViewModel.navigateTo(NavigationViewModel.Screen.START)
    }
}
