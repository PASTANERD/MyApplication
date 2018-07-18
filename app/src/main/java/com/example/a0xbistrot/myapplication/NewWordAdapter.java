package com.example.a0xbistrot.myapplication;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class NewWordAdapter extends BaseAdapter {
    Context context;
    ArrayList<Word> data;

    NewWordAdapter(Context context, ArrayList<Word> data){
        this.context = context;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int i) {
        return data.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view == null){
            view = View.inflate(context, R.layout.newword, null);
        }

        TextView e1 = (TextView)view.findViewById(R.id.txtword);
        TextView e2 = (TextView)view.findViewById(R.id.txtmeaning);

        Word one = data.get(i);
        e1.setText(one.getWord());
        e2.setText(one.getMeaning());

        return view;
    }
}
