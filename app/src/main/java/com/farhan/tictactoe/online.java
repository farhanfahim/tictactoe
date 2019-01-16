package com.farhan.tictactoe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class online extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_online);
    }

    public void back_btn(View view) {
        Intent i = new Intent(getApplicationContext(), menu.class);
        startActivity(i);
        finish();
    }
}
