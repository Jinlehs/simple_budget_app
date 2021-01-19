package com.example.jl6_trialbook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class NewEntry extends AppCompatActivity {

    TextView returnMain;
    EditText dateEntry, itemCost, itemQuantity, itemDesc;
    Button buttonAdd;
    public static ArrayList<Entry> entryArrayList = new ArrayList<Entry>();
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_entry);

        //Instantiate the variables
        dateEntry = findViewById(R.id.dateEntry);
        itemCost = findViewById(R.id.itemCost);
        itemQuantity = findViewById(R.id.itemQuantity);
        itemDesc = findViewById(R.id.itemDesc);
        buttonAdd = findViewById(R.id.buttonAdd);
        returnMain = findViewById(R.id.returnMain);

        //set button clicker that goes to main activity and adds an budget entry to the main log
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //push new data to main activity
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.putExtra("itemDesc",itemDesc.getText().toString());
                //testing why there is weird wording here
                //Log.e("brebs", itemDesc.getText().toString());'
                intent.putExtra("itemDate",dateEntry.getText().toString());
                intent.putExtra("itemCost",itemCost.getText().toString());
                startActivity(intent);
            }
        });


        //set button clicker that starts a new activity - main activity
        returnMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }


}