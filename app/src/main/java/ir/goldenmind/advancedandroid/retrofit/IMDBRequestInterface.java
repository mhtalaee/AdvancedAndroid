package ir.goldenmind.advancedandroid.retrofit;

import ir.goldenmind.advancedandroid.imdb.IMDBResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface IMDBRequestInterface {
    @GET("/")
    Call<IMDBResponse> getMovieInfo(@Query("t") String movieName, @Query("apikey") String apiKey);
}
