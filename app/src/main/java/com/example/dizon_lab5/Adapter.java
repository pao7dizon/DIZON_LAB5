package com.example.dizon_lab5;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class Adapter extends ArrayAdapter<Versions> {
    Context mContext;
    int mResouce;

    public Adapter(@NonNull Context context, int resource, @NonNull List<Versions> objects) {
        super(context, resource, objects);
        mContext = context;
        mResouce = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        int image = getItem(position).getLogo();
        String name = getItem(position).getName();
        String version = getItem(position).getVersion();
        String api = getItem(position).getApi();
        String releaseDate = getItem(position).getReleaseDate();

        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResouce, parent, false);

        TextView Name = convertView.findViewById(R.id.textView);
        TextView Version = convertView.findViewById(R.id.textView2);
        TextView API = convertView.findViewById(R.id.textView3);
        TextView ReleaseDate = convertView.findViewById(R.id.textView4);
        ImageView Logo = convertView.findViewById(R.id.imageView);

        Logo.setImageResource(image);
        Name.setText(name);
        API.setText(api);
        Version.setText(version);
        ReleaseDate.setText(releaseDate);

        return convertView;
    }
}