package com.epicodus.eredivisie.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.epicodus.eredivisie.R;

public class ClubActivity extends AppCompatActivity {
    private ListView mListView;
    private String [] clubs = new String[] {"Aalesund", "Bodø/Glimt", "Brann", "Haugesund", "Lillestrøm", "Molde", "Odd", "Rosenborg", "Sarpsborg 08", "Sogndal", "Stabæk", "Start", "Strømgodset", "Tromsø", "Vålerenga"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_club);

        mListView = (ListView) findViewById(R.id.listView);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, clubs);
        mListView.setAdapter(adapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                String clubs = ((TextView)view).getText().toString();
                Toast.makeText(ClubActivity.this, clubs, Toast.LENGTH_LONG).show();
            }
        });
    }
}
