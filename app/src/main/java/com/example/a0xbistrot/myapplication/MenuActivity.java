package com.example.a0xbistrot.myapplication;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MenuActivity extends AppCompatActivity {

    LinearLayout linear;
    ImageView image;
    TextView foodtitle;

    CheckBox showTitle, doubleTime;
    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        linear = (LinearLayout)findViewById(R.id.mnuLayout);
        image = (ImageView)findViewById(R.id.imageView);
        foodtitle = (TextView)findViewById(R.id.foodtitle);

        showTitle = (CheckBox)findViewById(R.id.mnuShowTitle);
        doubleTime = (CheckBox)findViewById(R.id.mnu2x);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu1, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        if(item.getItemId() == R.id.mnuRed){
            linear.setBackgroundColor(Color.RED);
        }
        if(item.getItemId() == R.id.mnuBlue){
            linear.setBackgroundColor(Color.BLUE);
        }
        if(item.getItemId() == R.id.mnuYellow){
            linear.setBackgroundColor(Color.YELLOW);
        }

        if(item.getItemId() == R.id.mnuRotation){
            i += 30;
            image.setRotation(i);
        }

        if(item.getItemId() == R.id.mnuPasta){
            image.setImageResource(R.drawable.spaghetti);
            item.setChecked(true);
            foodtitle.setText("겁나 맛있는 스파게티");
        }

        if(item.getItemId() == R.id.mnuChicken){
            image.setImageResource(R.drawable.chicken);
            item.setChecked(true);
            foodtitle.setText("겁나 맛있는 치킨");
        }

/*
        showTitle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b) {
                    foodtitle.setVisibility(View.INVISIBLE);
                }
                else  foodtitle.setVisibility(View.VISIBLE);
            }
        });

        doubleTime.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    image.setMaxWidth(300);
                    image.setMaxHeight(300);
                }
                else{
                    image.setMaxWidth(150);
                    image.setMaxHeight(150);
                }
            }
        });


*/
        return super.onOptionsItemSelected(item);
    }
}
