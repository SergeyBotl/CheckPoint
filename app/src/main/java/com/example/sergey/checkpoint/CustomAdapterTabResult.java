package com.example.sergey.checkpoint;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.sergey.checkpoint.entity.Comanda;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapterTabResult extends ArrayAdapter<Comanda> {

    private Context context;
    private int resource;
    private List<Comanda> list = new ArrayList<>();

    public CustomAdapterTabResult(Context context, int resource, List<Comanda> list) {
        super(context, resource, list);
        this.context = context;
        this.resource = resource;
        this.list = list;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
       ViewHolder holder;
        Comanda result = list.get(position);
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(resource, null);

            holder = new ViewHolder();

            holder.textComanda = (TextView) convertView.findViewById(R.id.textViewComanda1);
            holder.textBall = (TextView) convertView.findViewById(R.id.textViewBall1);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.textComanda.setText(result.getNameComanda());
       holder.textBall.setText(result.getSumBall()+"");

        return convertView;
    }

    private class ViewHolder {

        TextView  textComanda, textBall;

    }
}
