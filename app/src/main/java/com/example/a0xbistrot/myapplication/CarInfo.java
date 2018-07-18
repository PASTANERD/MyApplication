package com.example.a0xbistrot.myapplication;

import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CarInfo {
    String carName;
    String carNo;
    long inTime, outTime, temp, sum;
    boolean occupied = false;

    public void parkedIn(String carName, String carNo){
        this.carName = carName;
        this.carNo = carNo;
        Date checkIn = new Date();
        this.inTime = checkIn.getTime();
        occupied = true;
    }


    public void parkedOut(){
        Date checkOut = new Date();

        outTime = checkOut.getTime();

        temp = (outTime - inTime)/(1000);
        sum = temp*1000/30;

        init();
        occupied = false;

    }


    public String getDateFormat(){

        SimpleDateFormat reformat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

        return reformat.format(this.inTime);
    }

    public void init(){
        this.carName = "";
        this.carNo = "";
        this.inTime = 0;
    }


    public boolean isOccupied() {
        return occupied;
    }

    public long getSum() {
        return sum;
    }

    public long getTemp() {
        return temp;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public String getCarNo() {
        return carNo;
    }

    public void setCarNo(String carNo) {
        this.carNo = carNo;
    }

    public long getInTime() {
        return inTime;
    }

    public void setInTime(long inTime) {
        this.inTime = inTime;
    }
}
