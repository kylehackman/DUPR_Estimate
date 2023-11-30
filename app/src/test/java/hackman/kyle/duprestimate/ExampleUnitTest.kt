package hackman.kyle.duprestimate

import hackman.kyle.logic.CalculationViewModel
import hackman.kyle.logic.InformationViewModel
import hackman.kyle.logic.NavigationViewModel
import hackman.kyle.logic.QuizViewModel
import hackman.kyle.logic.ResultsViewModel
import hackman.kyle.logic.StartViewModel
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.Before

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Before
    fun resetTest() {
        NavigationViewModel.navigateTo(NavigationViewModel.Screen.START)
    }

    @Test
    fun `tests if app opens to start screen`() {
        assertEquals(NavigationViewModel.Screen.START, NavigationViewModel.screenState.value)
    }

    @Test
    fun `tests the start screen buttons`() {
        StartViewModel.clickWhatIsDUPR()
        assertEquals(NavigationViewModel.Screen.INFORMATION, NavigationViewModel.screenState.value)
        InformationViewModel.clickBack()
        assertEquals(NavigationViewModel.Screen.START, NavigationViewModel.screenState.value)
        StartViewModel.clickHowToCalculate()
        assertEquals(NavigationViewModel.Screen.CALCULATION, NavigationViewModel.screenState.value)
        CalculationViewModel.clickBack()
        assertEquals(NavigationViewModel.Screen.START, NavigationViewModel.screenState.value)
        StartViewModel.clickTakeQuiz()
        assertEquals(NavigationViewModel.Screen.QUIZ, NavigationViewModel.screenState.value)
    }

    @Test
    fun `rating and calculation resets to initial values`() {
        assertEquals(0.0, ResultsViewModel.ratingState.value, 0.0)
        StartViewModel.clickTakeQuiz()
        QuizViewModel.clickYesButton()
        QuizViewModel.clickNoButton()
        ResultsViewModel.clickBack()
        assertEquals(0.0, ResultsViewModel.ratingState.value, 0.0)
        StartViewModel.clickTakeQuiz()
        assertEquals(0.0, ResultsViewModel.ratingState.value, 0.0)
        QuizViewModel.clickNoButton()
        assertEquals(0.0, ResultsViewModel.ratingState.value, 0.0)
        assertEquals("Beginner", ResultsViewModel.classificationState.value)
    }
}
