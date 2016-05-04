package com.epicodus.eredivisie.ui;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.epicodus.eredivisie.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    @Bind(R.id.buttonLogin) Button mButtonLogin;
    @Bind(R.id.buttonTable) Button mButtonTable;
    @Bind(R.id.buttonFixtures) Button mButtonFixtures;
    @Bind(R.id.buttonClubs) Button mButtonClubs;
    @Bind(R.id.websiteButton) Button mWebsiteButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mButtonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        mButtonTable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TableActivity.class);
                startActivity(intent);
            }
        });

        mButtonFixtures.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FixtureActivity.class);
                startActivity(intent);
            }
        });

        mButtonClubs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ClubActivity.class);
                startActivity(intent);
            }
        });

        mWebsiteButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == mWebsiteButton) {
            Intent webIntent = new Intent(Intent.ACTION_VIEW,
                    Uri.parse("http://www.eredivisie.nl/"));
            startActivity(webIntent);
        }
    }
}
