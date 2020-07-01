package com.greenmonkey47.testandroid.adapters;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.greenmonkey47.testandroid.R;

import java.util.ArrayList;

public class directoryAdapter extends BaseAdapter {
    LayoutInflater mLayoutInflator;
    ArrayList<String> file_list;
    Context context;
    public directoryAdapter(Context c, ArrayList<String> s){
        context = c;
        file_list = s;
        mLayoutInflator = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return file_list.size();
    }

    @Override
    public Object getItem(int i) {
        return file_list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        view = mLayoutInflator.inflate(R.layout.directory_item,null);
        TextView fileTV = (TextView) view.findViewById(R.id.FileTV);
        //ImageView fileIV = (ImageView) view.findViewById(R.id.fileIV);
        
        fileTV.setText(file_list.get(i).substring(file_list.get(i).lastIndexOf('/')+1));
        
        return view;
    }
}
