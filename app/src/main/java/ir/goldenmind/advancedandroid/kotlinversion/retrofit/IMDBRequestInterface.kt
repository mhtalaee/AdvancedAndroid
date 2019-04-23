package ir.goldenmind.advancedandroid.kotlinversion.retrofit

import ir.goldenmind.advancedandroid.javaversion.imdb.IMDBResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface IMDBRequestInterface {
    @GET("/")
    fun getMovieInfo(@Query("t") movieName: String, @Query("apikey") apiKey: String) : Call<IMDBResponse>

}