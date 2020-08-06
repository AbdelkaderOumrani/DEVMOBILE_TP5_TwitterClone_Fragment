package com.example.twitterclone;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;

public class ListItem extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_item);
    }

    @Override
    public boolean onKeyLongPress(int keyCode, KeyEvent event) {
        Log.i("attempDeelet","delete");
        return super.onKeyLongPress(keyCode, event);
    }
}