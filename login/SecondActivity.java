package com.ik.login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {


    TextView username,password;
    String user,pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Bundle extras = getIntent().getExtras();

        user = extras.getString("U");
        pass = extras.getString("P");

        username = findViewById(R.id.usertv);
        password = findViewById(R.id.passtv);

        username.setText(user);
        password.setText(pass);

    }
}