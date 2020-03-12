package com.example.knowyourcampus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class FindLocation extends AppCompatActivity {

    TextView anagram = null;
    TextView desc = null;
    ImageView image = null;
    Button reveal = null;

            LinkedList<Integer> toRev = new LinkedList<Integer>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_location);

        anagram = (TextView) findViewById(R.id.anagramHint);
        desc = (TextView) findViewById(R.id.descHint);
        image = (ImageView) findViewById(R.id.imageHint);
        reveal = (Button) findViewById(R.id.revealButton);

        Random rand  = new Random();

        int r;

        LinearLayout myLinearLayout = (LinearLayout) findViewById(R.id.linLay);
        int childcount = myLinearLayout.getChildCount();
        View[] children = new View[childcount];

        for (int i=0; i < childcount; i++){
            children[i] = myLinearLayout.getChildAt(i);
        }
        myLinearLayout.removeAllViews();


        do{
            r = rand.nextInt(3);
            if (toRev.contains(r)){
                continue;
            }
            toRev.add(r);
            myLinearLayout.addView(children[r]);
        }while(toRev.size() < 3);

        reveal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (toRev.peek() == 0){
                    anagram.setVisibility(View.VISIBLE);
                }
                if (toRev.peek() == 1){
                    desc.setVisibility(View.VISIBLE);
                }
                if (toRev.peek() == 2){
                    image.setVisibility(View.VISIBLE);
                }
                toRev.pop();
                if (toRev.size() == 0){
                    reveal.setVisibility(View.INVISIBLE);
                }
            }
        });

    }
}
