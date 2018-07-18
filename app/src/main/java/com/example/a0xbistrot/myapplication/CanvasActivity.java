package com.example.a0xbistrot.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class CanvasActivity extends AppCompatActivity {

    MyCanvas myCanvas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canvas);

        myCanvas = (MyCanvas)findViewById(R.id.javacanvas);
    }

    public void onImageClick(View v){
        if(v.getId() == R.id.img1){
            myCanvas.setImageNo(1);
        }
        else if (v.getId() == R.id.img2){
            myCanvas.setImageNo(2);
        }
        else if (v.getId() == R.id.img3){
            myCanvas.setImageNo(3);
        }
        else if (v.getId() == R.id.img4){
            myCanvas.setImageNo(4);
        }

    }
}
