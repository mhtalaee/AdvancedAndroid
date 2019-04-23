package ir.goldenmind.advancedandroid.javaversion.activities;

import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.squareup.picasso.Picasso;
import ir.goldenmind.advancedandroid.R;
import ir.goldenmind.advancedandroid.javaversion.imdb.IMDBResponse;
import ir.goldenmind.advancedandroid.javaversion.retrofit.IMDBRequestInterface;
import ir.goldenmind.advancedandroid.javaversion.retrofit.RetrofitServiceGenerator;
import ir.goldenmind.advancedandroid.kotlinversion.utillity.Consts;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RetrofitActivity extends AppCompatActivity {

    Button btnGetMovieInfo;
    EditText etMovieName;
    TextView tvTitle;
    TextView tvYear;
    TextView tvGenre;
    TextView tvDirector;
    TextView tvRate;
    TextView tvWriter;
    TextView tvActors;
    TextView tvCountry;
    TextView tvAwards;
    Button btnBack;
    ImageView imgMoviePoster;
    ProgressBar pb;
    IMDBRequestInterface imdbRequestInterface = RetrofitServiceGenerator.createService(IMDBRequestInterface.class);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);

        btnGetMovieInfo = findViewById(R.id.btnGetMovieInfo);
        etMovieName = findViewById(R.id.etMovieName);
        tvTitle = findViewById(R.id.tvTitle);
        tvYear = findViewById(R.id.tvYear);
        tvGenre = findViewById(R.id.tvGenre);
        tvDirector = findViewById(R.id.tvDirector);
        tvRate = findViewById(R.id.tvRate);
        tvWriter = findViewById(R.id.tvWriter);
        tvActors = findViewById(R.id.tvActors);
        tvCountry = findViewById(R.id.tvCountry);
        tvAwards = findViewById(R.id.tvAwards);
        btnBack = findViewById(R.id.btnBack);
        pb = findViewById(R.id.pbLoading);
        imgMoviePoster = findViewById(R.id.imgMoviePoster);

        btnGetMovieInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                imdbRequestInterface.getMovieInfo(etMovieName.getText().toString(), Consts.INSTANCE.getAPI_KEY()).enqueue(new Callback<IMDBResponse>() {
                    @Override
                    public void onResponse(Call<IMDBResponse> call, Response<IMDBResponse> response) {

                        tvTitle.setText(response.body().getTitle());
                        tvYear.setText(response.body().getYear());
                        tvGenre.setText(response.body().getGenre());
                        tvDirector.setText(response.body().getDirector());
                        tvRate.setText(response.body().getImdbRating());
                        tvWriter.setText(response.body().getWriter());
                        tvActors.setText(response.body().getActors());
                        tvCountry.setText(response.body().getCountry());
                        tvAwards.setText(response.body().getAwards());
                        Picasso.get().load(response.body().getPoster()).into(imgMoviePoster);
                    }

                    @Override
                    public void onFailure(Call<IMDBResponse> call, Throwable t) {
                        Toast.makeText(RetrofitActivity.this, "Error fetching movie info", Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });


    }
}
