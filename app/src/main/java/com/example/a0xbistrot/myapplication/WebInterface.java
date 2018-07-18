package com.example.a0xbistrot.myapplication;

import android.content.Context;
import android.webkit.JavascriptInterface;
import android.widget.Toast;

public class WebInterface {
    Context context;

    WebInterface(){}

    WebInterface(Context context){
        this.context = context;

    }


    @JavascriptInterface
    public void displayToast(int index){
        String msg = "";
        if(index == 1){
            msg = "블루베리는 몸에 좋다.";
        }
        else if(index == 2){
            msg = "오렌지는 몸에 좋다.";
        }
        else
            msg = "딸기는 몸에 좋다";
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }


}
