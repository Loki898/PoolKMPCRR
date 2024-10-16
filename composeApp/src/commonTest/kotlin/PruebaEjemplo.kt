import androidx.compose.ui.semantics.SemanticsProperties
import androidx.compose.ui.semantics.getOrNull
import androidx.compose.ui.test.*
import ies.antonio.sequeros.App
import kotlin.test.Test
import kotlin.test.assertTrue

class PruebaEjemplo {
    @OptIn(ExperimentalTestApi::class)
    @Test
    fun pruebaExisteFieldMetrosCubicos() = runComposeUiTest {
        setContent {
            App()
        }
        onNodeWithTag("metroscubicos").assertIsDisplayed()
    }

    @OptIn(ExperimentalTestApi::class)
    @Test
    fun pruebaExisteFieldLecturaPh() = runComposeUiTest {
        setContent {
            App()
        }
        onNodeWithTag("lecturaph").assertIsDisplayed()
    }

    @OptIn(ExperimentalTestApi::class)
    @Test
    fun pruebaExisteFieldGramos() = runComposeUiTest {
        setContent {
            App()
        }
        onNodeWithTag("gramos").assertIsDisplayed()
    }

    @OptIn(ExperimentalTestApi::class)
    @Test
    fun pruebaExisteFieldResultado() = runComposeUiTest {
        setContent {
            App()
        }
        onNodeWithTag("resultado").assertIsDisplayed()
    }
    @OptIn(ExperimentalTestApi::class)
    @Test
    fun pruebaCamposPositivos() = runComposeUiTest {
        setContent {
            App()
        }
        onNodeWithTag("metroscubicos").performTextInput("10")
        onNodeWithTag("lecturaph").performTextInput("7.0")
        onNodeWithTag("gramos").performTextInput("1.5")
        val expectedValue = ((7.4 - 7.0) * 10 * 10 * 1.5).toString()
        onNodeWithTag("resultado").assertTextEquals(expectedValue)
    }

    @OptIn(ExperimentalTestApi::class)
    @Test
    fun pruebaPhMayor7Con4() = runComposeUiTest {
        setContent {
            App()
        }
        onNodeWithTag("metroscubicos").performTextInput("10")
        onNodeWithTag("lecturaph").performTextInput("7.41")
        onNodeWithTag("gramos").performTextInput("1.5")

        onNodeWithTag("resultado").assertTextContains("-", substring = true)
    }
}
