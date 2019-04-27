package ir.goldenmind.advancedandroid

import ir.goldenmind.advancedandroid.kotlinversion.activities.RetrofitActivity
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    val retrofitActivity = RetrofitActivity()

    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun checkMovieName() {

        assertTrue(retrofitActivity.checkForInvalidCharacters("moviename"))
        assertFalse(retrofitActivity.checkForInvalidCharacters("movie@name"))

    }

    @Test
    fun checkMovieNameLength() {

        assertTrue(retrofitActivity.checkForMinLength("future"))
        assertFalse(retrofitActivity.checkForMinLength("xe"))

    }


}
