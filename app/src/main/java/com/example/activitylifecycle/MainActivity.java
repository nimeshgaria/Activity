package com.example.activitylifecycle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button showGuess;
    private EditText enterGuess;
    private final int REQUEST_CODE = 2;



    String names;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showGuess = findViewById(R.id.button_guess);
        enterGuess = findViewById(R.id.guess_field);

        showGuess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String guess = enterGuess.getText().toString().trim();
                if(!guess.isEmpty()){
                    Intent intent = new Intent(MainActivity.this, ShowGuess.class);
                    intent.putExtra("guess", guess);
                    intent.putExtra("name", "bond");
                    intent.putExtra("age", 34);
                    intent.putExtra("guess", guess);
                    startActivityForResult(intent,REQUEST_CODE);
                    //startActivity(intent);
                }
                else {
                    Toast.makeText(MainActivity.this, "Enter guess", Toast.LENGTH_SHORT)
                            .show();
                }
                //startActivity(new Intent(MainActivity.this, ShowGuess));
            }
        });

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode ==REQUEST_CODE){
            assert data != null;
            String message  = data.getStringExtra("message_back");
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_LONG)
                        .show();
        }

    }

}