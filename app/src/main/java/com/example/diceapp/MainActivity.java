package com.example.diceapp;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button rollButton = findViewById(R.id.roll_button);
        ImageView dice1 = findViewById(R.id.dice_1);
        ImageView dice2 = findViewById(R.id.dice_2);

        Random r1 = new Random();
        Random r2 = new Random();

        final MediaPlayer mp = MediaPlayer.create(this,R.raw.dice_sound);

        int[] diceArray = new int[]{
                R.drawable.dice1,
                R.drawable.dice2,
                R.drawable.dice3,
                R.drawable.dice4,
                R.drawable.dice5,
                R.drawable.dice6
        };

        rollButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int ra1 = r1.nextInt(6);
                int ra2 = r2.nextInt(6);

                dice1.setImageResource(diceArray[ra1]);
                dice2.setImageResource(diceArray[ra2]);
                mp.start();
            }
        });
    }
}