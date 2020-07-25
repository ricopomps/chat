package com.example.chat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;



public class Chat2 extends AppCompatActivity {
private Button reply;
private EditText eT;
public static String text = "id_message_extra";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat2);

        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        TextView mTextMessage = findViewById(R.id.textView3);
        mTextMessage.setText(message);

        reply = findViewById(R.id.button2);
        eT = findViewById(R.id.editTextTextPersonName2);
        reply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                Intent intentSecondScreen = new Intent(Chat2.this,MainActivity.class );
                String mes = eT.getText().toString();
                intentSecondScreen.putExtra(text,mes);
                startActivityForResult(intentSecondScreen, 2010);
            }
        });


    }
}