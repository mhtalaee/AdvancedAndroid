package ir.goldenmind.advancedandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.squareup.picasso.Picasso
import ir.goldenmind.advancedandroid.imdb.IMDBResponse
import ir.goldenmind.advancedandroid.retrofit.IMDBRequestInterface
import ir.goldenmind.advancedandroid.retrofit.RetrofitServiceGenerator
import ir.goldenmind.advancedandroid.utillity.Consts
import kotlinx.android.synthetic.main.activity_retrofit.*
import retrofit2.Call
import retrofit2.Response

class RetrofitKotlinActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_retrofit)

        var imdbRequestInterface = RetrofitServiceGenerator.createService(IMDBRequestInterface::class.java)
        imdbRequestInterface.getMovieInfo("seven", Consts.API_KEY)
            .enqueue(object : retrofit2.Callback<IMDBResponse> {

                override fun onResponse(call: Call<IMDBResponse>, response: Response<IMDBResponse>) {
                    tvTitle.text = response.body()!!.title
                    tvYear.text = response.body()!!.year
                    tvGenre.text = response.body()!!.genre
                    tvDirector.text = response.body()!!.director
                    tvRate.text = response.body()!!.imdbRating
                    tvWriter.text = response.body()!!.writer
                    tvActors.text = response.body()!!.actors
                    tvCountry.text = response.body()!!.country
                    tvAwards.text = response.body()!!.awards
                    Picasso.get().load(response.body()!!.poster).into(imgMoviePoster)

                }

                override fun onFailure(call: Call<IMDBResponse>, t: Throwable) {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }
            })


    }
}
