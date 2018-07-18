package com.example.a0xbistrot.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class AnotherActivity extends AppCompatActivity {

    EditText americano, cafelatte, cafemocha;
    CheckBox discount;
    Button button;
    TextView total, dc, payment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_another);      // 현재 Activity의 default 화면이 된다.

        americano = (EditText)findViewById(R.id.americano); // layout과 연결하는 부분
        cafelatte = (EditText)findViewById(R.id.cafelatte);
        cafemocha = (EditText)findViewById(R.id.cafemocha);
        discount = (CheckBox)findViewById(R.id.discount);
        button = (Button)findViewById(R.id.calculate);
        total = (TextView)findViewById(R.id.total);
        dc = (TextView)findViewById(R.id.dc);
        payment = (TextView)findViewById(R.id.payment);

        Log.d("onClick", "==>onCreate()");

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 커피 개수를 가져온다.
                String temp1 = americano.getText().toString();
                int count1 = Integer.parseInt(temp1);
                String temp2 = cafelatte.getText().toString();
                int count2 = Integer.parseInt(temp2);
                String temp3 = cafemocha.getText().toString();
                int count3 = Integer.parseInt(temp3);
                int dis;
                int tot;
                int pay;

                // 할인카드가 적용되었는지 확인한다.
                if(discount.isChecked()) dis = 10;
                else dis = 100;
                // 주문개수를 만든다.
                int sum = count1 + count2 + count3;

                // 할인금액을 만든다.
                tot = (count1*1000 + count2*1500 + count3*1700)*dis/100;
                // 결재금액을 만든다.
                pay = (count1*1000 + count2*1500 + count3*1700)*(100-dis)/100;

                // 화면에 보여준다.
                total.setText("주문개수 : "+ sum +" 개");
                dc.setText("할인금액 : "+ tot +" 원");
                payment.setText("결제금액 : "+ pay +" 원");
            }
        });

    }



}
