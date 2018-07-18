package com.example.a0xbistrot.myapplication;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Iterator;

public class AdvancedParkingLot extends AppCompatActivity {

    Button getin[] = new Button[4];
    int btnInId[] = {R.id.getin1, R.id.getin2, R.id.getin3, R.id.getin4};
    Button getout[] = new Button[4];
    int btnOutId[] = {R.id.getout1, R.id.getout2, R.id.getout3, R.id.getout4};

    TextView carName[] = new TextView[4];
    int cNameId[] = {R.id.carname1,R.id.carname2, R.id.carname3, R.id.carname4};

    TextView carNo[] = new TextView[4];
    int cNoId[] = {R.id.carnumber1,R.id.carnumber2, R.id.carnumber3, R.id.carnumber4};

    TextView carTime[] = new TextView[4];
    int cTimeId[] = {R.id.cartime1,R.id.cartime2, R.id.cartime3, R.id.cartime4};

    CarInfo carInfo[] = new CarInfo[4];



    int temp = 0;
    boolean status = true; // true -> 입차;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advanced_parking_lot);


        for(int i = 0 ; i < 4 ; i++){
            carName[i] = (TextView)findViewById(cNameId[i]);
            carNo[i] = (TextView)findViewById(cNoId[i]);
            carTime[i] = (TextView)findViewById(cTimeId[i]);
            carInfo[i] = new CarInfo();
            getin[i] = (Button)findViewById(btnInId[i]);
            getout[i] = (Button)findViewById(btnOutId[i]);
        }

        setTitle("발전된 주차장");
    }

    public void onInOut(View v){

        finder(v);
        if(status){
            onSelect(v);
        }
        else{
            carName[temp].setText("차종류 : ");
            carNo[temp].setText("차번호 : ");
            carTime[temp].setText("입차시간 : ");
            carInfo[temp].parkedOut();

            String Message = "주차시간 : "+ carInfo[temp].getTemp() + "분 \n주차요금 : " + carInfo[temp].getSum() +"원";
            Toast.makeText(this, Message , Toast.LENGTH_SHORT).show();


            getout[temp].setEnabled(false);
            getin[temp].setEnabled(true);
        }


    }


    public void onSelect(View v){
        View dlgview = View.inflate(this, R.layout.parking_dialog, null);
        final EditText et1 = (EditText)dlgview.findViewById(R.id.kindofcar);
        final EditText et2 = (EditText)dlgview.findViewById(R.id.numberofcar);

        final String tempCarName = et1.getText().toString();
        final String tempCarNo = et2.getText().toString();


        AlertDialog.Builder dlg = new AlertDialog.Builder(this);
        dlg.setTitle("입차 정보");
        dlg.setView(dlgview);
        dlg.setNegativeButton("입력", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                carInfo[temp].parkedIn(tempCarName, tempCarNo);
                carName[temp].setText("차종류 : " +tempCarName);
                carNo[temp].setText("차번호 : " + tempCarNo);
                carTime[temp].setText("입차시간 : "+carInfo[temp].getDateFormat());

                getin[temp].setEnabled(false);
                getout[temp].setEnabled(true);

                Toast.makeText(getApplicationContext(),  " 입력 되었습니다.", Toast.LENGTH_SHORT).show();
            }
        });

        dlg.setPositiveButton("취소", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getApplicationContext(),  " 취소하였습니다.", Toast.LENGTH_SHORT).show();
            }
        });

        dlg.show();


    }

    public void finder(View v){
        for(int i = 0 ; i < 4; i++){
            if(btnInId[i] == v.getId()){
                temp = i;
                status = true;
            }
            else if (btnOutId[i] == v.getId()){
                temp = i;
                status = false;
            }

        }
    }



}


/*



        */