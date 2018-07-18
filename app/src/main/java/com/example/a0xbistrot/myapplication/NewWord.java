package com.example.a0xbistrot.myapplication;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class NewWord extends AppCompatActivity {

    ArrayList<Word> data = new ArrayList<>();
    NewWordAdapter adapter;
    ListView listView;

    int CodeAdd = 100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_word);
        setTitle("새로운 단어장");

        readData();

        adapter = new NewWordAdapter(this, data);
        listView = (ListView)findViewById(R.id.newlistview);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });

    }

    public void onAdd(View v){
        Intent intent = new Intent(this, AddingWordActivity.class);
        startActivityForResult(intent, CodeAdd);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        if(requestCode == CodeAdd){
            if(resultCode == RESULT_OK){
                String word = intent.getStringExtra("word");
                String meaning = intent.getStringExtra("meaning");
                data.add(new Word(word, meaning));
                adapter.notifyDataSetChanged();
                Toast.makeText(getApplicationContext(), "단어가 추가되었습니다.", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        saveData();
    }

    private void displayToast(String msg){
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    public void saveData(){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(getFilesDir() + "file.txt"));
            for(int i = 0 ;  i < data.size(); i++){
                writer.write(data.get(i).getWord() +"-"+ data.get(i).getMeaning());
            }
            writer.close();
        } catch (IOException e) {
            displayToast("파일 저장 중 에러가 발생하였습니다.");
            e.printStackTrace();
        }
    }

    public void readData(){
        try {

            BufferedReader reader = new BufferedReader(new FileReader(getFilesDir() + "file.txt"));
            String strtemp = "";
            while((strtemp = reader.readLine()) != null){
                String[] dummy = strtemp.split("-");  // 스트링에서 특정 부분을 제외하고 분리하여 dummy 어레이에 나눈 부분들을 집어 넣음
                                                             // 파일에 word-meaning 으로 입력되있으므로 dummy[0] = word, dummy[1] = meaning
                data.add(new Word(dummy[0], dummy[1]));
            }
        } catch (FileNotFoundException e) {
            displayToast("파일이 존재하지 않음.");
            e.printStackTrace();
        } catch (IOException e) {
            displayToast("파일 읽기 중 에러 발생.");
            e.printStackTrace();
        }
    }
}
