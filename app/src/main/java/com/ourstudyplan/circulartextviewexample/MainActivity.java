package com.ourstudyplan.circulartextviewexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    CircularTextView circularTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        circularTextView = findViewById(R.id.ctextView);
        circularTextView.setText("123");
        circularTextView.setTextColor(getResources().getColor(R.color.red));
        circularTextView.setStrokeWidth(1); // in dp
        circularTextView.setSolidColor(getResources().getColor(R.color.green));
        circularTextView.setStrokeColor(getResources().getColor(R.color.blue));
    }
}
