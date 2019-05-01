package ir.goldenmind.advancedandroid.javaversion.activities;

import android.widget.EditText;
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
    EditText etNumber;

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
        etNumber = findViewById(R.id.etNumber);

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setImage(etNumber.getText().toString());
            }
        });
    }

    public void setImage(String number) {

        Integer remained = Integer.valueOf(number) % 2;

        if (remained.equals(1)) {
            imgOdd.setVisibility(View.VISIBLE);
        } else {
            imgEven.setVisibility(View.VISIBLE);
        }


    }
}
