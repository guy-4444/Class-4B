package com.example.class4b;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button main_BTN_go;
    private TextView main_LBL_txt;
    private int counter = 0;



    private ImageView[] avatars;
    private int pos = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);


        avatars = new ImageView[]{
                findViewById(R.id.main_IMG_a1),
                findViewById(R.id.main_IMG_a2),
                findViewById(R.id.main_IMG_a3)
        };

        main_BTN_go = findViewById(R.id.main_BTN_go);
        main_LBL_txt = findViewById(R.id.main_LBL_txt);

        main_BTN_go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tickerFunc();
            }
        });




        loopFunc();
    }

    private void loopFunc() {
        final Handler handler = new Handler();
        Runnable myRun = new Runnable() {
            @Override
            public void run() {
                loopFunc();
                tickerFunc();
            }
        };
        handler.postDelayed(myRun, 1000);
    }


    private void tickerFunc() {
        main_LBL_txt.setText("Counter: " + counter++);

        pos++;
        if (pos >= avatars.length) {
            pos = 0;
        }

        for (int i = 0; i < avatars.length; i++) {
            if (i == pos) {
                avatars[i].setVisibility(View.VISIBLE);
            } else {
                avatars[i].setVisibility(View.INVISIBLE);
            }
        }

    }

    private void goToGameActivity() {
        Intent intent = new Intent(MainActivity.this, GameActivity.class);
        startActivity(intent);
    }


}
