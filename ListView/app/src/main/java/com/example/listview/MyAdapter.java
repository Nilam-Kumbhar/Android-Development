package com.example.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;

public class MyAdapter extends ArrayAdapter<String> {

    Context context;
    ArrayList<String> list;

    public MyAdapter(Context context, ArrayList<String> list) {
        super(context, R.layout.row_layout, list);
        this.context = context;
        this.list = list;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(context)
                    .inflate(R.layout.row_layout, parent, false);
        }

        TextView txtName = convertView.findViewById(R.id.txtName);



        txtName.setText(list.get(position));





        return convertView;
    }
}
