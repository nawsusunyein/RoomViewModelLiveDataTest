package com.example.roomusersample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NewUserActivity extends AppCompatActivity {

    EditText textViewUsername;
    Button btnSave;
    public static final String EXTRA_REPLY = "com.example.roomusersample.REPLY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_user);
        textViewUsername = findViewById(R.id.txtUsername);
        btnSave = findViewById(R.id.btnSaveName);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent replyIntent = new Intent();
                if(TextUtils.isEmpty(textViewUsername.getText())){
                    setResult(RESULT_CANCELED,replyIntent);
                }else{
                    String word = textViewUsername.getText().toString();
                    replyIntent.putExtra(EXTRA_REPLY,word);
                    setResult(RESULT_OK,replyIntent);
                }
                finish();
            }
        });
    }
}
