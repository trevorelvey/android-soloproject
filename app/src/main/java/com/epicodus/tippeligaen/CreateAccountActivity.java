package com.epicodus.tippeligaen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import butterknife.Bind;
import butterknife.ButterKnife;

public class CreateAccountActivity extends AppCompatActivity {
    public static final String TAG = CreateAccountActivity.class.getSimpleName();
    private Button mButtonAccountConfirm;
    private EditText mEditTextCreateUsername;
    private EditText mEditTextCreatePassword;
    private EditText mEditTextConfirmPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
        ButterKnife.bind(this);

        mEditTextCreateUsername = (EditText) findViewById(R.id.editTextCreateUsername);
        mButtonAccountConfirm = (Button) findViewById(R.id.buttonAccountConfirm);
        mButtonAccountConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = mEditTextCreateUsername.getText().toString();
                Intent intent = new Intent(CreateAccountActivity.this, ConfirmAccountActivity.class);
                intent.putExtra("username", username);
                startActivity(intent);
            }
        });

        Spinner spinner = (Spinner) findViewById(R.id.spinnerFavoriteSelect);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.favorite_teams, android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }
}
