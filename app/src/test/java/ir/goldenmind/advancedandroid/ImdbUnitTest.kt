package ir.goldenmind.advancedandroid

import ir.goldenmind.advancedandroid.kotlinversion.activities.RetrofitActivity
import org.junit.Assert
import org.junit.Test

class ImdbUnitTest{

    val retrofitActivity = RetrofitActivity()

    @Test
    fun checkMovieName() {

        Assert.assertTrue(retrofitActivity.checkForInvalidCharacters("moviename"))
        Assert.assertFalse(retrofitActivity.checkForInvalidCharacters("movie@name"))

    }

    @Test
    fun checkMovieNameLength() {

        Assert.assertTrue(retrofitActivity.checkForMinLength("future"))
        Assert.assertFalse(retrofitActivity.checkForMinLength("xe"))

    }

}