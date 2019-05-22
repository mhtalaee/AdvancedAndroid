package ir.goldenmind.advancedandroid.kotlinversion.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.squareup.picasso.Picasso
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import ir.goldenmind.advancedandroid.R
import ir.goldenmind.advancedandroid.kotlinversion.retrofit.IMDBRequestInterface
import ir.goldenmind.advancedandroid.kotlinversion.retrofit.RetrofitServiceGenerator
import ir.goldenmind.advancedandroid.kotlinversion.utillity.Consts
import kotlinx.android.synthetic.main.activity_retrofit.*

class RetrofitActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_retrofit)
        btnGetMovieInfo.setOnClickListener {


            //Useing Retrofit with RxJava

            var imdbRequestInterface = RetrofitServiceGenerator.createService(IMDBRequestInterface::class.java)
            imdbRequestInterface.getMovieInfo(etMovieName.text.toString(), Consts.API_KEY)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    {
                        tvTitle.text = it.title
                        tvYear.text = it.year
                        tvGenre.text = it.genre
                        tvDirector.text = it.director
                        tvRate.text = it.imdbRating
                        tvWriter.text = it.writer
                        tvActors.text = it.actors
                        tvCountry.text = it.country
                        tvAwards.text = it.awards
                        Picasso.get().load(it.poster).into(imgMoviePoster)
                    },{
                        Toast.makeText(this@RetrofitActivity, it.message, Toast.LENGTH_SHORT)
                            .show();
                    }

                )

            //Useing Retrofit without RxJava
//            var imdbRequestInterface = RetrofitServiceGenerator.createService(IMDBRequestInterface::class.java)
//            imdbRequestInterface.getMovieInfo(etMovieName.text.toString(), Consts.API_KEY)
//                .enqueue(object : retrofit2.Callback<IMDBResponse> {
//
//                    override fun onResponse(call: Call<IMDBResponse>, response: Response<IMDBResponse>) {
//                        tvTitle.text = response.body()?.title
//                        tvYear.text = response.body()?.year
//                        tvGenre.text = response.body()?.genre
//                        tvDirector.text = response.body()?.director
//                        tvRate.text = response.body()?.imdbRating
//                        tvWriter.text = response.body()?.writer
//                        tvActors.text = response.body()?.actors
//                        tvCountry.text = response.body()?.country
//                        tvAwards.text = response.body()?.awards
//                        Picasso.get().load(response.body()?.poster).into(imgMoviePoster)
//                    }
//
//                    override fun onFailure(call: Call<IMDBResponse>, t: Throwable) {
//                        Toast.makeText(this@RetrofitActivity, "Error fetching movie info", Toast.LENGTH_SHORT)
//                            .show();
//                    }
//                })

        }
    }

    //returns False if MovieName contains non-numeric & non-alphabetic characters
    fun checkForInvalidCharacters(inputString: String) = inputString.matches(Regex("^([A-Za-z]|[0-9])+$"))

    fun checkForMinLength(inputString: String?) = (inputString?.length ?: 0) > 2
}
