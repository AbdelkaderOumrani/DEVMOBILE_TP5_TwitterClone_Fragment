package com.example.twitterclone;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.twitterclone.R;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class CustomAdapter extends BaseAdapter {
    Context context;
    ArrayList<String> itemsList;
    LayoutInflater inflter;

    public CustomAdapter(Context applicationContext, ArrayList<String> itemsList) {
        this.context = context;
        this.itemsList = itemsList;
        inflter = (LayoutInflater.from(applicationContext));
    }

    @Override
    public int getCount() {
        return itemsList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflter.inflate(R.layout.activity_list_item, null);
        TextView item = (TextView) view.findViewById(R.id.tweetMessage);
        TextView item2 = (TextView) view.findViewById(R.id.person);
        item.setText(itemsList.get(i));
        item2.setText("Abdelkader Oumrani");
        return view;
    }

    public void setMyList(ArrayList<String> myListOfObjects) {
        this.itemsList = myListOfObjects;
        this.notifyDataSetChanged();
    }
}