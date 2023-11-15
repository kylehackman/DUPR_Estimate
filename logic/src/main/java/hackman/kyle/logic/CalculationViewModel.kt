package hackman.kyle.logic

object CalculationViewModel {

    fun clickBack(){
        NavigationViewModel.navigateTo(NavigationViewModel.Screen.START)
    }
}
