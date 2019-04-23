package ir.goldenmind.advancedandroid.retrofit

import ir.goldenmind.advancedandroid.imdb.IMDBResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface IMDBRequestInterfaceKotlin {
    @GET("/")
    fun getMovieInfo(@Query("t") movieName: String, @Query("apikey") apiKey: String) : Call<IMDBResponse>

}