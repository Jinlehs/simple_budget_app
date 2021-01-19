package com.example.jl6_trialbook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button buttonEntry;
    public static ArrayList<Entry> entryArrayList = new ArrayList<Entry>();
    private ListView listView;
    TextView totalBudget;
    static Integer counter = 0;
    static float budget = (float) 0.00;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //setup data
        setupData();
        //setup list
        setupList();

        //instantiate variables
        buttonEntry = findViewById(R.id.buttonEntry);
        totalBudget = findViewById(R.id.totalBudget);

        //update the total budget in the entry log
        if (counter >= 1){
            String entryCost1 = getIntent().getStringExtra("itemCost");
            budget += Integer.parseInt(entryCost1);
            String finalBudget = String.format("%.2f", budget);
            totalBudget.setText(finalBudget);
        }

        //set button click listener that starts NewEntry activity
        buttonEntry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter += 1;
                Intent intent = new Intent(getApplicationContext(), NewEntry.class);
                startActivity(intent);
            }
        });

    }
    //details for setting up data
    private void setupData() {
        //sample entry
        //Entry entry1 = new Entry("tomatoes","01/12/2020", 10);
        //entryArrayList.add(entry1);

        //get data passed from new entry
        String entryDesc = getIntent().getStringExtra("itemDesc");
        String entryDate = getIntent().getStringExtra("itemDate");
        String entryCost = getIntent().getStringExtra("itemCost");

        //add new entry to the list view
        if (counter >= 1){
            Entry entry2 = new Entry(entryDesc, entryDate, entryCost);
            entryArrayList.add(entry2);
        }

    }
    //details for setting up list
    private void setupList(){
        listView= (ListView) findViewById(R.id.entryListView);

        EntryAdapter adapter = new EntryAdapter(getApplicationContext(), 0, entryArrayList);
        listView.setAdapter(adapter);

    }

}