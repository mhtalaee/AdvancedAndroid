package ir.goldenmind.advancedandroid.kotlinversion.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isVisible
import ir.goldenmind.advancedandroid.R
import kotlinx.android.synthetic.main.activity_ui_test.*

class UiTest : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ui_test)

        setImage(9)

    }

    fun setImage(number : Int){

        imgEven.setImageResource(R.drawable.even)
        imgOdd.setImageResource(R.drawable.odd)

        imgEven.isVisible = false;
        imgOdd.isVisible = false;

        if (number.rem(2).equals(0)){
            imgEven.isVisible = true;
            imgOdd.isVisible = false;
        } else {
            imgEven.isVisible = false;
            imgOdd.isVisible = true;
        }
    }
}
