package com.example.checkthree;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class QuesThree extends AppCompatActivity {

    private Button button4;
    private RadioGroup rg3;
    private RadioButton op1, op2, op3, op4;
    private static final String EXTRA_NAME = "name";
    public static final String SCORE = "0";
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ques_three);
        getSupportActionBar().setTitle("Question 3");

        //linking the ids
        button4 = findViewById(R.id.button4);
        op1  = findViewById(R.id.radioButton7);
        op2  = findViewById(R.id.radioButton8);
        op3  = findViewById(R.id.radioButton9);
        op4  = findViewById(R.id.radioButton10);

        //setting values for each options
        op1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(QuesThree.this, "You have selected option 1", Toast.LENGTH_SHORT).show();
            }
        });
        op2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(QuesThree.this, "You have selected option 2", Toast.LENGTH_SHORT).show();
            }
        });
        op3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(QuesThree.this, "You have selected option 3", Toast.LENGTH_SHORT).show();
                count++;
            }
        });
        op4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(QuesThree.this, "You have selected option 4", Toast.LENGTH_SHORT).show();
            }
        });

        //next button action
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //intent to retrieve value from the previous activity
                Intent intent1 = getIntent();
                String name = intent1.getStringExtra(MainActivity.EXTRA_NAME);
                int score = intent1.getIntExtra(MainActivity.SCORE, 0);

                //intent to go to the next activity
                Intent intent2 = new Intent(QuesThree.this, QuesFour.class);

                //calc
                if(count == 1) {
                    score+=10;
                }

                //values passed to the next activity
                intent2.putExtra(EXTRA_NAME, name);
                intent2.putExtra(SCORE, score);

                //intent starts here
                startActivity(intent2);

                //slide animation for transition to next activity
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

            }
        });
    }

    //slide animation to transition to the previous activity
    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }
}