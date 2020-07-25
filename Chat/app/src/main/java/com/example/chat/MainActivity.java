package com.example.chat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public final static String EXTRA_MESSAGE = "id_mensagem_extra";

    public final static int TEXT_REQUEST = 2010;


    private TextView mTextView1;
    private TextView mTextView2;
    private EditText mEditText;
    private Button mButton;

    //ctrl + alt + L  = identação
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextView1 = findViewById(R.id.textView);
        mTextView2 = findViewById(R.id.textView2);
        mEditText = findViewById(R.id.editTextTextPersonName);
        mButton = findViewById(R.id.button);
        
        Intent intent = getIntent();
        String reply = intent.getStringExtra(Chat2.text);

        mTextView2.setText(reply);
        if(null!=reply){
            mTextView1.setText("Reply received");
        }
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentSecondScreen = new Intent(MainActivity.this, Chat2.class);
                //startActivity(intentSecondScreen);

                String message = mEditText.getText().toString();
                intentSecondScreen.putExtra(EXTRA_MESSAGE, message);


                startActivityForResult(intentSecondScreen, TEXT_REQUEST);
            }
        });


    }
}