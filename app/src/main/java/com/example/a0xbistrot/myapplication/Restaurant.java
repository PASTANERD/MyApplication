package com.example.a0xbistrot.myapplication;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Restaurant extends AppCompatActivity {

    EditText pizza, pasta, salad;
    CheckBox membership;
    RadioButton picklePicked, saucePicked;
    Button finish;
    TextView ordered, total, choice;

    ImageView image;

    int sum, pay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant);
        init();

        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cal();
                Snackbar.make(view,
                        "메모 주문 금액이 계싼 되었습니다.",
                        Snackbar.LENGTH_SHORT).show();
            }
        });
    }


    public void cal(){
        String tpizza = pizza.getText().toString();
        int npizza = Integer.parseInt(tpizza);
        String tpasta = pasta.getText().toString();
        int npasta = Integer.parseInt(tpasta);
        String tsalad = salad.getText().toString();
        int nsalad = Integer.parseInt(tsalad);

        sum = npizza + npasta + nsalad;
        pay = npizza*16000 + npasta*11000 + nsalad*4000;

        if(membership.isChecked()){
            pay = pay*93/100;
        }

        ordered.setText("주문 개수 : "+sum+" 개");
        total.setText("주문 금액 : "+pay+" 원");

        if(picklePicked.isChecked()){
            choice.setText("피클 선택하셨습니다.");

            image.setImageResource(R.drawable.pickles);
        }
        else if(saucePicked.isChecked()){
            choice.setText("소스 선택하셨습니다.");

            image.setImageResource(R.drawable.sauce);
        }
    }


    private void init(){

        pizza = (EditText)findViewById(R.id.pizza); // layout과 연결하는 부분
        pasta = (EditText)findViewById(R.id.pasta);
        salad = (EditText)findViewById(R.id.salad);

        membership = (CheckBox)findViewById(R.id.membership);
        picklePicked = (RadioButton)findViewById(R.id.picklePicked);
        saucePicked = (RadioButton)findViewById(R.id.saucePicked);

        finish = (Button)findViewById(R.id.finish);
        ordered = (TextView)findViewById(R.id.ordered);
        total = (TextView)findViewById(R.id.total);
        choice = (TextView)findViewById(R.id.choice);
        image = (ImageView)findViewById(R.id.image);

    }
}
