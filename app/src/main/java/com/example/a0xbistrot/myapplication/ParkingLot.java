package com.example.a0xbistrot.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;

public class ParkingLot extends AppCompatActivity {

    TextView lotindex;
    EditText edit1, edit2;
    Button getin, getout;

    TextView carName[] = new TextView[4];
    int cNameId[] = {R.id.carname1,R.id.carname2, R.id.carname3, R.id.carname4};

    TextView carNo[] = new TextView[4];
    int cNoId[] = {R.id.carnumber1,R.id.carnumber2, R.id.carnumber3, R.id.carnumber4};

    TextView carTime[] = new TextView[4];
    int cTimeId[] = {R.id.cartime1,R.id.cartime2, R.id.cartime3, R.id.cartime4};

    CarInfo carInfo[] = new CarInfo[4];



    int temp = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parking_lot);

        lotindex = (TextView)findViewById(R.id.lotindex);
        edit1 = (EditText)findViewById(R.id.edit1);
        edit2 = (EditText)findViewById(R.id.edit2);

        getin = (Button)findViewById(R.id.getin);
        getout = (Button)findViewById(R.id.getout);

        for(int i = 0 ; i < 4 ; i++){
            carName[i] = (TextView)findViewById(cNameId[i]);
            carNo[i] = (TextView)findViewById(cNoId[i]);
            carTime[i] = (TextView)findViewById(cTimeId[i]);
            carInfo[i] = new CarInfo();
        }

        setTitle("주차관리?");
    }

    public void onInOut(View v){
        String tempCarName = edit1.getText().toString();
        String tempCarNo = edit2.getText().toString();

        SimpleDateFormat reformat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");


        if(v.getId() == R.id.getin){
            carInfo[temp].parkedIn(tempCarName, tempCarNo);
            carName[temp].setText("차종류 : " +carInfo[temp].getCarName());
            carNo[temp].setText("차번호 : " + carInfo[temp].getCarNo());
            carTime[temp].setText("입차시간 : "+carInfo[temp].getDateFormat());
            edit1.setText("");
            edit2.setText("");
            edit1.requestFocus();
            v.setEnabled(false);
            getout.setEnabled(true);

        }

        if(v.getId() == R.id.getout){
            carName[temp].setText("차종류 : ");
            carNo[temp].setText("차번호 : ");
            carTime[temp].setText("입차시간 : ");
            String Message = "주차시간 : "+ carInfo[temp].getTemp() + "분 \n주차요금 : " + carInfo[temp].getSum() +"원";
            Toast.makeText(this, Message , Toast.LENGTH_SHORT).show();
            carInfo[temp].parkedOut();

            v.setEnabled(false);
            getin.setEnabled(true);
        }

    }


    public void onSelect(View v){
        if(v.getId() == R.id.choose1){
            temp = 0;
            selectFunc(temp);

        }
        if(v.getId() == R.id.choose2){
            temp = 1;
            selectFunc(temp);
        }
        if(v.getId() == R.id.choose3){
            temp = 2;
            selectFunc(temp);
        }
        if(v.getId() == R.id.choose4){
            temp = 3;
            selectFunc(temp);
        }


    }

    public void selectFunc(int index){
        lotindex.setText((index+1)+"번");
        if(carInfo[index].isOccupied()){
            getin.setEnabled(false);
            getout.setEnabled(true);
        }
        else{
            getin.setEnabled(true);
            getout.setEnabled(false);
        }



    }


}
