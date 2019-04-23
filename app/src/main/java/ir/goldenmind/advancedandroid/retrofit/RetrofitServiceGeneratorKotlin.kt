package ir.goldenmind.advancedandroid.retrofit

import ir.goldenmind.advancedandroid.utillity.Consts
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitServiceGeneratorKotlin {
    val API_BASE_URL = Consts.IMDB_WEBSERVICE_BASE_URL
    val httpClient = OkHttpClient.Builder().build()
    val builder = Retrofit.Builder().baseUrl(API_BASE_URL).addConverterFactory(GsonConverterFactory.create())

    fun <S> createService(serviceClass: Class<S>): S {
        val retrofit = builder.client(httpClient).build()
        return retrofit.create(serviceClass)
    }


}