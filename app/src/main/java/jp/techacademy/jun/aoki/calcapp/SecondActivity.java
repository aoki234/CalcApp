package jp.techacademy.jun.aoki.calcapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        Float value1 = intent.getFloatExtra("VALUE1", 0);
        Float value2 = intent.getFloatExtra("VALUE2", 0);
        String value3 = intent.getStringExtra("VALUE3");

        TextView textView = (TextView) findViewById(R.id.textView);


        switch (value3) {
            case "2131165218":
                textView.setText(String.valueOf(value1 + value2));
                break;
            case "2131165219":
                textView.setText(String.valueOf(value1 - value2));
                break;
            case "2131165220":
                textView.setText(String.valueOf(value1 * value2));
                break;
            case "2131165221":
                textView.setText(String.valueOf(value1 / value2));
                break;
            default:
                Log.d("javatest","can not calculate");
                break;
        }


    }
}
