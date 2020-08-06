package com.example.twitterclone;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    ListView simpleList;
    private String m_Text = "";

    ArrayList<String> tweetsArray = new ArrayList<>();

    CustomAdapter customAdapter;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        simpleList = (ListView) findViewById(R.id.mobile_list);
        tweetsArray.add("hawchta");
        customAdapter = new CustomAdapter(this, tweetsArray);
        simpleList.setAdapter(customAdapter);
        final MainActivity mc = this;

        simpleList.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {



            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view,
                                           int position, long id) {
                final int itemPosition = position;
                AlertDialog.Builder removeTweet = new AlertDialog.Builder(mc);
                removeTweet
                        .setTitle("Delete entry")
                        .setMessage("Are you sure you want to delete this entry?")
                        // Specifying a listener allows you to take an action before dismissing the dialog.
                        // The dialog is automatically dismissed when a dialog button is clicked.
                        .setPositiveButton("Tweet", new DialogInterface.OnClickListener() {

                            public void onClick(DialogInterface dialog, int which) {
                                tweetsArray.remove(itemPosition);
                                customAdapter.setMyList(tweetsArray);
                                Toast.makeText(MainActivity.this, "Item Deleted", Toast.LENGTH_LONG).show();
                            }
                        })

                        // A null listener allows the button to dismiss the dialog and take no further action.
                        .setNegativeButton(android.R.string.no, null);
                removeTweet.show();

                return true;
            }

        });
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()== R.id.tweetAction){
            final EditText input = new EditText(this);
// Specify the type of input expected; this, for example, sets the input as a password, and will mask the text
            input.setInputType(InputType.TYPE_CLASS_TEXT);
            AlertDialog.Builder builder = new AlertDialog.Builder(this)
                    .setTitle("Delete entry")
                    .setIcon(R.drawable.ic_action_twitter)
                    .setView(input)
                    // Specifying a listener allows you to take an action before dismissing the dialog.
                    // The dialog is automatically dismissed when a dialog button is clicked.
                    .setPositiveButton("Tweet", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            m_Text = input.getText().toString();
                            tweetsArray.add(m_Text);
                            customAdapter.setMyList(tweetsArray);
                        }
                    })

                    // A null listener allows the button to dismiss the dialog and take no further action.
                    .setNegativeButton(android.R.string.no, null);
            builder.show();
            return true;
        }
        else {
            return super.onOptionsItemSelected(item);
        }

    }
}