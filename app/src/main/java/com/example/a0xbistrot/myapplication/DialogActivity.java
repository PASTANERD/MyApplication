package com.example.a0xbistrot.myapplication;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class DialogActivity extends AppCompatActivity {

    int selectedItem = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);

        this.setTitle("대화상자");
    }

    public void onClick(View v){
        if(v.getId() == R.id.dia1){
            AlertDialog.Builder dlg = new AlertDialog.Builder(this);
            dlg.setTitle("기본대화상자");
            dlg.setIcon(R.mipmap.ic_launcher);
            dlg.setMessage("이것은 기본 대화상자입니다.");
            dlg.setNegativeButton("닫기", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    Toast.makeText(getApplicationContext(),"닫기를 누르셨습니다.", Toast.LENGTH_SHORT).show();
                }
            });
            dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    Toast.makeText(getApplicationContext(),"확인을 누르셨습니다.", Toast.LENGTH_SHORT).show();
                }
            });
            dlg.show();
        }
        if(v.getId() == R.id.dia2){
            final String data[] = {"치킨", "스파게티"};

            AlertDialog.Builder dlg = new AlertDialog.Builder(this);
            dlg.setTitle("라디오 대화상자");
            dlg.setIcon(R.mipmap.ic_launcher);

            dlg.setSingleChoiceItems(data, 0, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    selectedItem = i;
                }
            });
            dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    Toast.makeText(getApplicationContext(), data[selectedItem]+"을(를) 선택하tuT습니다.", Toast.LENGTH_SHORT).show();
                }
            });

            dlg.show();
        }
        if(v.getId() == R.id.dia3){
            final String hobby[] = {"영화보기", "음악감상", "게임하기", "여행하기"};
            final boolean checked[] = {true, true, false, false};

            AlertDialog.Builder dlg = new AlertDialog.Builder(this);
            dlg.setTitle("취미를 고르시게.");
            dlg.setMultiChoiceItems(hobby, checked, new DialogInterface.OnMultiChoiceClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                    checked[i] = b;


                }
            });
            dlg.setPositiveButton("선택완료", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    Toast.makeText(getApplicationContext(), robot(checked, hobby) + " 선택완료.", Toast.LENGTH_SHORT).show();
                }
            });

            dlg.show();
        }

        if(v.getId() == R.id.dia4){
            View dlgview = View.inflate(this, R.layout.customdialog, null);
            final EditText et1 = (EditText)dlgview.findViewById(R.id.editText2);
            et1.setBackgroundColor(Color.BLUE);
            AlertDialog.Builder dlg = new AlertDialog.Builder(this);
            dlg.setTitle("사용자정의 대화상자");
            dlg.setView(dlgview);
            dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    Toast.makeText(getApplicationContext(),  et1.getText().toString() + " 을 누르셨습니다..", Toast.LENGTH_SHORT).show();
                }
            });

            dlg.show();
        }
    }


    public String robot(boolean checked[], String hobby[]){
        String temp = "";
        for(int i = 0; i < 4; i++){
            if(checked[i]){
                temp += hobby[i];
                temp += " ";
            }
        }
        return temp;
    }
}
