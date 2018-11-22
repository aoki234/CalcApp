package jp.techacademy.jun.aoki.calcapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();

        String value3 = intent.getStringExtra("VALUE3");

        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText(value3);

    }

}
