package com.techdew.circlepercentageview;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.techdew.library.CirclePercentageView;

public class MainActivity extends AppCompatActivity {
    CirclePercentageView circlePercentView;
    int value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        circlePercentView = (CirclePercentageView) findViewById(R.id.percentview);

        new Thread(new Runnable() {
            @Override
            public void run() {

                for (value = 0; value <= 100; value++) {
                    Handler mainHandler = new Handler(getApplicationContext().getMainLooper());
                    mainHandler.post(new Runnable() {
                        @Override
                        public void run() {

                            circlePercentView.setPercentage(value);

                        }
                    });
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        }).start();


    }
}
