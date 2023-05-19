package com.example.checkthree;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class QuesTwo extends AppCompatActivity {

    private RadioGroup rg2;
    private RadioButton op1, op2;
    private Button button3;
    private static final String EXTRA_NAME = "name";
    public static final String SCORE = "0";
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ques_two);
        getSupportActionBar().setTitle("Question 2");

        //linking the ids
        button3 = findViewById(R.id.button3);
        op1 = findViewById(R.id.radioButton5);
        op2 = findViewById(R.id.radioButton6);

        //setting values for each options
        op1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(QuesTwo.this, "You have selected option 1", Toast.LENGTH_SHORT).show();
                count++;
            }
        });
        op2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(QuesTwo.this, "You have selected option 2", Toast.LENGTH_SHORT).show();
            }
        });

        //next button action
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //intent to retrieve value from the previous activity
                Intent intent1 = getIntent();
                String name = intent1.getStringExtra(MainActivity.EXTRA_NAME);
                int score = intent1.getIntExtra(MainActivity.SCORE, 0);

                //intent to go to the next activity
                Intent intent2 = new Intent(QuesTwo.this, QuesThree.class);

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