package ir.goldenmind.advancedandroid.kotlinversion.retrofit

import io.reactivex.Observable
import ir.goldenmind.advancedandroid.javaversion.imdb.IMDBResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface IMDBRequestInterface {
    @GET("/")

    //Use Retofit without RxJava
    //fun getMovieInfo(@Query("t") movieName: String, @Query("apikey") apiKey: String) : Call<IMDBResponse>

    //Use Retofit with RxJava
    fun getMovieInfo(@Query("t") movieName: String, @Query("apikey") apiKey: String): Observable<IMDBResponse>

}