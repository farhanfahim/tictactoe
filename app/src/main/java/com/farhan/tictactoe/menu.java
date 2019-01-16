package com.farhan.tictactoe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class menu extends AppCompatActivity {

    Button btn1,btn2,btn3,btn4,btn5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.onlineBtn);
        btn4 = (Button) findViewById(R.id.aboutBtn);
        btn5 = (Button) findViewById(R.id.exitBtn);

        btn1.setTranslationY(1000f);
        btn1.animate().translationY(0).setDuration(800);

        btn2.setTranslationY(1000f);
        btn2.animate().translationY(0).setDuration(1000);

        btn3.setTranslationY(1000f);
        btn3.animate().translationY(0).setDuration(1200);

        btn4.setTranslationY(1000f);
        btn4.animate().translationY(0).setDuration(1400);

        btn5.setTranslationY(1000f);
        btn5.animate().translationY(0).setDuration(1600);

    }
    public void single_mode(View view) {

        Intent i = new Intent(getApplicationContext(), singlePlayer.class);
        startActivity(i);
        finish();
    }

    public void offline_mode(View view) {

        Intent i = new Intent(getApplicationContext(), offline.class);
        startActivity(i);
        finish();
    }
    public void online_mode(View view){
        Intent i = new Intent(getApplicationContext(), online.class);
        startActivity(i);
        finish();
    }

    public void about_btn(View view){
        Intent i = new Intent(getApplicationContext(), about.class);
        startActivity(i);
        finish();
    }
    public void exit_btn(View view){
        finish();
    }
}
