package com.example.a0xbistrot.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MemoActivity extends AppCompatActivity {

    Button memo1, memo2, memo3, newmemo, savememo;
    EditText title, content;

    Memo memoIns1, memoIns2, memoIns3;
    int temp = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memo);
        init();

        memo1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonClicked(1);
            }
        });

        memo2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonClicked(2);
            }
        });

        memo3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonClicked(3);
            }
        });

        newmemo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonClicked(0);
            }
        });

        savememo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String c1 = title.getText().toString();
                String c2 = content.getText().toString();
                saveit(c1, c2);
            }
        });


    }

    void init() {

        memo1 = (Button) findViewById(R.id.memo1);
        memo2 = (Button) findViewById(R.id.memo2);
        memo3 = (Button) findViewById(R.id.memo3);

        title = (EditText) findViewById(R.id.title);
        content = (EditText) findViewById(R.id.content);

        newmemo = (Button) findViewById(R.id.newmemo);
        savememo = (Button) findViewById(R.id.savememo);

        memoIns1 = new Memo();
        memoIns2 = new Memo();
        memoIns3 = new Memo();

    }

    public void buttonClicked(int no) {
        if (no == 1) {
            title.setText(memoIns1.getTitle());
            content.setText(memoIns1.getContent());
            title.requestFocus();
        }

        else if (no == 2) {
            title.setText(memoIns2.getTitle());
            content.setText(memoIns2.getContent());
            title.requestFocus();
        }

        else if (no == 3) {
            title.setText(memoIns3.getTitle());
            content.setText(memoIns3.getContent());
            title.requestFocus();
        }

        else{
            title.setText("");
            content.setText("");
            title.requestFocus();
        }

        temp = no;

        if (no > 0) {
            savememo.setText("[메모" + no + "] 저장");
        }
    }

    public void saveit(String c1, String c2) {
        if (temp == 1) {
            memoIns1.setTitle(c1);
            memoIns1.setContent(c2);
            Toast.makeText(getApplicationContext(),
                    "메모" + temp + " 이/가 저장되었습니다.",
                    Toast.LENGTH_SHORT).show();
        } else if (temp == 2) {
            memoIns2.setTitle(c1);
            memoIns2.setContent(c2);
            Toast.makeText(getApplicationContext(),
                    "메모" + temp + " 이/가 저장되었습니다.",
                    Toast.LENGTH_SHORT).show();
        } else if (temp == 3) {
            memoIns3.setTitle(c1);
            memoIns3.setContent(c2);
            Toast.makeText(getApplicationContext(),
                    "메모" + temp + " 이/가 저장되었습니다.",
                    Toast.LENGTH_SHORT).show();
        }
    }
}
