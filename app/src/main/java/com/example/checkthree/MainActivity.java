package com.example.checkthree;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button button1;
    private EditText editText1;
    public static final String EXTRA_NAME = "name";
    public static final String SCORE = "0";
    int score = 0;
    private long pressedTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //linking the ids
        button1 = findViewById(R.id.button1);
        editText1 = findViewById(R.id.editText1);

        //arrow button action
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //storing the value entered in the editText1 as a String variable
                String name = editText1.getText().toString();

                //to lower the soft keyboard once the user clicks on the proceed button
                InputMethodManager mgr = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                mgr.hideSoftInputFromWindow(editText1.getWindowToken(), 0);

                //intent to go to the next activity
                Intent intent = new Intent(MainActivity.this, QuesOne.class);

                //values passed to the next activity
                intent.putExtra(EXTRA_NAME, name);
                intent.putExtra(SCORE, score);

                //intent starts here
                startActivity(intent);

                //slide animation for transition to next activity
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

            }
        });
    }

    @Override
    public void onBackPressed() {
        if (pressedTime + 2000 > System.currentTimeMillis()) {
            super.onBackPressed();
            finish();
        } else {
            Toast.makeText(getBaseContext(), "Press back again to exit", Toast.LENGTH_SHORT).show();
        }
        pressedTime = System.currentTimeMillis();
    }
    
}