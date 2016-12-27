package com.example.sergey.checkpoint;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.sergey.checkpoint.entity.Result;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends ArrayAdapter<Result> {

    private Context context;
    private int resource;
    private List<Result> list = new ArrayList<>();

    public CustomAdapter(Context context, int resource, List<Result> list) {
        super(context, resource, list);
        this.context = context;
        this.resource = resource;
        this.list = list;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        Result result = list.get(position);
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(resource, null);

            holder = new ViewHolder();

            holder.textDate = (TextView) convertView.findViewById(R.id.textViewDate);
            holder.textComanda = (TextView) convertView.findViewById(R.id.textViewComanda);
            holder.textBall = (TextView) convertView.findViewById(R.id.textViewBall);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.textDate.setText( result.getDate());
        holder.textComanda.setText(result.getNameComanda().getNameComanda());
        holder.textBall.setText(result.getBall());


        return convertView;
    }

    private class ViewHolder {

        TextView textDate, textComanda, textBall;

    }
}
