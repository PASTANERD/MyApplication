package com.example.a0xbistrot.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AddingWordActivity extends AppCompatActivity {

    EditText e1, e2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adding_word);

        e1 = (EditText)findViewById(R.id.newword);
        e2 = (EditText)findViewById(R.id.newmeaning);

        // Intent intent = getIntent(); 데이터 받을 때 사용
    }

    public void onConfirm(View v){
        if(v.getId() == R.id.confirm){
            Intent intent = new Intent(this,MainActivity.class);
            intent.putExtra("word", e1.getText().toString());
            intent.putExtra("meaning", e2.getText().toString());
            setResult(RESULT_OK, intent);
            finish();
        }
        else finish();

    }

}
