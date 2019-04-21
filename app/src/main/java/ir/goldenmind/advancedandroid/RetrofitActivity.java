package ir.goldenmind.advancedandroid;

import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import ir.goldenmind.advancedandroid.imdb.IMDBResponse;
import ir.goldenmind.advancedandroid.retrofit.IMDBRequestInterface;
import ir.goldenmind.advancedandroid.retrofit.RetrofitServiceGenerator;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RetrofitActivity extends AppCompatActivity {

    TextView tvYear;
    IMDBRequestInterface imdbRequestInterface = RetrofitServiceGenerator.createService(IMDBRequestInterface.class);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);
        tvYear = findViewById(R.id.tvYear);

        imdbRequestInterface.getMovieInfo("interstellar", "70ad462a").enqueue(new Callback<IMDBResponse>() {
            @Override
            public void onResponse(Call<IMDBResponse> call, Response<IMDBResponse> response) {

              tvYear.setText(response.body().getYear());
            }

            @Override
            public void onFailure(Call<IMDBResponse> call, Throwable t)
            {
                int j = 0;
            }
        });
    }
}
