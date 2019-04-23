package ir.goldenmind.advancedandroid.javaversion.retrofit;

import ir.goldenmind.advancedandroid.kotlinversion.utillity.Consts;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitServiceGenerator {
    public static final String API_BASE_URL = Consts.INSTANCE.getIMDB_WEBSERVICE_BASE_URL();
    private static OkHttpClient httpClient = new OkHttpClient.Builder().build();
    private static Retrofit.Builder builder = new Retrofit.Builder().baseUrl(API_BASE_URL).addConverterFactory(GsonConverterFactory.create());
    public static <S> S createService(Class<S> serviceClass) {
        Retrofit retrofit = builder.client(httpClient).build();
        return retrofit.create(serviceClass);
    }
}