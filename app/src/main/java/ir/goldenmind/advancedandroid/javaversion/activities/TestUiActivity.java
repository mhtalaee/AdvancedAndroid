package ir.goldenmind.advancedandroid.javaversion.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import ir.goldenmind.advancedandroid.R;

public class TestUiActivity extends AppCompatActivity {

    ImageView imgOdd;
    ImageView imgEven;
    Button btnOk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_ui);

        imgEven = findViewById(R.id.imgEven);
        imgEven.setVisibility(View.INVISIBLE);
        imgEven.setImageResource(R.drawable.even);

        imgOdd = findViewById(R.id.imgOdd);
        imgOdd.setVisibility(View.INVISIBLE);
        imgOdd.setImageResource(R.drawable.odd);

        btnOk = findViewById(R.id.btnOk);

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setImage(3);
            }
        });
    }

    public void setImage(Integer number) {

        Integer remained = number % 2;

        if (remained.equals(1)) {
            imgOdd.setVisibility(View.VISIBLE);
        } else {
            imgEven.setVisibility(View.VISIBLE);
        }


    }
}
