package com.farhan.tictactoe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class singlePlayer extends AppCompatActivity {

    int gameState;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_player);

        gameState = 1;
    }

    public void dropIn(View view){
        ImageView selectedImage = (ImageView) view;
        int selectedBlock = 1;
        switch ((selectedImage.getId())){
            case R.id.imageView1: selectedBlock =1; break;
            case R.id.imageView2: selectedBlock =2; break;
            case R.id.imageView3: selectedBlock =3; break;

            case R.id.imageView4: selectedBlock =4; break;
            case R.id.imageView5: selectedBlock =5; break;
            case R.id.imageView6: selectedBlock =6; break;

            case R.id.imageView7: selectedBlock =7; break;
            case R.id.imageView8: selectedBlock =8; break;
            case R.id.imageView9: selectedBlock =9; break;
        }
        playGame(selectedBlock, selectedImage);
    }

    int activePlayer = 1;

    ArrayList<Integer> player1 = new ArrayList<Integer>();
    ArrayList<Integer> player2 = new ArrayList<Integer>();
    private void playGame(int selectedBlock, ImageView selectedImage) {

        if(gameState == 1){
            if(activePlayer == 1){
                selectedImage.setImageResource(R.drawable.cross);
                player1.add(selectedBlock);
                activePlayer = 2;
                autoPlay();
            }else if (activePlayer == 2){
                selectedImage.setImageResource(R.drawable.circle);
                player2.add(selectedBlock);
                activePlayer = 1;
            }
            selectedImage.setEnabled(false);
            checkWinner();
        }
    }

    private void autoPlay() {
        ArrayList<Integer> emptyList = new ArrayList<Integer>();

        for (int i=1;i<=9;i++){
            if(!(player1.contains(i) || player2.contains(i))){
                emptyList.add(i);
            }
        }
        if(emptyList.size() == 0){
            checkWinner();
            if (gameState == 1){
                TextView winnerMessage = (TextView) findViewById(R.id.winnerMsg);
                winnerMessage.setText("DRAW!");
                LinearLayout layout = (LinearLayout) findViewById(R.id.winningLayout);

                layout.setVisibility(View.VISIBLE);
            }
            gameState = 3; // Draw
        }else {
            Random r = new Random();
            int randomIndex = r.nextInt(emptyList.size());
            int selectedBlock = emptyList.get(randomIndex);
            ImageView selectedImage = (ImageView) findViewById(R.id.imageView1);

            switch (selectedBlock){
                case 1: selectedImage = (ImageView) findViewById(R.id.imageView1);break;
                case 2: selectedImage = (ImageView) findViewById(R.id.imageView2);break;
                case 3: selectedImage = (ImageView) findViewById(R.id.imageView3);break;

                case 4: selectedImage = (ImageView) findViewById(R.id.imageView4);break;
                case 5: selectedImage = (ImageView) findViewById(R.id.imageView5);break;
                case 6: selectedImage = (ImageView) findViewById(R.id.imageView6);break;

                case 7: selectedImage = (ImageView) findViewById(R.id.imageView7);break;
                case 8: selectedImage = (ImageView) findViewById(R.id.imageView8);break;
                case 9: selectedImage = (ImageView) findViewById(R.id.imageView9);break;

            }
            playGame(selectedBlock, selectedImage);
        }
    }

    private void checkWinner() {
        int winner = 0;

        if(player1.contains(1) && player1.contains(2) && player1.contains(3)){winner = 1;}
        if(player1.contains(4) && player1.contains(5) && player1.contains(6)){winner = 1;}
        if(player1.contains(7) && player1.contains(8) && player1.contains(9)){winner = 1;}

        if(player1.contains(1) && player1.contains(4) && player1.contains(7)){winner = 1;}
        if(player1.contains(2) && player1.contains(5) && player1.contains(8)){winner = 1;}
        if(player1.contains(3) && player1.contains(6) && player1.contains(9)){winner = 1;}

        if(player1.contains(1) && player1.contains(5) && player1.contains(9)){winner = 1;}
        if(player1.contains(3) && player1.contains(5) && player1.contains(7)){winner = 1;}

        if(player2.contains(1) && player2.contains(2) && player2.contains(3)){winner = 2;}
        if(player2.contains(4) && player2.contains(5) && player2.contains(6)){winner = 2;}
        if(player2.contains(7) && player2.contains(8) && player2.contains(9)){winner = 2;}

        if(player2.contains(1) && player2.contains(4) && player2.contains(7)){winner = 2;}
        if(player2.contains(2) && player2.contains(5) && player2.contains(8)){winner = 2;}
        if(player2.contains(3) && player2.contains(6) && player2.contains(9)){winner = 2;}

        if(player2.contains(1) && player2.contains(5) && player2.contains(9)){winner = 2;}
        if(player2.contains(3) && player2.contains(5) && player2.contains(7)){winner = 2;}

        if(winner != 0 && gameState == 1){
            if (winner == 1){
                TextView winnerMessage = (TextView) findViewById(R.id.winnerMsg);
                winnerMessage.setText("you win the match!");
                LinearLayout layout = (LinearLayout) findViewById(R.id.winningLayout);

                layout.setVisibility(View.VISIBLE);
            }else{
                TextView winnerMessage = (TextView) findViewById(R.id.winnerMsg);
                winnerMessage.setText("Mobile win the match!");
                LinearLayout layout = (LinearLayout) findViewById(R.id.winningLayout);

                layout.setVisibility(View.VISIBLE);
            }

            gameState = 2;//gameOver
        }
    }

    public void playAgain(View view){



        LinearLayout layout = (LinearLayout) findViewById(R.id.winningLayout);

        layout.setVisibility(view.INVISIBLE);
        gameState = 1;
        activePlayer = 1;
        player1.clear();
        player2.clear();

        ImageView iv;
        iv = (ImageView) findViewById(R.id.imageView1); iv.setImageResource(0);iv.setEnabled(true);
        iv = (ImageView) findViewById(R.id.imageView2); iv.setImageResource(0);iv.setEnabled(true);
        iv = (ImageView) findViewById(R.id.imageView3); iv.setImageResource(0);iv.setEnabled(true);

        iv = (ImageView) findViewById(R.id.imageView4); iv.setImageResource(0);iv.setEnabled(true);
        iv = (ImageView) findViewById(R.id.imageView5); iv.setImageResource(0);iv.setEnabled(true);
        iv = (ImageView) findViewById(R.id.imageView6); iv.setImageResource(0);iv.setEnabled(true);

        iv = (ImageView) findViewById(R.id.imageView7); iv.setImageResource(0);iv.setEnabled(true);
        iv = (ImageView) findViewById(R.id.imageView8); iv.setImageResource(0);iv.setEnabled(true);
        iv = (ImageView) findViewById(R.id.imageView9); iv.setImageResource(0);iv.setEnabled(true);

    }

    public void back_btn(View view){
        Intent i = new Intent(getApplicationContext(), menu.class);
        startActivity(i);
        finish();
    }

}
