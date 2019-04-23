package ir.goldenmind.advancedandroid.kotlinversion.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.squareup.picasso.Picasso
import ir.goldenmind.advancedandroid.R
import ir.goldenmind.advancedandroid.javaversion.imdb.IMDBResponse
import ir.goldenmind.advancedandroid.kotlinversion.retrofit.IMDBRequestInterface
import ir.goldenmind.advancedandroid.kotlinversion.retrofit.RetrofitServiceGenerator
import ir.goldenmind.advancedandroid.kotlinversion.utillity.Consts
import kotlinx.android.synthetic.main.activity_retrofit.*
import retrofit2.Call
import retrofit2.Response

class RetrofitActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_retrofit)
        btnGetMovieInfo.setOnClickListener {

            var imdbRequestInterface =
                RetrofitServiceGenerator.createService(IMDBRequestInterface::class.java)
            imdbRequestInterface.getMovieInfo(etMovieName.text.toString(), Consts.API_KEY)
                .enqueue(object : retrofit2.Callback<IMDBResponse> {

                    override fun onResponse(call: Call<IMDBResponse>, response: Response<IMDBResponse>) {
                        tvTitle.text = response.body()?.title
                        tvYear.text = response.body()?.year
                        tvGenre.text = response.body()?.genre
                        tvDirector.text = response.body()?.director
                        tvRate.text = response.body()?.imdbRating
                        tvWriter.text = response.body()?.writer
                        tvActors.text = response.body()?.actors
                        tvCountry.text = response.body()?.country
                        tvAwards.text = response.body()?.awards
                        Picasso.get().load(response.body()?.poster).into(imgMoviePoster)
                    }

                    override fun onFailure(call: Call<IMDBResponse>, t: Throwable) {
                        Toast.makeText(this@RetrofitActivity, "Error fetching movie info", Toast.LENGTH_SHORT)
                            .show();
                    }
                })
        }

    }
}
