package com.farhan.tictactoe;

import android.content.Intent;
import android.support.annotation.DrawableRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    //0 FOR YELLOW 1 FOR RED

    int activeUser = 0;

    boolean gameIsActive = true;

    // 2 means unPlayed

    int[] gameState = {2,2,2,2,2,2,2,2,2};



    public void dropIn(View view) {
        ImageView counter = (ImageView) view;

        counter.setTranslationY(-1000f);

        int[][] winningPositions = {{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};

        int tappedCounter = Integer.parseInt(counter.getTag().toString());

        if(gameState[tappedCounter] == 2 && gameIsActive) {

            gameState[tappedCounter] = activeUser;

            if (activeUser == 0) {

                counter.setImageResource(R.drawable.circle);

                activeUser = 1;
            } else {
                counter.setImageResource(R.drawable.cross);

                activeUser = 0;

            }
        }
        counter.animate().translationYBy(1000f).setDuration(5);

        for(int[] winningPosition : winningPositions){
            if (gameState[winningPosition[0]] == gameState[winningPosition[1]] &&
                    gameState[winningPosition[1]] == gameState[winningPosition[2]] &&
                    gameState[winningPosition[0]] != 2){

                    gameIsActive = false;

                    String winner = "CROSS";

                    if (gameState[winningPosition[0]] == 0){

                        winner = "CIRCLE";

                    }

                TextView winnerMessage = (TextView) findViewById(R.id.winnerMsg);

                winnerMessage.setText(winner + " HAS WON!");

                LinearLayout layout = (LinearLayout) findViewById(R.id.winningLayout);

                layout.setVisibility(view.VISIBLE);
            }else {
                boolean gameIsOver = true;

                for (int counterState : gameState){

                    if(counterState == 2) gameIsOver = false;

                }if(gameIsOver){

                    TextView winnerMessage = (TextView) findViewById(R.id.winnerMsg);

                    winnerMessage.setText("DRAW!");

                    LinearLayout layout = (LinearLayout) findViewById(R.id.winningLayout);

                    layout.setVisibility(view.VISIBLE);

                }
            }
        }

    }

    public void playAgain(View view){

        gameIsActive = true;

        LinearLayout layout = (LinearLayout) findViewById(R.id.winningLayout);

        layout.setVisibility(view.INVISIBLE);

        activeUser = 0;

        for (int i = 0;i<gameState.length;i++){

            gameState[i] = 2;
        }

        GridLayout gridLayout = (GridLayout) findViewById(R.id.gridlayout);

        for (int i=0;i<gridLayout.getChildCount();i++){

            ((ImageView) gridLayout.getChildAt(i)).setImageResource(0);
        }

    }

    public void back_btn(View view){
        Intent i = new Intent(getApplicationContext(), menu.class);
        startActivity(i);
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }



}
