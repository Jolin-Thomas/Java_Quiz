package com.example.checkthree;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Locale;

public class Result extends AppCompatActivity {

    private TextView textView7, textView8;
    private Button button7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        getSupportActionBar().setTitle("Result");

        //linking the ids
        textView7 = findViewById(R.id.textView7);
        textView8 = findViewById(R.id.textView8);
        button7 = findViewById(R.id.button7);

        //intent to retrieve value from the previous activity
        Intent intent = getIntent();
        String name = intent.getStringExtra(MainActivity.EXTRA_NAME);
        int score = intent.getIntExtra(MainActivity.SCORE, 0);

        //setting up username and score in textview
        textView7.setText(name+" Your Score is: "+score+"/50");

        //calc
        if(score<=20) {
            textView8.setText("Poor performance");
        }
        else if(score>20 &&score<50) {
            textView8.setText("Can score better");
        }
        else {
            textView8.setText("Excellent");
        }

        //try again button action
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //intent to go to the next activity
                Intent intent = new Intent(Result.this, MainActivity.class);

                //intent starts here
                startActivity(intent);

                //slide animation for transition to next activity
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
            }
        });

    }

    //slide animation to transition to the previous activity
    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }

    @Override
    public void onBackPressed() {
        Toast.makeText(Result.this, "Cannot go back", Toast.LENGTH_SHORT).show();
    }

}